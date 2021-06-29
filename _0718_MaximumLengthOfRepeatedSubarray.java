import java.util.*;
public class _0718_MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        // assumption nums1.length > 0, nums2.length > 0
    	// assumption
        // assumption nums1.length > 0, nums2.length > 0
    	
    	int[][] m = new int[nums1.length + 1][nums2.length + 1]; 
    	// M[i][j]‌ ‌represents‌ ‌the‌ ‌length‌ ‌of‌ ‌the‌ ‌longest‌ ‌common‌ ‌substring‌ ‌between‌ ‌a[0..i-1]‌ ‌(the‌ ‌first‌ ‌i‌ ‌letters‌ ‌
    	// of‌ ‌a)‌ ‌and‌ ‌b[0..j-1]‌ ‌(the‌ ‌first‌ ‌j‌ ‌letters‌ ‌of‌ ‌b)‌ ‌‌that‌ ‌includes‌ ‌a[i-1]‌ ‌and‌ ‌b[j-1]‌ ‌
    	int solution = 0; 
        
    	for (int i = 0; i <= nums1.length; i++) {
    		for (int j = 0; j <= nums2.length; j++) {
    			// initial status
    			if(i == 0) m[i][j] = 0; 
    			else if (j == 0) m[i][j] = 0; 
    			
    			// induction rule
    			else {
    				if(nums1[i - 1] == nums2[j - 1]) {
                        m[i][j] = 1 + m[i - 1][j - 1]; 
                        solution = Math.max(m[i][j], solution); 
                    }
    				else m[i][j] = 0; 
    			}
    		}
    	}
    	
    	
    	return solution;
         
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
