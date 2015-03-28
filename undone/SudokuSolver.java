//
//
//N-P complete problem
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9)
            return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board,int i,int j){
        if(j>=9){
            return helper(board,i+1,0);
        }
        if(i==9){
            return true;
        }
        if(board[i][j]=='.'){
            for(int k=1;k<=9;k++){
                char c=(char)(k+'0');
                board[i][j]=c;
                if(isValid(board,i,j)&&helper(board,i,j+1)){
                    return true;
                }
                board[i][j]='.';
            }
        }
        else{
            return helper(board,i,j+1);
        }
        return false;
    }
    private boolean isValid(char[][] board, int i, int j){
        for(int k=0;k<9;k++){
            if(k!=j&&board[i][j]==board[i][k]){
                return false;
            }
        }
        for(int k=0;k<9;k++){
            if(k!=i&&board[i][j]==board[k][j]){
                return false;
            }
        }
        for(int k=0;k<9;k++){
            int row=k/3+i/3*3;
            int col=k%3+j/3*3;
            if(row!=i&&col!=j&&board[i][j]==board[row][col]){
                return false;
            }
        }
        return true;
    }
}