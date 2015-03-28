//O(n* string_length) runtime ? O(2^n)
//O(string_length) space

public class Solution {
    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        String res="1";
        for(int i=2;i<=n;i++){
            StringBuilder str=new StringBuilder();
            int count=1;
            for(int j=1;j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1)){
                    count++;
                }
                else{
                    str.append(count);
                    str.append(res.charAt(j-1));
                    count=1;
                }
            }
            str.append(count);
            str.append(res.charAt(res.length()-1));
            res=str.toString();
        }
        return res;
        
        
    }
}