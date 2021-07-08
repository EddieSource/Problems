import java.util.*; 
public class _0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // for k sum solution
    	// k sum needs k - 2 nested loop
    	// time complexity: O(n^k-1) (k-2 nested loop + O(n) for two sum
    	// space complexity: O(n) for stack(recursion)
    	Arrays.sort(nums); 
    	return kSum(nums, target, 0, 4); 
        
        
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
    	List<List<Integer>> res = new ArrayList<>(); 
    	// terminated condition: k * the minimum value > target or k * maximum value  <target
    	if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target) {
    		return res; 
    	}
    	
    	// we do a 2 sum if k == 2
    	if(k == 2) {
    		return twoSum(nums, target, start); 
    	}
    	for (int i = start; i < nums.length; ++i) {
    		// deduplication
    		/* i is the current element in the current loop. for the case 2 2 2 2 2, 8 it can work 
    		 * since the current loop will iterate every 2 and the nums[i] != nums[i - 1] will only prevent it from going from current loop
    		 * future 2 will be processed as the same matter as we run more loops
    		*/
    		if(i == start || nums[i] != nums[i - 1]) {
    			for(List<Integer> set: kSum(nums, target - nums[i], i + 1, k - 1)) {
    				res.add(new ArrayList<>(Arrays.asList(nums[i]))); 
    				res.get(res.size() - 1).addAll(set); 
    			}
    		}
    	}
    	return res; 
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // the second condition is for deduplication
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            // the second condition is for deduplication
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
