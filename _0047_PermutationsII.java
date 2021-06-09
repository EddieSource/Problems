import java.util.*; 
public class _0047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	// assumption: 1 <= nums.length <= 8
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res; 
        
        List<Integer> cur = new ArrayList<>(); 
        DFS(nums, 0, cur, res); 
        return res; 
    }
    public void DFS(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
    	if(index == nums.length) {
    		res.add(new ArrayList<>(cur)); 
    	}
    	//HashSet in each level
    	HashSet<Integer> set = new HashSet<>(); 
    	for(int i = index; i < nums.length; i++) {
    		if(set.contains(nums[i])) {
    			continue; 
    		}
    		set.add(nums[i]);
    		cur.add(nums[i]); 
    		swap(nums, i, index); 
    		DFS(nums, index + 1, cur, res); 
    		cur.remove(cur.size() - 1); 
    		swap(nums, i, index); 
    		
    	}
    }
    private void swap(int[] arr, int left, int right){
        int temp = arr[left]; 
        arr[left] = arr[right]; 
        arr[right] = temp; 
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
