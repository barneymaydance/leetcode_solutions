//O(2^n) runtime
//O(1) space

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k>n)
            return res;
        helper(res,n,k,new ArrayList<Integer>(),1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, int k, ArrayList<Integer> temp, int start){
        if(k==temp.size()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=start;i<=n;i++){
            temp.add(i);
            helper(res,n,k,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}