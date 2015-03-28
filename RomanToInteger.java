//O(String length)  runtime 

public class Solution {
    public int romanToInt(String s) {
        if (s.length()==0||s==null){
            return 0;
        }
        HashMap<Character,Integer> pairs=new HashMap<Character,Integer>();
        char[] symbols = {'M','D','C','L','X','V','I'};
        int[] nums = {1000,500,100,50,10,5,1};
        for(int i=0;i<nums.length;i++){
            pairs.put(symbols[i],nums[i]);
        }
        int res=0;
        char pre=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if (pairs.get(s.charAt(i))<=pairs.get(pre)){
                res+=pairs.get(pre);
                
            }
            else{
                res-=pairs.get(pre);
            }
            pre=s.charAt(i);
        }
        res+=pairs.get(pre);
        return res;
    }
}