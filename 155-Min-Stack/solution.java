public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(x < min) {
            minStack.push(x);
            min = x;
        } else 
            minStack.push(min);
    }
    
    public void pop() {
        if(stack.isEmpty())
            return;
        stack.pop();
        minStack.pop();
        if(stack.isEmpty())
            min = Integer.MAX_VALUE;
        else
            min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */