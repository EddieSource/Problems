import java.util.*; 
public class _0283_MoveZeros {
    public void moveZeroes(int[] nums) {
       int slow = 0, fast = 0; 
       while (fast < nums.length) {
    	   if(nums[fast] != 0) {
    		   nums[slow] = nums[fast]; 
    		   slow++; 
    	   }
    	   fast++; 
       }
       while(slow < nums.length) {
    	   nums[slow] = 0; 
    	   slow++; 
       }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
