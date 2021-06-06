
public class _0110_balancedBinaryTree {
		 
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
	public int isBalanced_helper(TreeNode root) {
		if(root == null) return 0; 
		int left_height = isBalanced_helper(root.left); 
		int right_height = isBalanced_helper(root.right); 
		if(left_height < 0 || right_height < 0) return -1;
		
		if(Math.abs(left_height - right_height) <= 1) return Math.max(left_height, right_height) + 1; 
		else return -1; 
		
	}
    public boolean isBalanced(TreeNode root) {
        int res = isBalanced_helper(root); 
        return res >= 0; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
