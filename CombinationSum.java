//NP complete problem
// first sort the array


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0){
            return res;
        }
        Arrays.sort(candidates); 
        helper(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    
    private void helper(int[] candidates,int target,List<List<Integer>> res,ArrayList<Integer> temp,int start){
        if(target==0){
            res.add(new ArrayList(temp));
            return;
        }
        if(target<0){
            return;
        }
        
        for(int i=start;i<candidates.length;i++){
            if(i>0 && candidates[i]==candidates[i-1])  
                continue;  
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],res,temp,i);
            temp.remove(temp.size()-1);
            
        }
        
    }
}