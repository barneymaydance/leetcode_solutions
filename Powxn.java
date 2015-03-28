//O(log(n)) runtime
//O(1) space
// two base method, similar to Divide Two Integer

public class Solution {
    public double pow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        double res=1.0;
        if(n<0){
            x=1.0/x;
            if(n==Integer.MIN_VALUE){
                res*=x;
                n++;
            }
        }
        n=Math.abs(n);
        boolean isNeg=false;
        if(x<0&&n%2==1){
            isNeg=true;
        }
        x=Math.abs(x);
        while(n/2!=0){
            if (n%2==1){
                if(res>Double.MAX_VALUE/x){
                    return Double.MAX_VALUE;
                }
                res*=x;
            }
            x=x*x;
            n=n/2;
        }
        return isNeg?-1*res*x:res*x;
    }
}

// binary search, recursive method
// take a second look
double pow(double x, int n) {
    if (n == 0) return 1.0;
    double half = pow(x, n/2);
    if (n%2 == 0)
    {
        return half*half;
    }
    else if (n>0)
    {
        return half*half*x;
    }
    else
    {
        return half/x*half;
    }
}