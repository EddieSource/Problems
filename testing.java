import java.util.*; 
public class testing {
	public int minJump(int[] array, int index) {
	    // Write your solution here
	      boolean[] done = new boolean[array.length]; 
	    	Arrays.fill(done, false); // all the indices are not start processing
	    	int[] minStep = new int[array.length]; 
	    	Arrays.fill(minStep, -1); 
	    	return minJumpHelper(array, index, done, minStep); 
	  }
	    public int minJumpHelper(int[] arr, int start, boolean[] done, int[] minStep) {
	        // from start reach to any index with value zero
	    	
	    	// base case
	    	if(start < 0 || start >= arr.length) return -1; 
	      if(start == arr.length - 1) {
	        minStep[start] = 0; 
	        done[start] = true; 
	        return minStep[start]; 
	      }
	    	
	    	// deduplicate: if we are processing/processed before we return immediately
	    	if(done[start]) return minStep[start]; 
	    	
	      // recursion rule
	    	minStep[start] = -1; 
	    	done[start] = true; // prevent the cycle, start state of the current node


	    	// arr[start] must not be 0 now so we start from 1
	      for(int step = 0; step <= arr[start]; step++){
	        int left = minJumpHelper(arr, start + step, done, minStep); 
	        // left == -1 or >= 0
	        int right = minJumpHelper(arr, start - step, done, minStep); 
	        
	        int cur; 
	        if(left == -1 && right == -1) cur = -1; 
	        else if(left == -1) cur = right + 1; 
	        else if(right == -1) cur = left + 1; 
	        else cur = Math.min(left, right) + 1; 
	        
	        if( cur != -1) {
		        if(minStep[start] == -1) {
			          // if can not reach we update the minStep[start]
			          minStep[start] = cur; 
			        }

			    else {
			       // if minStep can reach we find the min
			       minStep[start] = Math.min(cur, minStep[start]); 
			    }
	        }
	        

	      }

	    	done[start] = true; // end state of the current node

	    	return minStep[start]; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing a = new testing(); 
		a.minJump(new int[] {1, 2, 0}, 0); 
		
	}

}
