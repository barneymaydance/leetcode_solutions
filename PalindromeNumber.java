// similar to Reverse Integer,   a number % 10, get its  lowest digit

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long res=0;
        int temp=x;
        while(x!=0){
            res=res*10+x%10;
            x/=10;
        }
        if (res==temp){
            return true;
        }
        else{
            return false;
        }
    }
}