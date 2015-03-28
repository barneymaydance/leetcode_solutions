//O(n) runtime
//O(1) space
// change with the last member

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A==null||A.length==0)
            return 0;
        int p=A.length-1;
        int i=0;
        while(i<=p){
            if(A[i]==elem){
                A[i]=A[p];
                p--;
            }
            else{
                i++;
            }
        }
        return p+1;
    }
}