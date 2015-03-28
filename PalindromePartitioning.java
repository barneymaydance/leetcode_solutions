//
//

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null||s.length()==0){
            return res;
        }
        helper(s,res,new ArrayList<String>(),0,s.length());
        return res;
    }
    private void helper(String s,List<List<String>> res, List<String> temp,int idx,int len){
        if(idx==len){
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String slice=s.substring(0,i);
            if(isPalindrome(slice)){
                temp.add(slice);
                helper(s.substring(i),res,temp,idx+i,len);
                temp.remove(temp.size()-1);
            }
            
        }
        
    }
    private boolean isPalindrome(String str){
        if(str==null||str.length()==0){
            return true;
        }
        int left=0;
        int right= str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
        
    }
}