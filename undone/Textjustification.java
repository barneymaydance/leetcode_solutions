//O(n) time
//O (r*L) space , r stands for the number of rows.

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if(words==null||words.length==0){
            return res;
        }
        int len=0;
        int begin=0;
        
        for(int i=0;i<words.length;i++){
            if(len+words[i].length()+i-begin>L){
                int spaceNum=0;
                int extraNum=0;
                if(i-1-begin>0){
                    spaceNum=(L-len)/(i-1-begin);
                    extraNum=(L-len)%(i-1-begin);
                }
                StringBuilder sb=new StringBuilder();
                for(int j=begin;j<i;j++){
                    sb.append(words[j]);
                    if(j!=i-1){
                        for(int k=0;k<spaceNum;k++){
                            sb.append(" ");
                        }
                        if(extraNum!=0){
                            sb.append(" ");
                            extraNum--;
                        }
                    }
                }
                for(int j=sb.length();j<L;j++){
                    sb.append(" ");
                }
                res.add(sb.toString());
                len=0;
                begin=i;
            }
            len=len+words[i].length();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=begin;i<words.length;i++)
        {
            sb.append(words[i]);
            if(sb.length()<L)
                sb.append(" ");
        }
        for(int i=sb.length();i<L;i++)
        {
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }
}