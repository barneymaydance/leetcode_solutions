//O(n) runtime
//O(n) space, it can be less extra space O(1) 

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0)
            return true;
        StringBuilder str= new StringBuilder();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if('a'<=s.charAt(i)&&s.charAt(i)<='z'||'0'<=s.charAt(i)&&s.charAt(i)<='9'){
                str.append(s.charAt(i));
            }
        }
        String string=str.toString();
        String sRev=str.reverse().toString();
        return string.equals(sRev);
    }
}

//O(1)  space method