import java.util.*; 
public class _0350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
    	// assumption
    	// small.kength >= 1 
    	int[] small, large; 
    	if(nums1.length < nums2.length) {
    		small = nums1; 
    		large = nums2; 
    	}
    	else {
    		small = nums2; 
    		large = nums1; 
    	}
        int[] res = new int[small.length]; 
        int ind = 0; 
        
        Map<Integer, Integer> numToCount = new HashMap<>(); 
        for(int num: small) {
        	if(numToCount.containsKey(num)) numToCount.put(num, numToCount.get(num) + 1); 
        	else numToCount.put(num, 1); 
        }
        
        for(int num: large) {
        	Integer count = numToCount.get(num); 
        	if(count != null && count > 0) {
    			res[ind] = num; 
    			numToCount.put(num, count - 1); 
    			ind++; 
        	}
        }
        
        return Arrays.copyOf(res, ind); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
