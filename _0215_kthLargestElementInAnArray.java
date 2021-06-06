import java.util.*; 
public class _0215_kthLargestElementInAnArray {
	
    public int findKthLargest(int[] nums, int k) {
    	if(nums.length == 0 || k == 0) return -1; 
    	
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			if(o1.equals(o2)) return 0; 
    			return o1 < o2 ? -1: 1; 
    		}
    	}); 
    	
    	for (int i = 0; i < nums.length; i++) {
    		if(i < k) {
    			minHeap.offer(nums[i]); 
    		}
    		else if(nums[i] > minHeap.peek()) {
    			minHeap.poll();
    			minHeap.offer(nums[i]); 
    		}
    	}
    	
    	return minHeap.poll(); 
    	

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
