//O(m*n) time
//O(m+n) space

public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length<=1||board[0].length<=1)
            return;
        int n= board.length;
        int m= board[0].length;
        for(int i=0;i<n;i++){
            fill(board,i,0);
            fill(board,i,m-1);
        }
        for(int j=0;j<m;j++){
            fill(board,0,j);
            fill(board,n-1,j);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void fill(char[][] board,int i,int j){
        if(board[i][j]=='X')
            return;
        board[i][j]='#';
        int n=board.length;
        int m=board[0].length;
        int code = i*m+j;
        LinkedList<Integer> queue =new LinkedList<Integer>();
        queue.add(code);
        while(!queue.isEmpty()){
            code=queue.poll();
            int row=code/m;
            int col=code%m;
            if(col>0&&board[row][col-1]=='O'){
                board[row][col-1]='#';
                queue.add(row*m+col-1);
            }
            if(col<m-1&&board[row][col+1]=='O'){
                board[row][col+1]='#';
                queue.add(row*m+col+1);
            }
            if(row<n-1&&board[row+1][col]=='O'){
                board[row+1][col]='#';
                queue.add((row+1)*m+col);
            }
            if(row>0&&board[row-1][col]=='O'){
                board[row-1][col]='#';
                queue.add((row-1)*m+col);
            }
        }
    }
}