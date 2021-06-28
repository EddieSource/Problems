import java.util.*; 
public class _0300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // assumption A is not null
    	if (nums.length == 0) return 0; 
    	int[] m = new int[nums.length]; 
    	// m[i] represents the length of longest subsequence ending at i
    	m[0] = 1; // initial status
    	int globalMax = m[0]; 

    	for (int i = 1; i < nums.length; i++) {
    		int maxSubLength = 1; 
    		for (int j = 0; j < i; j++) {
    			if (nums[i] > nums[j]) {// ascending
    				maxSubLength = Math.max(maxSubLength, m[j] + 1); 
    			} 
    			// if not we don't do anything just reset max SubLength
    		}
    		m[i] = maxSubLength; 
    		globalMax = Math.max(m[i], globalMax); 
    	}

    	return globalMax; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
