//O(n^2) time
//O(n^2) space
//use a two dimension  array as dictionary, a one dimension array dp




//O(n^3) time,  you need to know method substring O(n) time
//O(n) space

public class Solution {
    public int minCut(String s) {
        if(isPalindrome(s)){
            return 0;
        }
        int[] res = new int[s.length()+1];
        
        for(int i=1;i<=s.length();i++){
            for(int j=i;j>0;j--){
                if(isPalindrome(s.substring(j-1,i))){
                    if(res[i]==0){
                        res[i]=res[j-1]+1;
                    }
                    else{
                        res[i]=Math.min(res[i],res[j-1]+1);
                    }
                }
            }
        }
        return res[s.length()];
    }
  
    private boolean isPalindrome(String str){
        if(str==null||str.length()==0){
            return true;
        }
        int left=0;
        int right= str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}