import java.util.*;

public class _0232_QueuesWithTwoStacks {
    /** Initialize your data structure here. */
	private Deque<Integer> in; 
	private Deque<Integer> out; 
    
	public _0232_QueuesWithTwoStacks() {
    	in = new ArrayDeque<Integer>(); 
    	out = new ArrayDeque<Integer>(); 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.offerFirst(x); 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()) {
        	while(!in.isEmpty()) {
        		out.offerFirst(in.pollFirst()); 
        	}
        }
        return out.pollFirst(); 
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()) {
        	while(!in.isEmpty()) {
        		out.offerFirst(in.pollFirst()); 
        	}
        }
        return out.peekFirst(); 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.size() + out.size() == 0; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
