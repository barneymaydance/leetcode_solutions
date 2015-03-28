//O(n) time
//O(n) space
//use a linkedlist as stack first, then as queue to output final result

public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0){
            return path;
        }
        LinkedList<String> stack = new LinkedList<String>();
        for(int i=0;i<path.length();i++){
            StringBuilder temp = new StringBuilder();
            int idx=i;
            while(i<path.length()&&path.charAt(i)!='/'){
                temp.append(path.charAt(i));
                i++;
            }
            if(idx!=i){
                String str=temp.toString();
                if(str.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else if(!str.equals(".")){
                    stack.push(str);
                }
            }
        }
        StringBuilder res=new StringBuilder();
        if (stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            res.append("/");
            res.append(stack.pollLast());
        }
        return res.toString();
    }
}
