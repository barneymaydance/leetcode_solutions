// List all possible Roman numerals

public class Solution {
    public String intToRoman(int num) {
        // I    1
        // V    5
        // X    10
        // L    50
        // C    100
        // D    500
        // M    1000
        // II    2  III 3   IV  4   VI 6    VII 7   VIII    8   IX  9
        
        if (num<1||num>3999){
            return "";
        }
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder res=new StringBuilder();
        int index=0;
        while(num>0){
            int factor=num/nums[index];
            num=num%nums[index];
            for(;factor>0;factor--){
                res.append(symbols[index]);
            }
            index++;
        }
        return res.toString();
    }
}