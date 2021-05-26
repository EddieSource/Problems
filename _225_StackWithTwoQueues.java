import java.util.*; 
public class _225_StackWithTwoQueues {
	 /** Initialize your data structure here. */
    private Queue<Integer> q; 
    
    public _225_StackWithTwoQueues() {
    	q = new LinkedList<>(); 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x); 
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int size = q.size(); 
        for(int i = 0; i < size-1; i++) {
        	q.offer(q.poll()); 
        }
        return q.poll(); 
    }
    
    /** Get the top element. */
    public int top() {
    	int res = pop(); 
    	q.offer(res);
        return res; 
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.size() == 0; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
