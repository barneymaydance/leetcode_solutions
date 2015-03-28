//O(n) time
//O(1) space
//greedy algorithm, only need to consider each node for once
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || gas.length==0 || cost==null || cost.length==0 || gas.length!=cost.length)
            return -1;
        int idx=0;
        int total=0;
        int sum=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                idx=i+1;
            }
        }
        return total>=0?idx:-1;
    }
}