public class _0100_SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; 
        else if(p == null) return false; 
        else if(q == null) return false; 
        boolean isLeftIdentical = isSameTree(p.left, q.left); 
        boolean isRightIdentical = isSameTree(p.right, q.right); 
        return p.val == q.val && isLeftIdentical && isRightIdentical; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
