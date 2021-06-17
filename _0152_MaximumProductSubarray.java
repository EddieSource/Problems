
public class _0152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0; 
        //nums.length >= 1
        //max[i] means the max product ending at nums[i] inclusive
        int[] max = new int[nums.length];
        max[0] = nums[0]; 
        //min[i] means the min product ending at nums[i] inclusive
        int[] min = new int[nums.length]; 
        min[0] = nums[0]; 
        //since max of the current can be derived from min[i-1] * nums[i] or max[i-1] * nums[i]
        int globalMax = max[0]; 
        
        for(int i = 1; i < nums.length; i++) {
        	// 2 cases, m[i - 1] * nums[i] or nums[i]
        	max[i] = Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]); 
        	max[i] = Math.max(nums[i], max[i]);
        	
        	min[i] = Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]); 
        	min[i] = Math.min(nums[i], min[i]);

        	globalMax = Math.max(max[i], globalMax); 
        }
        return globalMax; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
