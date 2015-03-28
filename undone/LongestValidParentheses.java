//O(n) time
//O(n) space, the stack capacity, worst case O(n)
// stack storage the index, and local length and max length

public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max=0;
        int tempLen=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }
            else if (c==')'){
                if(!stack.isEmpty()){
                    int len=i-stack.pop()+1;
                    if(stack.isEmpty()){
                        tempLen+=len;
                        len=tempLen;
                    }
                    else{
                        len=i-stack.peek();
                    }
                    max=Math.max(max,len);
                }
                else{
                    tempLen=0;
                } 
            }
        }
        return max;
    }
}
