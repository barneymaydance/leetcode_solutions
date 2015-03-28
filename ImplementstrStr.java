//O(n*m) runtime    is not the best, best can be O(n)
//O(1) space
// need to consider 2 corner cases
//judge n-m+1 substirngs 

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null)
            return -1;
        if(needle.length()==0)
            return 0;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            boolean flag=true;
            for(int j=i;j-i<needle.length();j++){
                if(haystack.charAt(j)!=needle.charAt(j-i)){
                    flag=false;
                    break;
                }
            }
            if (flag)
                return i;
        }
        return -1;
    }
}