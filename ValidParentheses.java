//O(n) runtime
//O(n) space
//use a stack  to manipulate

public class Solution {
    public boolean isValid(String s) {
        if (s.length()==0||s==null)
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(temp!='('&&temp!=')'&&temp!='{'&&temp!='}'&&temp!='['&&temp!=']'){
                return false;
            }
            if(temp=='('||temp=='['||temp=='{'){
                stack.push(temp);
            }
            else if(temp ==')'){
                if (stack.isEmpty()||stack.pop()!='(')
                    return false;
            }
            else if(temp ==']'){
                if (stack.isEmpty()||stack.pop()!='[')
                    return false;
            }
            else if(temp =='}'){
                if (stack.isEmpty()||stack.pop()!='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}