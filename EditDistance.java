//O(n*m) time , n stands for  string word1's length, m stands for string word2's length
//O(n*m) space, it could be O(min(n,m))
//recursive formula 

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        int n=word1.length();
        int m=word2.length();
        int[][] res=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            res[i][0]=i;
            
        }
        for(int j=1;j<=m;j++){
            res[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    res[i][j]=res[i-1][j-1];
                }
                else{
                    res[i][j]=1+Math.min(res[i-1][j-1],Math.min(res[i-1][j],res[i][j-1]));
                }
            }
        }
        return res[n][m];
        
        
    }
}
