//O(2^n)
//O(2^n)

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(S==null||S.length==0){
            return res;
        }
        Arrays.sort(S);
        for(int size=0;size<=S.length;size++){
            helper(S,0,size,new ArrayList<Integer>(),res);
        }
        return res;
    }
    private void helper(int[] S,int start, int size, List<Integer> temp, List<List<Integer>> res){
        if (size==0){
            res.add(new ArrayList<Integer>());
            return;
        }
        if(size==temp.size()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=start;i<S.length;i++){
            temp.add(S[i]);
            helper(S,i+1,size,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}