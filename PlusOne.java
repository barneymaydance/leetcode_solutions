//O(n) runtime
//O(1) average space, worst case O(n) space.

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)
            return digits;
        int carry=1;
        int i;
        for(i=digits.length-1;i>=0;i--){
            int digit=digits[i];
            digits[i]=(carry+digits[i])%10;
            carry=(carry+digit)/10;
            if(carry==0)
                return digits;
        }
        int[] res= new int[digits.length+1];
        res[0]=1;
        return res;
    }
}