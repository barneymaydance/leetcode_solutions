//O(n) runtime, it can be better O(log(n)) runtime use 
//O(1) space
//dynampic programming
// The problem is actual Fibonacci sequence f(n)=f(n-1)+f(n-2)

public class Solution {
    public int climbStairs(int n) {
        if(n<0){
            return -1;
        }
        if(n<2){
            return n;
        }
        
        int f0=1;
        int f1=1;
        int fn=0;
        for(int i=2;i<=n;i++){
            fn=f1+f0;
            f0=f1;
            f1=fn;
        }
        return fn;
    }
}