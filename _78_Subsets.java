import java.util.*; 
public class _78_Subsets {
	public static void DFS(int[] nums, List<List<Integer>> res, int index, List<Integer> cur) {
		if(index == nums.length) {
			// pay attention to do a hard copy of cur each time adding it
			res.add(new ArrayList<>(cur)); 
			return; 
		}
		// choose nums[index]
		cur.add(nums[index]); 
		DFS(nums, res, index + 1, cur); 
		
		// don't choose nums[index]
		cur.remove(cur.size()-1); 
		DFS(nums, res, index + 1, cur); 
		
	}
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> cur = new ArrayList<>();
        int index = 0;
        DFS(nums, res, index, cur); 
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,3}; 
		subsets(nums); 
		

	}

}
