import java.util.*; 
public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
    	int n = nums.length; 
        int real_sum = (0 + n) * (n + 1) / 2; 
        int cur_sum = 0; 
        for(int num: nums) {
        	cur_sum += num; 
        }
        return real_sum - cur_sum; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
