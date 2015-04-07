//O(m*n) time
//O(m*n) space
//bottom - up dp
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] health = new int[m][n];
        health[m-1][n-1]=Math.max(1,1-dungeon[m-1][n-1]);
       
        for(int i=m-2;i>=0;i--){
            health[i][n-1]=Math.max(1,health[i+1][n-1]-dungeon[i][n-1]);
        }
        for(int j=n-2;j>=0;j--){
            health[m-1][j]=Math.max(1,health[m-1][j+1]-dungeon[m-1][j]);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                health[i][j]=Math.max(1,Math.min(health[i+1][j],health[i][j+1])-dungeon[i][j]);
            }
        }
        return health[0][0];
    }
}