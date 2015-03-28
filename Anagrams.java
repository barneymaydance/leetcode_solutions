// O(nklog(k)) runtime, n stands for the number of strings, k stanks for the length of max length string.
//O(nk) space
// to decide anagrams, we ususally sort the word, then compare


public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if(strs==null||strs.length==0){
            return res;
        }
        
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for(String s:strs){
            char[] charArr=s.toCharArray();
            Arrays.sort(charArr);
            String key=new String(charArr);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                ArrayList<String> temp=new ArrayList<String>();
                temp.add(s);
                map.put(key,temp);
            }
        }
        
        for(ArrayList<String> list: map.values()){
            if(list.size()>=2){
                res.addAll(list);
            }
        }
        return res;
    }
}