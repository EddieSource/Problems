
public class _0053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // assumption: num.length >= 1
        // m[i] is the max sum of the subarray ending at i
//        int[] m = new int[nums.length]; 
        // 5, 4, -1, 7, 8
        // 5, 9, 8, 15, 23
        
        // initial state
//        m[0] = nums[0]; 
    	int cur = nums[0]; 
//        int max = m[0]; 
    	int max = cur; 
    	
        for(int i = 1; i < nums.length; i++){   // grow the array
//            if(m[i - 1] < 0) {
//                m[i] = nums[i]; 
//            }
            if(cur < 0) {
                cur = nums[i]; 
            }
//            else {
//                m[i] = m[i - 1] + nums[i]; 
//            }
            else {
                cur = cur + nums[i]; 
            }
//            max = Math.max(max, m[i]); 
            max = Math.max(max, cur); 
        }
        return max; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
