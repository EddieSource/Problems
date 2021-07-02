import java.util.*; 
public class _0026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // [0, slow) is the result array
    	// [fast, nums.length) is the unprocessed
    	
    	int slow = 0, fast = 0; 
    	while (fast < nums.length) {
    		// if the current equals the last letter of the result array
    		if(slow > 0 && nums[fast] == nums[slow - 1]) {
    			fast++; 
    		}
    		else {
    			nums[slow] = nums[fast]; 
    			slow++; 
    			fast++; 
    		}
    	}
    	return slow; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
