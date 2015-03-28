//O(n) time
//O(1) space

public class Solution {
    public int maxProduct(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int maxGlobal=A[0];
        int maxLocal=A[0];
        int minLocal=A[0];
        
        for(int i=1; i<A.length;i++){
            int tempLocal=maxLocal;
            maxLocal=Math.max(A[i],Math.max(maxLocal*A[i],minLocal*A[i]));
            minLocal=Math.min(A[i],Math.min(tempLocal*A[i],minLocal*A[i]));
            maxGlobal=Math.max(maxGlobal,maxLocal);
        }
        return maxGlobal;
    }
}