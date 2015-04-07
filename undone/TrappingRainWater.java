//O(n) time
//O(n) space
//use a array to store the leftbar and right bar,
//first travsere from left to right, second, from right to left

public class Solution {
    public int trap(int[] A) {
        if(A==null||A.length<=2){
            return 0;
        }
        int leftBar=0;
        int res=0;
        int[] containers = new int[A.length];
        for(int i=0;i<A.length;i++){
            containers[i]=leftBar;
            leftBar=Math.max(leftBar,A[i]);
        }
        int rightBar=0;
        for(int i=A.length-1;i>=0;i--){
            containers[i]=Math.min(rightBar,containers[i]);
            rightBar=Math.max(rightBar,A[i]);
            res+=containers[i]-A[i]>0?containers[i]-A[i]:0;
        }
        return res;
    }
}
}