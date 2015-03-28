//O(n^2) runtime
//O(k) space   O(1) extra space

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows<1){
            return res;
        }
        List<Integer> temp=new ArrayList<Integer>();
        temp.add(1);
        res.add(new ArrayList<Integer>(temp));
        for(int i=2;i<=numRows;i++){
            for(int j=temp.size()-1;j>0;j--){
                temp.set(j,temp.get(j)+temp.get(j-1));
            }
            temp.add(1);
            res.add(new ArrayList<Integer>(temp));
        }
        return res;
        
    }
}