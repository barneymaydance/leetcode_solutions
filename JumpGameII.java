//O(n) runtime
//O(1) space
//greedy algorithm
//use a variable to record last time reach max jump/index/reach

public class Solution {
    public int jump(int[] A) {
        if(A==null||A.length==0){
            return Integer.MAX_VALUE;
        }
        
        int reach=0;
        int step=0;
        int lastReach=0;
        for(int i=0;i<A.length&&i<=reach;i++){
            if(i>lastReach){
                step++;
                lastReach=reach;
            }
            reach=Math.max(reach,i+A[i]);
        }
        if(reach<A.length-1){
            return Integer.MAX_VALUE;
        }
        return step;
       
    }
}

//method 2 , record the min path into a list  
//O(n) runtime
//O(k) space
public class Solution {
    public int jump(int[] A) {
        int lastReach = 0, reach = 0, best = 0;
        List<Integer> steps = new ArrayList<Integer>();
        
        for (int i = 0; i < A.length; i++) {
            if (i > lastReach) {
                lastReach = reach;
                steps.add(best);
            }
            if(i+A[i] > reach) {
                reach = i+A[i];
                best = i;
            }
        }  
        return steps.size();
    }
}