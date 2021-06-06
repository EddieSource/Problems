import java.util.*; 
public class _0039_CombinationSum {
	public void DFS(int[] candidates, int index, int target, List<Integer> cur, List<List<Integer>> res) {
		// how many levels: candidate.length levels
		// what's inside each level? states: how many coins at most can form the target
		if(target == 0) {
			res.add(new ArrayList<>(cur)); 
			return; 
		}
		if(index == candidates.length) {
			return; 
		}
		for(int numOfCoin = 0; numOfCoin <= target/candidates[index]; numOfCoin++) {
			for(int i = 0; i < numOfCoin; i++) {
				cur.add(candidates[index]); 
			}
			DFS(candidates, index + 1, target - numOfCoin * candidates[index], cur, res); 
			// return to original state
			for(int i = 0; i < numOfCoin; i++) {
				cur.remove(cur.size() - 1); 
			}
		}
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> cur = new ArrayList<>(); 
        DFS(candidates, 0, target, cur, res); 
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
