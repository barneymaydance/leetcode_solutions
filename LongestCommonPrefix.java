//brute force
// O(m*n) runtime, m stands for the max string length, n stands for the number of the strings.
//O(m) space

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        StringBuilder res=new StringBuilder();
        int i=0;
        boolean stop=true;
        while(stop){
            for(String str:strs){
                if(str.length()-1<i||str.charAt(i)!=strs[0].charAt(i)){
                    stop=false;
                    break;
                }
            }
            if(stop)
                res.append(strs[0].charAt(i));
            i++;
        }
        return res.toString();
    }
}