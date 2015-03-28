//O(n) runtime
//O(1) space

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null||s.length()==0)
            return 0;
        int idx=s.length()-1;
        while(idx>=0&&s.charAt(idx)==' ') idx--;
        int idx2=idx;
        while(idx2>=0&&s.charAt(idx2)!=' ')idx2--;
        return idx-idx2;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null)
            return 0;
        s=s.trim();
        if(s.length()==0)
            return 0;
        String[] str=s.split(" ");
        return str[str.length-1].length();
    }
}

