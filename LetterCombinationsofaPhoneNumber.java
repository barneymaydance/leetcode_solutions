// O(k^n) runtime, n stands for the digits' length, k stands for the each digit's letters' number
//O(k^n) space
// it is iterative method, also can use recursive method dfs.

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        res.add("");
        if(digits==null||digits.length()==0){
            return res;
        }
        
        for (int i=0; i<digits.length();i++){
            String cur=getLetters(digits.charAt(i));
            List<String> temp=new ArrayList<String>();
            for(int j=0;j<cur.length();j++){
                for(int k=0;k<res.size();k++){
                        temp.add(res.get(k)+cur.charAt(j));
                }
            }
            res=temp;
        }
        return res;
    }
    
    private String getLetters(char d){
        switch (d){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }
}