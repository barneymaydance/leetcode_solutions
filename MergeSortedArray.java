//O(m+n) runtime
//O(1) space
//merge from the tail to head.

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(A==null||B==null){
            return;
        }
        int i=m-1,j=n-1,idx=m+n-1;
        while(i>=0&&j>=0){
            if(A[i]<B[j]){
                A[idx--]=B[j--];
            }
            else{
                A[idx--]=A[i--];
            }
        }
       while(j>=0){
           A[idx--]=B[j--];
       }
        
    }
}