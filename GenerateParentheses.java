//Catalan number    Cn=(2n)!/((n+1)!n!)
//using recursive method

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n<1){
            return res;
        }
        helper(res,n,n,new String());
        return res;
    }
    
    private void helper(List<String> res,int l,int r, String item){
        if(r<l)
            return;
        if(r==0&&l==0){
            res.add(item);
        }
        if(l>0){
            helper(res,l-1,r,item+'(');
        }
        if(r>0){
            helper(res,l,r-1,item+')');
        }
            
    }
}