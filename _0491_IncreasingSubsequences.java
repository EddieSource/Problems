import java.util.*; 
public class _0491_IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        if(nums.length == 0) return res; 
        
        List<Integer> cur = new ArrayList<>(); 
        DFS(nums, 0, cur, res); 
        return res; 
    }
    
    public void DFS(int[] nums, int index, List<Integer> cur, List<List<Integer>>res) {
    	if(index == nums.length) {
    		return; 
    	}
    	if(cur.isEmpty() || nums[index] >= cur.get(cur.size() - 1)) {
    		
    		
    		cur.add(nums[index]); 
    		// add since new value has been added
    		if(cur.size() >= 2) res.add(new ArrayList<>(cur)); 
    		DFS(nums, index + 1, cur, res); 
    		cur.remove(cur.size() - 1); 
    		
    		// deduplicate
//    		while(index < nums.length && nums[index] == nums[index]) {
//    			index++; 
//    		}
    		
    		
    		while(index < nums.length - 1 && !cur.isEmpty() && cur.get(cur.size() - 1) == nums[index]) {
    			index++; 
    		}
    		
    		
    		// no need to add since no new value has been added
    		DFS(nums, index + 1, cur, res); 
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0491_IncreasingSubsequences s = new _0491_IncreasingSubsequences(); 
		int[] nums = new int[] {1,3,1,1,1}; 
		System.out.println(s.findSubsequences(nums)); 
	}

}
