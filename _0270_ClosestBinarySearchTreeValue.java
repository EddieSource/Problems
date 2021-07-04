import java.util.*;

public class _0270_ClosestBinarySearchTreeValue {
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
	public void helper(TreeNode root, double target, int[] val) {
		// base case O(n) solution
		if(root == null) return; 
		
		double original_diff = Math.abs(val[0] - target); 
		double new_diff = Math.abs(root.val - target); 
		if(new_diff < original_diff) {
			val[0] = root.val; 
		}
		helper(root.left, target, val); 
		helper(root.right, target, val); 
		
	}
	public int closestValue(TreeNode root, double target) {
        // assumption: root is not null
		// initial state
		int[] val = new int[]{root.val}; 
		helper(root, target, val); 
		return val[0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
