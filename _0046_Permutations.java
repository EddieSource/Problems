import java.util.*; 
public class _0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>(); 
    	List<Integer> cur = new ArrayList<>(); 
    	DFS(nums, 0, cur, res); 
    	return res; 
        
    }
    public void swap(int[] nums, int a, int b) {
    	int temp = nums[a]; 
    	nums[a] = nums[b]; 
    	nums[b] = temp; 
    }
    
    public void DFS(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
    	if(index == nums.length) {
    		res.add(new ArrayList<>(cur)); 
    		return; 
    	}
    	for(int i = index; i < nums.length; i++) {
    		swap(nums, i, index); 
    		cur.add(nums[index]); 
    		
    		DFS(nums, index + 1, cur, res); 
    		
    		swap(nums, i, index); 
    		cur.remove(cur.size() - 1); 
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
