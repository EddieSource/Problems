import java.util.*; 
public class _1306_JumpGame3 {
    public boolean canReach(int[] arr, int start) {
    	boolean[] done = new boolean[arr.length]; 
    	Arrays.fill(done, false); // all the indices are not start processing
    	boolean[] canReachOf = new boolean[arr.length]; 
    	Arrays.fill(done, false); 
    	return canReachHelper(arr, start, done, canReachOf); 
    }
    public boolean canReachHelper(int[] arr, int start, boolean[] done, boolean[] canReachOf) {
        // from start reach to any index with value zero
    	
    	// base case
    	if(start < 0 || start >= arr.length) return false;
    	
    	// deduplicate
    	if(done[start]) return canReachOf[start]; 
    	
    	if(arr[start] == 0) {
    		canReachOf[start] = true; 
    		done[start] = true; 
    		return true; 
    	}
    	
    	// recursion rule
    	
    	boolean res = false; // which is false
    	canReachOf[start] = false; 
    	done[start] = true; // prevent the cycle, start state of the current node

    	// arr[start] must not be 0 now so we start from 1
    	res |= canReachHelper(arr, start + arr[start], done, canReachOf); 
    	res |= canReachHelper(arr, start - arr[start], done, canReachOf); 
    	
    	canReachOf[start] = res; 
    	done[start] = true; // end state of the current node

    	return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1306_JumpGame3 a = new _1306_JumpGame3(); 
		System.out.println(a.canReach(new int[] {3,0,2,1,2}, 2)); 
		
	}

}
