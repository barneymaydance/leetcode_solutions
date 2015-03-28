//O(n*m) runtime
//O(min(n,m) space
// dynamic programming, use a array to restore each row or coloum's result, then renew it column by column or row by row
// the res[i][j]=res[i-1][j]+res[i][j-1]
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0)
            return 0;
        if(m<n){
            int temp=m;
            m=n;
            n=temp;
        }
        int[] res=new int[n];
        res[0]=1;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                res[j]+=res[j-1];
            }
        }
        return res[n-1];
    }
}

//use the combination formula, need to consider the overflow problem
//BigInteger
import java.math.*;
public class Solution {
    public int uniquePaths(int m, int n) {
        int j=m+n-2;
        int i=n-1;
        return combination(i,j);
    }
    private int combination(int i,int j){
        if(i*2>j)
            i=j-i;
        if(i==0||i==j)
            return 1;
        BigInteger s1=BigInteger.ONE;
        for(int p=j,q=i;q>0;p--,q--){
            s1=s1.multiply(BigInteger.valueOf(p));
        }
        for(int p=j,q=i;q>0;p--,q--){
            s1=s1.divide(BigInteger.valueOf(q));
        }
        return s1.intValue();
    }
}
//long type
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0|n<=0)
            return -1;
        int j=m+n-2;
        int i=n-1;
        return combination(i,j);
    }
    private int combination(int i,int j){//j choose i
        if(i*2>j)
            i=j-i;
        if(i==0)
            return 1;
        long jCi=1;
        for(int k=0;k<i;k++){
            jCi=jCi*(j-k)/(k+1);
        }
        return (int)jCi;
    }
}




// brute force method, bad method, runtime is exponential?
public int uniquePaths(int m, int n) {
    return helper(1,1,m,n);
}
private int helper(int row, int col, int m, int n)
{
    if(row==m && col==n)
        return 1;
    if(row>m || col>n)
        return 0;
    return helper(row+1,col,m,n)+helper(row,col+1,m,n);
}
