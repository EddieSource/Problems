
public class _1644_LowestCommonAncestorII {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        
    	
//    	if (root == null) return null; 
    	if (root == null || root.val == p.val || root.val == q.val) return root; 
        
        TreeNode left = lowestCommonAncestorI(root.left, p, q);
        TreeNode right = lowestCommonAncestorI(root.right, p, q);
        
        if(left == null && right == null) return null; 
        else if(left == null) return right; 
        else if(right == null) return left; 
        else return root; 
        
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p, q not necessarily on the tree
    	// if returns treeNode rather than p, q we know they are in the same tree
    	// if returns p || q: 1. directly belongs: returns p||q 3. the other is not in the tree: returns null
    	// if returns null: p & q not in the tree: returns null
    	TreeNode res = lowestCommonAncestorI(root, p, q); 
    	if(res == null) return null; 
    	if(res.val == p.val && lowestCommonAncestorI(p,q,q) == null) {
    		// if p contains q(1st case)
    		return null; 
    	}
    	if(res.val == q.val && lowestCommonAncestorI(q,p,p) == null) {
    		// if q contains p(1st case)
    		return null; 
    	}
    	return res; 
    	
    }

}
