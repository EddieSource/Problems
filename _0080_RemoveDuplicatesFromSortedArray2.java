import java.util.*; 
public class _0080_RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int slow = 0; 
        int fast = 0; 
        while (fast < nums.length) {
        	if(fast < 2 || nums[fast] != nums[slow - 2]) {
        		nums[slow] = nums[fast]; 
        		slow++; 
        	}
        	fast++; 
        }
        return slow; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
