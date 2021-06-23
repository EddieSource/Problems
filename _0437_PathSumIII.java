import java.util.*; 
public class _0437_PathSumIII {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
    }
	
	public void helper(TreeNode root, Map<Integer, Integer> prefixSums, int prevSum, int targetSum, int[] number) {
		// base case
		if(root == null) return; 
		
		int curSum = prevSum + root.val; 
		// we have a path that can consist targetSum
		Integer num = prefixSums.get(curSum - targetSum); 
		if(num != null) {
			number[0] += num; 
		}
		
		Integer needRemove = prefixSums.get(curSum); 
		
		if(needRemove == null) prefixSums.put(curSum, 1);
		else prefixSums.put(curSum, needRemove + 1); 
		
		if(root.left != null) {
			helper(root.left, prefixSums, curSum, targetSum, number); 
		}
		if(root.right != null) {
			helper(root.right, prefixSums, curSum, targetSum, number); 
		}
		
		// remove it when go back to current level
		if(needRemove == null) prefixSums.remove(curSum); 
		else prefixSums.put(curSum, needRemove); 
		
	}
	
    public int pathSum(TreeNode root, int targetSum) {
    	if(root == null) return 0; 
        Map<Integer, Integer> prefixSumsToNum = new HashMap<>(); 
        int[] number = new int[] {0}; 
        
        // base case of the map
        prefixSumsToNum.put(0, 1); 
        
        helper(root, prefixSumsToNum, 0, targetSum, number);
        return number[0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
