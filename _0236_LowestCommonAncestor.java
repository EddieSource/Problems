
public class _0236_LowestCommonAncestor {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	
//    	if (root == null) return null; 
    	if (root == null || root.val == p.val || root.val == q.val) return root; 
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null) return null; 
        else if(left == null) return right; 
        else if(right == null) return left; 
        else return root; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
