//O(n^2) rumtime
//O(1) space


public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0){
            return null;
        }
        int[][] res= new int[n][n];
        helper(res,0,n-1,0,n-1,1);
        return res;
    }
    private void helper(int[][] res, int i_start,int i_end, int j_start, int j_end,int index ){
        if(i_start>i_end||j_start>j_end){
            return;
        }
        if(i_start==i_end&&j_start==j_end){
            res[i_start][j_start]=index;
            return;
        }
        
        for(int j=j_start;j<j_end;j++){
            res[i_start][j]=index;
            index++;
        }
        for(int i=i_start;i<i_end;i++){
            res[i][j_end]=index;
            index++;
        }
        for(int j=j_end;j>j_start;j--){
            res[i_end][j]=index;
            index++;
        }
        for(int i=i_end;i>i_start;i--){
            res[i][j_start]=index;
            index++;
        }
        helper(res,i_start+1,i_end-1,j_start+1,j_end-1,index);
    }
}