//O(2^n) time
//O(2^n) space, O(1) extra space

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n<0){
            return res;
        }
        if(n==0){
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for(int idx=2;idx<=n;idx++){
            int size=res.size();
            for(int i=size-1;i>=0;i--){
                res.add(res.get(i)|(1<<(idx-1)));
            }
        }
        return res;
    }
}

