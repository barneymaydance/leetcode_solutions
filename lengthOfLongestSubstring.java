//#001    walker runner two pointers  using HashMap or HashSet

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")||s==null){
            return 0;
        }
        int max=0;
        int walker=0;
        int runner=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        while(runner<s.length()){
           if (map.containsKey(s.charAt(runner))){
               if(max<runner-walker){
                   max=runner-walker;
               }
               while(s.charAt(walker)!=s.charAt(runner)){
                   map.remove(s.charAt(walker));
                   walker++;
               }
               walker++;
           }
           else{
               map.put(s.charAt(runner),runner);
           }
           runner++;
        }
        
        return Math.max(max,runner-walker);
    }
}