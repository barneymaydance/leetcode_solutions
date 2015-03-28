//O(log(n)) runtime
//O(1) space
//binary search, need to consider the int overflow when apply mid *mid==x

public class Solution {
    public int sqrt(int x) {
        if(x<0){
            return -1;
        }
        if (x==0){
            return 0;
        }
        int left=1;
        int right=x/2+1;
        int mid=1;
        while(left<=right){
            mid=(right+left)/2;
            if(mid==x/mid){
                return mid;
            }
            else if(mid>x/mid){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return right;
    }
}


//Newton's method/Newton-Raphson method
/*
it is a method for finding successively better approximations to the roots (or zeroes) of a real-valued function
	x(n+1)=x(n)-y/y'
	in this problem, f(y)=y^2-x.      its derivative f'(y)=2*y;
	y(n+1)=y(n)-f(y)/f'(y)=y-(y^2-x)/2y=(2*y^2-y^2+x)/2y=(y^2+x)/2y=(y+x/y)/2
**/
public class Solution {
    public int sqrt(int x) {
        if(x<0){
            return -1;
        }
        if (x==0){
            return 0;
        }
        double lastY=0;
        double y=1;
        while(y!=lastY){
            lastY=y;
            y=(y+x/y)/2;
            
        }
        return (int)y;
    }
}