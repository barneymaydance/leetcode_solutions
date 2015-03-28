//O(m*n*4^(len(word)))   n*m char, target string len
//O(n) at least 
// it is a graph problem , depth first search, O(E+V)

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        if(word==null||word.length()==0){
            return true;
        }
        int n=board.length;
        int m=board[0].length;
        if(m*n<word.length()){
            return false;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(helper(board,word,0,i,j,new boolean[n][m])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word,int idx,int i,int j,boolean[][] used){
        if(idx==word.length()){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||word.charAt(idx)!=board[i][j]||used[i][j])
            return false;
        used[i][j]=true;
        boolean res= helper(board,word,idx+1,i+1,j,used)||helper(board,word,idx+1,i-1,j,used)||helper(board,word,idx+1,i,j+1,used)||helper(board,word,idx+1,i,j-1,used);
        used[i][j]=false;
        return res;
    } 
}