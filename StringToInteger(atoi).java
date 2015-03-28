// corner case : 1.  if the sign is negative or positive.  2. overflows

public class Solution {
    public int atoi(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        str=str.trim();
        int sign=1;
        long res=0;
        int i=0;
        if(str.charAt(0)=='-'){
            sign=-1;
            i++;
        }
        else if (str.charAt(0)=='+'){
            i++;
            s
        }
        
        while(i<str.length()){
            if('0'>str.charAt(i)||str.charAt(i)>'9'){
                break;
            }
            else{
                int digit=(int)(str.charAt(i)-'0');
                res=res*10+digit;
                if((res*sign)<Integer.MIN_VALUE&&sign==-1){
                    return Integer.MIN_VALUE;
                }
                else if(res>Integer.MAX_VALUE&&sign==1){
                    return Integer.MAX_VALUE;
                }
                i++;  
            }
            
        }
        res=res*sign;
        return (int)res;
        
    }
}