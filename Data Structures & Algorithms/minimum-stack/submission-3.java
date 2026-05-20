class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        

        if(this.minStack.isEmpty() ||  val <= this.minStack.peek())
            this.minStack.push(val);
       
    }
    
    public void pop() {
        if(this.stack.isEmpty())
            return;
        int top = this.stack.pop();
        if(this.minStack.peek() == top)
            this.minStack.pop();
        
        
        
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
      
        return this.minStack.peek();
    }
}
