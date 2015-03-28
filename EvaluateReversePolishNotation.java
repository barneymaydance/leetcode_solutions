//O(n)
//O(n) the length of the stack, operands and its result
//use a stack

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0){
            return 0;
        }
        LinkedList<Integer> operands = new LinkedList<Integer>();
        for(String token:tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int num1=operands.pop();
                int num2=operands.pop();
                int res=0;
                String oper=token;
                switch(oper){
                    case "+":
                        res=num2+num1;
                        break;
                    case "-":
                        res=num2-num1;
                        break;
                    case "*":
                        res=num2*num1;
                        break;
                    case "/":
                        res=num2/num1;
                        break;
                    default:
                        break;
                }
                operands.push(res);
            }
            else{
                operands.push(Integer.parseInt(token));
            }
        }
        
        return operands.get(0);
    }
}