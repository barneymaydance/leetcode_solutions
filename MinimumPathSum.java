//O(m*n) runtime
//O(n) space , it can be O(min(m,n))

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int n=grid.length;
        int m=grid[0].length;
        int[] res=new int[m];
        res[0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j>0){
                    res[j]=res[j-1]+grid[i][j];
                }
                else if(i>0&&j==0){
                    res[j]=res[j]+grid[i][j];
                }
                else if(i!=0&&j!=0){
                    res[j]=Math.min(res[j],res[j-1])+grid[i][j];
                }
            }
        }
        return res[m-1];
    }
}