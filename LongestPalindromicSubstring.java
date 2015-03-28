//runtime O(n^2)  Space O(1)    two conditions 1."abcdcba", 2."abcddcba", start at the center to compare.

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String result="";
        
        for(int i=0;i<s.length();i++){
            String temp=findPalindrome(s,i,i);
            if (temp.length()>result.length()){
                result=temp;
            }
            temp=findPalindrome(s,i,i+1);
            if (temp.length()>result.length()){
                result=temp;
            }
        }
        return result;
    }
    
    private String findPalindrome(String s, int i, int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}