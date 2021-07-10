
public class _0153_FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1; 
        if(nums.length == 1) return nums[0]; 
        
        int left = 0, right = nums.length - 1; 
        if(nums[left] < nums[right]) return nums[0]; //the array is not rotated
        
        // find the pivot
        while(left <= right) {
        	int mid = left + (right - left) / 2; 
        	if(nums[mid] > nums[mid + 1]) {
        		return nums[mid + 1]; 
        	}
        	// don't rule out possible solution
        	if(nums[mid - 1] > nums[mid]) {
        		return nums[mid]; 
        	}
        	else {
        		if(nums[mid] > nums[left]) {
        			left = mid + 1; 
        		}
        		else {
        			right = mid - 1; 
        		}
        	}
        }
        
        return -1; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
