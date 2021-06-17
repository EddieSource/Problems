
public class _0055_JumpGame {
    public static boolean canJump(int[] nums) {
        // from back to front
    	if(nums.length == 0) return false; 
    	// m[i] means if its possible to get last index starting from i
    	boolean[] m = new boolean[nums.length];
    	// last index
    	m[nums.length - 1] = true; 
    	
    	for(int i = nums.length - 1; i >= 0; i--) {
    		// start from the second last index
    		boolean canGetLastIndex = false; 
    		for(int j = 0; j <= nums[i]; j++) {
    			if(i + j >= nums.length || m[i + j]) {
    				canGetLastIndex = true; 
    				break; 
    			}
    		}
    		m[i] = canGetLastIndex; 
    	}
    	
    	return m[0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,3,1,1,4}; 
		canJump(nums); 
	}

}
