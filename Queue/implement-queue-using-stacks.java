class MyQueue {
    public MyQueue() {
        
    }
    // Initializing our stacks
    Stack<Integer> push_stack = new Stack<>();
    Stack<Integer> pop_stack = new Stack<>();
    
    public void flip(){
        int size = push_stack.size();
        for (int i = 0; i < size; i++) {
            int top = push_stack.pop();
            pop_stack.push(top);
        }
    }
    
    public void push(int x) {
        //whenever we do a push operation, 
        //we push the item onto the first stack called push_stack
        push_stack.push(x);
    }
    
    public int pop() {
        // first we need to check if the pop_stack is empty or not
        if (pop_stack.isEmpty()){
            // if the pop_stack is empty
            // we need to get all the items that were inserted to push_stack
            // and we need to pop them from the push_stack
            // then push them into our pop_stack
            // so that their order is flipped which makes the items to be
            // in the order that they were inserted
            // this is needed to have the items like in a FIFO order
            // there is a function called flip where all of the stuff is implemented
            flip();
        }
        
        return pop_stack.pop();
    }
    
    public int peek() {
        // for the peek it is the same thing as pop
        // except we take the item in our queue 
        // (more accurately from our pop_stack)
        // but we just show/print the item
        // instead of removing it from our pop_stack
        if (pop_stack.isEmpty()){
            flip();
        }
        return pop_stack.peek();
    }
    
    public boolean empty() {
        return push_stack.isEmpty() && pop_stack.isEmpty();
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
