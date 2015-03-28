//O(n) time
//O(n) space
//similar to split method, use recursive way to implement it
public class Solution {
    public String reverseWords(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        s=s.trim();
        return helper(s,0).toString();
    }
    private StringBuilder helper(String s,int idx){
        if(idx>=s.length()){
            return new StringBuilder();
        }
        StringBuilder sb = new StringBuilder();
        int lastIdx=idx;
        while(idx<s.length()&&s.charAt(idx)!=' '){
            sb.append(s.charAt(idx));
            idx++;
        }
        while(idx<s.length()&&s.charAt(idx)==' '){
            idx++;
        }
        if(lastIdx==0){
            return helper(s,idx).append(sb);
        }
        return helper(s,idx).append(sb).append(" ");
    }
}


//O(n) time? denpend ont String.split()
//O(n) space
//use String.trim() and String.split() 

public class Solution {
    public String reverseWords(String s) {
        if (s==null||s.length()==0){
            return s;
        }
        s=s.trim();
        String[] words=s.split(" ");
        StringBuilder sb =new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].equals("")&&i!=words.length-1){
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }
}