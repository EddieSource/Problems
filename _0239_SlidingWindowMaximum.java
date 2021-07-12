import java.util.*; 
public class _0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /* 1 3 -1 -3 5 3 6 7
         * [5 
         * [3
    	*/
    	// use a deque contains all index with descending value
    	// a monoque
    	
    	// check if the last value is popped
    	Deque<Integer> deque = new ArrayDeque<>(); 
    	
    	if(nums.length - k + 1 <= 0) return new int[0]; 
    	
    	int[] res = new int[nums.length - k + 1]; 
    	int ind = 0; 
    	
    	for(int i = 0; i < nums.length; i++) {
    		while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
    			deque.pollLast();
    		}
    		deque.offerLast(i); 
    		
    		// see if the first one(largest element is out of the sliding window
    		if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
    			deque.pollFirst(); 
    		}
    		
    		if(i >= k - 1) {
    			res[ind] = nums[deque.peekFirst()]; 
    			ind++;
    		}
    	}
    	
    	return res; 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
