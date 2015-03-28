//O(n) runtime
//O(1) space
//dp, use two variables to maintain a local max and global max

public class Solution {
    public int maxSubArray(int[] A) {
        if(A==null||A.length==0){
            return Integer.MIN_VALUE;
        }
        int maxSum=A[0];
        int sum=A[0];
        for(int i=1;i<A.length;i++){
            sum=Math.max(A[i],A[i]+sum);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

//Subproblem: t[i] is the maximum sum when the subsequence ends at ith element
/* Recurrence: t[i] = max(A[i],A[i]+t[i-1])
                     if A[i] is larger, it means the last sequence ends and an new one starts
                     if A[i]+t[i-1 is larger, it means the last sequence increases
Base Cases: t[0] = 0 which means sum of no element is 0
**/
public int maxSubArray(int[] A) {

    int[] t = new int[A.length+1];

    t[0] = 0;
    int max = Integer.MIN_VALUE;

    for(int i = 1; i <= A.length;i++){

        t[i] = Math.max(A[i-1],A[i-1] + t[i-1]);
        max = Math.max(t[i],max);
    }

    return max;
}