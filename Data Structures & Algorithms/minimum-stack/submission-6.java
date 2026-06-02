class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
