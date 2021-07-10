
public class _0034_FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        // find start
    	// 5 7 7 8 8 10
    	//     l r    r
    	if (nums.length == 0) return new int[] {-1, -1}; 
    	int left = 0, right = nums.length - 1; 
    	
    	int start; 
    	// find first occurence
    	while(left < right - 1) {
    		// last two indexes in the end
    		int mid = left + (right - left) / 2; 
    		if(target == nums[mid]) {
    			right = mid; 
    		}
    		else if(target < nums[mid]) {
    			right = mid; 
    		}
    		else {
    			left = mid; 
    		}
    	}
    	
    	if(nums[left] == target) {
    		start = left; 
    	}
    	else if(nums[right] == target) {
    		start = right; 
    	}
    	else {
    		return new int[] {-1, -1}; 
    	}
    	
    	// find last occurrence
    	left = 0; 
    	right = nums.length - 1; 
    	int end; 
    	// find first occurence
    	while(left < right - 1) {
    		// last two indexes in the end
    		int mid = left + (right - left) / 2; 
    		if(target == nums[mid]) {
    			left = mid; 
    		}
    		else if(target < nums[mid]) {
    			right = mid; 
    		}
    		else {
    			left = mid; 
    		}
    	}
    	
    	if(nums[right] == target) {
    		end = right; 
    	}
    	else if(nums[left] == target) {
    		end = left; 
    	}
    	else {
    		return new int[] {-1, -1}; 
    	}
    	
    	return new int[] {start, end}; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
