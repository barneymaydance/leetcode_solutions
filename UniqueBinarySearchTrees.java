//O(n^2) time, could be O(n) use the Catalan number
//O(n) space

public class Solution {
    public int numTrees(int n) {
        if(n<=0){
            return -1;
        }
        int res[]=new int[n+1];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                res[i]=res[i]+res[j]*res[i-1-j];
            }
        }
        return res[n];
    }
}