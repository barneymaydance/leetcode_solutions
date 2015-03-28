//O(n) time
//O(1) space
//dynamic programming
// use two variable to recode the index of i-1 and i-2 's value

public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        int r1=1;
        int r2=1;
        for(int i=1;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=s.charAt(i-1);
            if(c1=='0'){
                r1=0;
            }
            if(c2=='1'||(c2=='2'&&c1<='6')){
                r1=r1+r2;
                r2=r1-r2;
            }
            else{
                r2=r1;
            }
        }
        return r1;
    }
}