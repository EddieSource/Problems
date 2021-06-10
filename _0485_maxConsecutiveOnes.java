import java.util.*; 
public class _0485_maxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0) return 0; 
    	int max = 0; 
    	int cur = 0; 
 
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == 1) {
    			cur++; 
    		}
    		//
    		else {
                max = Math.max(cur, max); 
    			cur = 0;  
    		}
    	}
        
    	return Math.max(max, cur); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
