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
    	if(cur.size() >= 2) {
    		res.add(new ArrayList<>(cur)); 
    	}
    	
    	Set<Integer> s = new HashSet<>(); 

    	for(int i = index; i < nums.length; i++) {
            // checking if our current picked element is greater than last pushed element in our sub result & our Hashset has no occurence of that element 
            if((cur.isEmpty() || nums[i] >= cur.get(cur.size() - 1)) && !s.contains(nums[i])){                                                       
                s.add(nums[i]); 
                cur.add(nums[i]); 
                DFS(nums, i + 1, cur, res);      // recurr for next elements and add it our sub_res, if it's satisfying the condition
                
                cur.remove(cur.size() - 1);  // BACKTRACKING STEP
            }
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0491_IncreasingSubsequences s = new _0491_IncreasingSubsequences(); 
		int[] nums = new int[] {1,3,1,1,1}; 
		System.out.println(s.findSubsequences(nums)); 
	}

}
