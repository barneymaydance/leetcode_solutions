//O(n) time, n stands for string S's length
//O(m) space, m stands for string T's dictionary length

public class Solution {
    public String minWindow(String S, String T) {
        String res = "";
		if (S == null || S.length() == 0 || T == null || T.length() == 0) {
			return res;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int n = S.length();
		int m = T.length();
		for (int i = 0; i < m; i++) {
			char c = T.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		HashMap<Character, Integer> find = new HashMap<Character, Integer>();
		int leftBound = 0,count=0;
		for (int i = 0; i <n ; i++) {
			char c=S.charAt(i);
			if(!map.containsKey(c)){
			    continue;
			}
			if(find.containsKey(c)){
			    find.put(c,find.get(c)+1);
			}
			else{
			    find.put(c,1);
			}
			if(find.get(c)<=map.get(c)){
			    count++;
			}
			if(count==m){
			    while(leftBound<n){
			        char ch = S.charAt(leftBound);
			        if(!map.containsKey(ch)){
			            leftBound++;
			            continue;
			        }
			        if(find.get(ch)>map.get(ch)){
			            find.put(ch,find.get(ch)-1);
			            leftBound++;
			            continue;
			        }
			        break;
			    }
			    if(res.equals("")||i-leftBound+1<res.length()){
			        res=S.substring(leftBound,i+1);
			    }
			}
		}
		return res;
    }
}