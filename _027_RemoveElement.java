import java.util.*; 
public class _027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast = 0; 
        int slow = 0; 
        //[0, slow) is the returned array, so slow is also the length
        //[fast, nums.length) is the unprocessed array\
        while(fast < nums.length) {
        	if(nums[fast] != val) {
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
