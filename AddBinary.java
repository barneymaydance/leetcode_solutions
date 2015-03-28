//O(max(m,n)) runtime
//O(max(m,n)) space


public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0)
            return b;
         if(b==null||b.length()==0)
            return a;
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0&&j>=0){
            int numA= a.charAt(i)-'0';
            int numB= b.charAt(j)-'0';
            if((numA+numB+carry)<2){
                sb.append(numA+numB+carry);
                carry=0;
            }
            else{
                sb.append((numA+numB+carry)%2);
                carry=1;
            }
            i--;
            j--;
        }
        
        while(i>=0){
            int numA= a.charAt(i)-'0';
            if(numA+carry<2){
                sb.append(numA+carry);
                carry=0;
            }
            else{
                sb.append((numA+carry)%2);
                carry=1;
            }
            i--;
        }
        while(j>=0){
            int numB= b.charAt(j)-'0';
            if(numB+carry<2){
                sb.append(numB+carry);
                carry=0;
            }
            else{
                sb.append((numB+carry)%2);
                carry=1;
            }
            j--;
        }
        if(carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}