import java.util.*; 
public class _0033_SearchInRotatedSortedArray {
	public int binarySearch(int[] nums, int target, int left, int right) {
		while(left <= right) {
			int mid = left + (right - left) / 2; 
			if(target < nums[mid]) {
				right = mid - 1; 
			}
			else if(target > nums[mid]) {
				left = mid + 1; 
			}
			else {
				return mid; 
			}
		}
		return -1; 
	}
	
	public int searchForPos(int[] nums, int target) {
	       // find the position pos where nums[pos] > nums[pos + 1]
	    	if(nums[0] < nums[nums.length - 1]) return 0; 
	    	int left = 0, right = nums.length - 1; 
	    	while(left <= right) {
	    		int mid = left + (right - left) / 2; 
	    		if(nums[mid] > nums[mid + 1]) {
	    			return mid + 1;  
	    		}
	    		else {
	    			if(nums[mid] < nums[left]) {
	    				right = mid - 1; 
	    			}
	    			else {
	    				left = mid + 1; 
	    			}
	    		}
	    	}
	    	return 0; 
	}
    public int search(int[] nums, int target) {
    	// if nums is empty
    	if(nums.length == 0) return -1; 
    	if(nums.length == 1) return nums[0] == target ? 0: -1; 
    	
    	int pos = searchForPos(nums, target); 
 
    	// if not rotated return binarySearch
    	if(pos == 0) return binarySearch(nums, target, 0, nums.length - 1); 
    	
    	
    	// nums[pos] is the smallest number, nums[pos - 1] is the largest number
    	
    	// search right half
    	if(target < nums[0]) return binarySearch(nums, target, pos, nums.length - 1); 
    	
    	// search left half
    	else return binarySearch(nums, target, 0, pos - 1); 
    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0033_SearchInRotatedSortedArray a = new _0033_SearchInRotatedSortedArray(); 
		a.search(new int[] {3, 1}, 0); 
	}

}
