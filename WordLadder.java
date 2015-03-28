//O(min(26^L, size(dict)) time /O(26*L*size(dict)) time
//O(min(26^L, size(dict)) space /O(26*L*size(dict)) space
//bfs, use a HashSet to store visited node
//change char from 'a' to'z' from index 0 to string's length

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
            return 0;
        
        Set<String> visited = new HashSet<String>();
        LinkedList<String> queue = new LinkedList<String>(); 
        int level=1;
        int lastNum=1;
        int num=0;
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String cur= queue.poll();
            lastNum--;
            for(int i=0;i<cur.length();i++){
                char[] curChar=cur.toCharArray();
                for(char c='a';c<='z';c++){
                    curChar[i]=c;
                    String str= new String(curChar);
                    if(str.equals(end)){
                        return level+1;
                    }
                    if(dict.contains(str)&&!visited.contains(str)){
                        visited.add(str);
                        queue.add(str);
                        num++;
                    }
                }
            }
            if(lastNum==0){
                level++;
                lastNum=num;
                num=0;
            }
        }
        return 0;
    }
}