//O(n*m) time
//O(n*m) space , could be O(min(n,m))
// Dynamic Programming, simialr to Unique Paths

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int n= s1.length();
        int m= s2.length();
        boolean[][] res = new boolean[n+1][m+1];
        res[0][0]=true;
        for(int i=1;i<=n;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                res[i][0]=true;
        }
        for(int j=1;j<=m;j++){
            if(s2.charAt(j-1)==s3.charAt(j-1))
                res[0][j]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                res[i][j]=res[i-1][j]&&(s3.charAt(i-1+j)==s1.charAt(i-1))||res[i][j-1]&&(s3.charAt(i-1+j)==s2.charAt(j-1));
            }
        }
        return res[n][m];
    }
}