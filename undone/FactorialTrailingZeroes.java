//O(log(n)) time
//O(1) space
//consider the j overflow
//count the 5 factorical, 25 factorial, 125 factorial
//iterative method
public class Solution {
    public int trailingZeroes(int n) {
        if(n<0){
            return -1;
        }
        int count=0;
        for(int j=5;n/j>=1;j=j*5){
            count+=n/j;
            if(j>Integer.MAX_VALUE/5) return count;
        }
        return count;
    }
}

//O(log(n)) time
//O(log(n)) space
//recursive method
public class Solution {
    public int trailingZeroes(int n) {
        if(n<0){
            return -1;
        }
        else if(n<5){
            return 0;
        }
        else{
            return n/5+trailingZeroes(n/5);   
        }
    }
}