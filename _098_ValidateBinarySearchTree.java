public class _098_ValidateBinarySearchTree {
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
	public boolean isValidBST_helper(TreeNode root, int min, int max) {
		if(root == null) return true; 
		if(root.val <= min || root.val >= max) return false; 
		boolean left_true = isValidBST_helper(root.left, min, root.val); 
		boolean right_true = isValidBST_helper(root.right, root.val, max); 
		return left_true && right_true; 
	}
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true; 
        return isValidBST_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
