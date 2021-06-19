import java.util.*; 
public class _0045_JumpGameII {
    public int jump(int[] nums) {
        // assumption: nums.length >= 1
        int[] m = new int[nums.length]; 
        // initialize every element to be -1(never reaches)
        Arrays.fill(m, -1); 
        // m[i] means the minimum step it needs to get from i to last index
        // initial case: last index is nums.length - 1, and from last index to last index needs 0
        
        /* [2,3,0,1,4]
           [m,m,m,m,0]
           [-1,-1,-1,1,0]
           [-1,-1,-1,1,0]
           [-1,1,-1,1,0]
           [2,1,-1,1,0]
        */
        m[nums.length - 1] = 0; 
        for(int i = nums.length - 2; i >= 0; i--){
            int minStep = Integer.MAX_VALUE; 
            // traverse each step that current index can get
            for(int j = 1; j <= nums[i]; j++){
                // consider that i + j >= nums.length
                if(i + j >= nums.length || m[i + j] == -1) continue; 
                minStep = Math.min(minStep, 1 + m[i + j]); 
            }
            if(minStep != Integer.MAX_VALUE) {
                m[i] = minStep; 
            }
        }
        return m[0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
