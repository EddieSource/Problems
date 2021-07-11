import java.util.*; 
public class _0154_FindMinInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        // nums.length >= 1
    	if(nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0]; 
    	int left = 0, right = nums.length - 1; 
    	while(left <= right) {
    		int mid = left + (right - left) / 2; 
    		if(nums[mid] > nums[mid + 1]) {
    			return nums[mid + 1]; 
    		}
    		if(nums[mid] < nums[mid - 1]) {
    			return nums[mid]; 
    		}
    		else {
    			if(nums[mid] > nums[left]) {
    				right = mid - 1; 
    			}
    			else if(nums[mid] < nums[left]) {
    				left = mid + 1; 
    			}
    			else {
    				// nums[mid] == nums[left]
    				right--; 
    			}
    		}
    	}
    	return -1; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
