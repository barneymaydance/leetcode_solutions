//O(2^n) runtime
//O(1) space
// need sort the array, and consider the duplicate case

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        helper(new boolean[num.length],res,num,new ArrayList<Integer>());
        return res;
    }
    
    private void helper(boolean[] used,List<List<Integer>> res,int[] num, List<Integer> temp ){
        if(temp.size()==num.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=0;i<num.length;i++){
            if(i!=0&&!used[i-1]&&num[i]==num[i-1])
                continue;
            if(!used[i]){
                used[i]=true;
                temp.add(num[i]);
                helper(used,res,num,temp);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
}