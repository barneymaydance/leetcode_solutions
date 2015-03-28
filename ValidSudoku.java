//O(3*n^2)=O(n^2) runtime
//O(1) space?


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9)
            return false;
        
        for(int i=0;i<9;i++){
            boolean[] temp=new boolean[10];
            for(int j=0;j<9;j++){
                if('1'<=board[i][j]&&board[i][j]<='9'){
                    int index=(int)(board[i][j]-'0');
                    if(temp[index]==false){
                        temp[index]=true;
                    }
                    else{
                        return false;
                    }
                }
                else if(board[i][j]!='.'){
                    return false;
                }
            }
        }
        
        for(int j=0;j<9;j++){
            boolean[] temp=new boolean[10];
            for(int i=0;i<9;i++){
                if('1'<=board[i][j]&&board[i][j]<='9'){
                    int index=(int)(board[i][j]-'0');
                    if(temp[index]==false){
                        temp[index]=true;
                    }
                    else{
                        return false;
                    }
                }
                else if(board[i][j]!='.'){
                    return false;
                }
            }
        }
        
        
        for(int k=0;k<9;k++){
            boolean[] temp=new boolean[10];
            int r=k/3;
            int c=k%3;
            for(int i=c*3;i<(3+c*3);i++){
                for(int j=r*3;j<(3+r*3);j++){
                    if('1'<=board[i][j]&&board[i][j]<='9'){
                        int index=(int)(board[i][j]-'0');
                        if(temp[index]==false){
                            temp[index]=true;
                        }
                        else{
                            return false;
                        }
                    }
                    else if(board[i][j]!='.'){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}