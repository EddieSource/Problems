import java.util.*; 
public class _0090_Subsets2 {
	public void helper(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
		if(index == nums.length) {
			res.add(new ArrayList<>(cur)); 
			return; 
		}
		cur.add(nums[index]); 
		helper(nums, index + 1, cur, res); 
		cur.remove(cur.size() - 1); 
		
		while(index < nums.length - 1 && nums[index + 1] == nums[index]) {
			index++; 
		}
		
		helper(nums, index, cur, res); 
		
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> cur = new ArrayList<>(); 
        helper(nums, 0, cur, res ); 
        return res; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
