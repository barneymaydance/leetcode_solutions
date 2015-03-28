//should be O(2^n)
//should be O(2^n)
//N-P complete

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0){
            return res;
        }
        Arrays.sort(num);
        for(int i=0;i<=num.length;i++){
            helper(num,res,new ArrayList<Integer>(),0,i);
        }
        return res;
    }
    private void helper(int[] num,List<List<Integer>> res, List<Integer> temp,int start,int len){
        if(temp.size()==len){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=start;i<num.length;i++){
            if(i!=start&&num[i]==num[i-1]){
                continue;
            }
            temp.add(num[i]);
            helper(num,res,temp,i+1,len);
            temp.remove(temp.size()-1);
        }
    }
}

