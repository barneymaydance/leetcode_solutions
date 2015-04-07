//
//O(1) space
// similar to Excel Sheet Column Title

public class Solution {
    public int titleToNumber(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int res=0;
        for(int i=0,d=0;i<s.length();i++,d++){
            res=(s.charAt(i)-'A'+1)+res*26;
        }
        return res;
    }
}