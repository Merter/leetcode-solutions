class MyQueue {

    private Deque<Integer> stack;
    private Deque<Integer> auxStack;
    
    public MyQueue() {
        stack = new ArrayDeque<>();
        auxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if (auxStack.isEmpty()) {
            moveFromStackToAuxStack();            
        }
        return auxStack.pop();
    }
    
    public int peek() {
        if (auxStack.isEmpty()) {
            moveFromStackToAuxStack();
        }
        return auxStack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty() && auxStack.isEmpty();
    }
    
    private void moveFromStackToAuxStack() {
        while (! stack.isEmpty()) {
            auxStack.push(stack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 