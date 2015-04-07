//O(m*n) time
//O(m+n) extra space
//use a array to store each digits result
//String multiply String should know that the smallest digit is at the end of a String
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null|num1.length()==0||num2==null|num2.length()==0){
            return null;
        }
        if(num1.charAt(0)=='0')  
            return "0";  
        if(num2.charAt(0)=='0')  
            return "0";
        StringBuilder res=new StringBuilder();
        int len1=num1.length();
        int len2=num2.length();
        int len3=len1+len2;
        int product=0;
        int[] num3 = new int[len3];
        for(int i=len1-1;i>=0;i--){
            int carry=0;
            int j;
            for(j=len2-1;j>=0;j--){
                product=carry+num3[i+j+1]+(int)(num1.charAt(i)-'0')*(int)(num2.charAt(j)-'0');
                carry=product/10;
                num3[i+j+1]=product%10;
            }
            num3[i+j+1]=carry;
        }
        int i=0;
        while(i<len3&&num3[i]==0){
            i++;
        }
        for(;i<len3;i++){
            res.append(num3[i]);
        }
        return res.toString();
    }
}

//O((m+n)) time
//O(1) extra space
