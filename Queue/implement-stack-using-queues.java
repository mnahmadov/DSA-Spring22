// Link to the Implement Stack Using Queues problem on Leetcode: https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public int top;
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue1.add(x);
        top = x; // we keep track of the last item 
            // that is inserted to our stack(more accurately queue1)
    }
    
    public int pop() {
        // we need to remove the item from the top of the stack
        // which is the last element tat we have inseted to our queue1
        // to remove the last element from the queue1,
        // we need to remove all the elements that were inseted before it
        // for this we need to have another queue called queue2
        // to store all those previously inserted elements
        while (queue1.size() > 1) {
            // let's take all the elements that were inseted before the last
            // and put them in our second queue 
            top = queue1.remove();
            queue2.add(top);
        }
        int removed_top = queue1.remove(); // let's pop the element that was inserted last
        // here we swap the queus
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return removed_top;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
