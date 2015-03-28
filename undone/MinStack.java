//push() O(1) time
//pop() O(1) time
//top() O(1) time
//getMin() O(1) time
//use two stacks.

class MinStack {
    LinkedList<Integer> stack=new LinkedList<Integer>();
    LinkedList<Integer> minStack=new LinkedList<Integer>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int elem=stack.pop();
        if(!minStack.isEmpty()&&elem==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;
    }
}
