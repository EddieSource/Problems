
public class _674_LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
    	if(nums.length == 0) return 0; 
    	// m[i] the size of the largest substring ending with nums[i] inclusive
    	int[] m = new int [nums.length]; 
    	m[0] = 1; 
    	int max = 1; 
    	for(int i = 1; i < nums.length; i++) {
    		// depends on sub solutions
    		if(nums[i] > nums[i - 1]) {
    			m[i] = m[i - 1] + 1; 
    		}
    		else {
    			max = Math.max(m[i - 1], max); 
    			m[i] = 1; 
    		}
    	}
    	max = Math.max(m[nums.length - 1], max); 
    	
    	return max; 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
	}

}
