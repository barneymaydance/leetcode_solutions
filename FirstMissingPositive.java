//O(n) runtime
//O(1) space
//Counting sort, linear sort method

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A==null||A.length==0){
            return 1;
        }
        int range=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>range)
                range=A[i];
        }
        int[] count=new int[range];
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                count[(A[i]-1)]+=1;
            }
        }
        for(int i=0;i<range;i++){
            if(count[i]==0){
                return i+1;
            }
        }
        return range+1;
    }
}

// use the space of A array
public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A==null||A.length==0){
            return 1;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]>0&&A[i]<A.length&&A[A[i]-1]!=A[i]){
                int temp=A[A[i]-1];
                A[A[i]-1]=A[i];
                A[i]=temp;
                i--;
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1){
                return i+1;
            }
        }
        return A.length+1;
    }
}
