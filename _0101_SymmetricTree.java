

public class _0101_SymmetricTree {
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
	public boolean isSymmetric_helper(TreeNode left, TreeNode right) { 
		if(left == null && right == null) return true; 
		else if(left == null || right == null) return false; 
		else if(left.val != right.val) return false; 
		else return isSymmetric_helper(left.left, right.right) && isSymmetric_helper(left.right, right.left);
	}
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true; 
        return isSymmetric_helper(root.left, root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
