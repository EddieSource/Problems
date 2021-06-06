import java.util.*;
public class _0155_MinStack {
    /** initialize your data structure here. */
	private Deque<Integer> dataStack; 
	private Deque<Integer> minStack; 
	private Deque<Integer> sizeStack; 
	
    public _0155_MinStack() {
        dataStack = new ArrayDeque<>(); 
        minStack = new ArrayDeque<>(); 
        sizeStack = new ArrayDeque<>(); 
        
    }
    
    public void push(int val) {
        dataStack.offerFirst(val); 
        if(minStack.isEmpty() || val < minStack.peekFirst()) {
        	minStack.offerFirst(val);
        	sizeStack.offerFirst(dataStack.size());
        }
        
    }
    
    public void pop() {
        int val = dataStack.pollFirst(); 
        if(sizeStack.peekFirst() > dataStack.size()) {
        	minStack.pollFirst(); 
        	sizeStack.pollFirst(); 
        }
    }
    
    public int top() {
        return dataStack.peekFirst(); 
    }
    
    public int getMin() {
    	return minStack.peekFirst(); 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
