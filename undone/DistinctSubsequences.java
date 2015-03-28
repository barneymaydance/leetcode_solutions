//O(m*n) time
//O(m*n) space, can be better O(m)

public class Solution {
    public int numDistinct(String S, String T) {
        if(T==null||T.length()==0)
            return 1;
        if(S==null||S.length()==0)
            return 0;
        int n=S.length();
        int m=T.length();
        if(m>n)
            return 0;
        int[][] res = new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            res[0][j]=1;
        }
        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                res[i][j]=res[i][j-1];
                if(S.charAt(j-1)==T.charAt(i-1)){
                    res[i][j]+=res[i-1][j-1];
                }
            }
        }
        return res[m][n];
        
    }
}