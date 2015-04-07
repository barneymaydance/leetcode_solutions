//
//O(1) space
//recursive method
public class Solution {
    public String convertToTitle(int n) {
        if(n<0){
            return "";
        }
        if(n<=26){
            return ""+(char)('A'+n-1);
        }
        else{
            return convertToTitle(--n/26)+(char)('A'+n%26);
        }
    }
}

//iterative method
public class Solution {
    public String convertToTitle(int n) {
       String res="";
       while(n>0){
           n--;
           res=(char)(n%26+'A')+res;
           n=n/26;
       }
       return res;
    }
}