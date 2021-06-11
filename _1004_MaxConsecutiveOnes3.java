import java.util.*; 
public class _1004_MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        // assumptions: nums.length >= 1
    	// [left, right) is the consecutive ones
    	// right - left is the length of it
    	
    	// [1,1,1,0,0,0,1,1,1,1,0], k = 2
    	//  l    
    	int max = 0; 
    	int left = 0, right = 0; 
     
    	int cur = 0; 
    	while(right < nums.length) {
    		if(nums[right] == 0 && k <= 0) {
    			// no chance to flip, must stop
    			max = Math.max(cur, max); 
    			if(nums[left] == 0) k++; 
    			left++; 
    			cur--; 
    		}
    		else {
    			if(nums[right] == 0) k--; 
    			right++; 
    			cur++; 
    		}
    	}
    	// if reach the end we need to compare the cur with max
    	return Math.max(cur, max); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
