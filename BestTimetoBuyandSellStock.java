//O(n) time
//O(1) space
//simialr to Maximum Subarray

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int profit=Integer.MIN_VALUE;
        int lowBuy=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            lowBuy=Math.min(lowBuy,prices[i]);
            profit=Math.max(profit,prices[i]-lowBuy);
        }
        return profit;
    }
}