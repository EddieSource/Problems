import java.util.*; 
public class _0704_BinarySearch {
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1; 
        int left = 0, right = nums.length - 1; 
        while(left <= right) {
        	int mid = left + (right - left) / 2; 
        	if(target == nums[mid]) {
        		return mid; 
        	}
        	else if(target > nums[mid]) {
        		left = mid + 1; 
        	}
        	else {
        		right = mid - 1; 
        	}
        }
        return -1; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
