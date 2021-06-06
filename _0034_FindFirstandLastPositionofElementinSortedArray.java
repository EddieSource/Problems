
public class _0034_FindFirstandLastPositionofElementinSortedArray {
	
	public int[] searchRange(int[] nums, int target) {
		/*
		 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?
		 */
		// test
        int[] res = {-1,-1}; 
        if (nums == null || nums.length == 0) {
            return res; 
        }
        
        
        int left = 0; 
        int right = nums.length - 1; 
        int mid; 
        while(left < right - 1) {
            mid = left + (right - left) / 2; 
            if(target <= nums[mid]){
                right = mid; 
            }
            else {
                left = mid; 
            }
        }
        
        if(nums[left] == target){
            res[0] = left; 
        }
        else if(nums[right] == target) {
            res[0] = right; 
        }
        
        if(res[0] != -1) {
            int pos = res[0]; 
            while(pos < nums.length){
                if(nums[pos] != target) break; 
                res[1] = pos; 
                pos++; 
            }
            return res; 
        }
        return res;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
