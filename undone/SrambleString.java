//O(3^n)  time worst case
//
//recursive method, simplest way, but worst time complexity

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null){
            return false;
        }
        int len1=s1.length();
        int len2=s2.length();
        if(len1!=len2){
            return false;
        }
        
        return helper(s1,s2);
    }
    private boolean helper(String s1,String s2){
        int len=s1.length();
        if(len==1){
            return s1.equals(s2);
        }
		char[] s1ch=s1.toCharArray();
        char[] s2ch=s2.toCharArray();
        Arrays.sort(s1ch);
        Arrays.sort(s2ch);
        String s1Sort=new String(s1ch);
        String s2Sort=new String(s2ch);
        for(int i=1;i<len;i++){
            if(helper(s1.substring(0,i),s2.substring(0,i))&&helper(s1.substring(i,len),s2.substring(i,len))){
                return true;
            }
            if(helper(s1.substring(0,i),s2.substring(len-i,len))&&helper(s1.substring(i,len),s2.substring(0,len-i))){
                return true;
            }
        }
        return false;
    }
}