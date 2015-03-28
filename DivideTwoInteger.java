//O(log(n)) runtime
//O(n) space?
//corner case , if divisor ==0. num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
 //convert it to long type  for overflow
 

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0)
            return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long r=0;
        
        while(a>=b){
            long temp=b;
            int rest=1;
            while(temp<=a){
                r+=rest;
                a-=temp;
                rest<<=1;
                temp<<=1;
            }
        }
        r=(((dividend ^ divisor) >>>31) == 1) ? -r: r;
        if(r>Integer.MAX_VALUE||r<Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)r;
    }
}