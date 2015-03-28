// in every layer, you still only consider digit appearing once


public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0){
            return res;
        }
        
        Arrays.sort(num);
        helper(num,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    
    private void helper(int[] num,int target,List<List<Integer>> res, ArrayList<Integer> temp,int start){
        if(target==0){
            //if(!res.contains(temp))
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<num.length;i++){
            if(i>start && num[i]==num[i-1])  
                continue;
            temp.add(num[i]);
            helper(num,target-num[i],res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}