
public class _0235_LowestCommonAncestorOfABST {
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
        // small <= ancestor.val <= large
		// ancestor is the shallowest
		// case1: small <= ancestor.val <= large return ancestor
		// case2: small <= large < ancestor.val root = root.left
		// case3: ancestor.val < small <= large root = root.right
		TreeNode small, large; 
        if(p.val < q.val){
            small = p; 
            large = q; 
        }
        else {
        	small = q; 
        	large = p; 
        }
        
        while(root != null) {
        	if(root.val >= small.val && root.val <= large.val) return root; 
        	else if(root.val < small.val) root = root.right; 
        	else root = root.left; //(root.val > large.val) 
        }
        return  null; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
