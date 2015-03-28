//O(n) time, n stands for S string's length
//O(m*k) space, m stands for  L array's length, k stands for each word's string's length

// use two hashmaps
// two pointers
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if(S==null||S.length()==0||L==null||L.length==0){
            return res;
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++){
            if(map.containsKey(L[i])){
                map.put(L[i],map.get(L[i])+1);
            }
            else{
                map.put(L[i],1);
            }
        }
        HashMap<String,Integer> find = new HashMap<String,Integer>();
        int n=S.length();
        int m=L.length;
        int k=L[0].length();
        for(int i=0;i<=n-m*k;i++){
            int j=0;
            for(;j<m;j++){
                int idx=i+j*k;
                String str=S.substring(idx,idx+k);
                if(!map.containsKey(str)) break;
                if(find.containsKey(str)){
                    find.put(str,find.get(str)+1);
                }
                else{
                    find.put(str,1);
                }
                if(find.get(str)>map.get(str)) break;
            }
            if(j==m) res.add(i);
            find.clear();
        }
        return res;
        
    }
}