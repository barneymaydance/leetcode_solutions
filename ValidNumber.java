//O(n)
//O(1)
// first need to trim the front and end space
// consider first sign '-' and '+'
// consider second sign '-' and '+' must appearing after 'e' or 'E'
// consider the only sign or exp corner case
// '-','+' or 'e', 'E' only appear one or two, '.' can't appear after 'e'
// scientific notation a*10^b, the b must be an integer, and b can have a negative or positive sign


public class Solution {
    public boolean isNumber(String s) {
        if(s==null)
            return false;
        s=s.trim();
        if(s.length()==0)
            return false;
        int len=s.length();
        int i=0;
        if(s.charAt(i)=='-'||s.charAt(i)=='+') i++;
        boolean period=false;
        boolean exp=false;
        boolean num=false;
        while(i<len){
            char c= s.charAt(i);
            if('0'<=c&&c<='9'){
                num=true;
            }
            else if(c=='.'){
                if(exp||period)
                    return false;
                period=true;
            }
            else if(c=='e'||c=='E'){
                if(exp||(!num))
                    return false;
                exp=true;
                num=false;
            }
            else if(c=='-'||c=='+'){
                if(s.charAt(i-1)!='e'&&s.charAt(i-1)!='E')
                    return false;
            }
            else{
                return false;
            }
            i++;
        }
        if((!num)&&(period||exp))
            return false;
        return true;
        
    }
}