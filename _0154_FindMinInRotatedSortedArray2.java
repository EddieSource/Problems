import java.util.*; 
public class _0154_FindMinInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1; 
        if(nums.length == 1) return nums[0]; 
        
        int left = 0, right = nums.length - 1; 
        if(nums[left] < nums[right]) return nums[0]; //the array is not rotated
        
        // find the pivot; search[left, right]; end[left]
        while(left < right) {
        	int mid = left + (right - left) / 2; 
        	if(nums[mid] < nums[right]) {
        		// nums[mid] is possibly the target
        		right = mid; 
        	}
        	else if(nums[mid] > nums[right]) {
        		// nums[mid] will not be the target
        		left = mid + 1; 
        	}
        	// nums[mid] == nums[right] and mid can never equal to right so we rule right out
        	else right--; 
        }
        
        return nums[left]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
