import java.util.*; 
public class _303_RangeSumQuery {
	int[] sumEndingAt; 
    public NumArray(int[] nums) {
    	// assumption: nums.length >= 1; 
    	sumEndingAt = new int[nums.length + 1]; 
    	sumEndingAt[0] = 0; 
    	sumEndingAt[1] = nums[0]; 
        for(int i = 1; i <= nums.length; i++) {
        	sumEndingAt[i] = sumEndingAt[i - 1] + nums[i - 1]; 
        }
        
    }
    
    public int sumRange(int left, int right) {
    	// 0 <= left <= right < nums.length
        return sumEndingAt[right + 1] - sumEndingAt[left]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
