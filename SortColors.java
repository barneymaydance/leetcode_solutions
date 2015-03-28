//O(n) time
//O(k+n) space, it can be better O(1)
// counting sort, linear sort

public class Solution {
    public void sortColors(int[] A) {
        if(A==null||A.length==0){
            return;
        }
        int[] C= new int[3];
        int[] B= new int[A.length];
        for(int i=0;i<A.length;i++){
            C[A[i]]=C[A[i]]+1;
        }
        for(int i=1;i<C.length;i++){
            C[i]=C[i]+C[i-1];
        }
        for(int i=0;i<A.length;i++){
            B[C[A[i]]-1]=A[i];
            C[A[i]]=C[A[i]]-1;
        }
        for(int i=0;i<A.length;i++){
            A[i]=B[i];
        }
    }
}

//O(n) time
//O(1) space
// use two points to decide zero and one end positions
public class Solution {
    public void sortColors(int[] A) {
        if(A==null||A.length==0){
            return;
        }
        int idx0=0;
        int idx1=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                A[i]=2;
                A[idx1++]=1;
                A[idx0++]=0;
            }
            else if(A[i]==1){
                A[i]=2;
                A[idx1++]=1;
            }
        }
    }
}

