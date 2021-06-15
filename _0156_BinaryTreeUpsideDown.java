public class _0156_BinaryTreeUpsideDown {
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // assumption: every node has either 0 or 2 children
    	if(root == null || (root.left == null && root.right == null)) {
    		return root; 
    	}
    	TreeNode leftChild = root.left, rightChild = root.right; 
    	TreeNode newRoot = upsideDownBinaryTree(root.left);
    	leftChild.left = rightChild; 
    	leftChild.right = root; 
    	root.left = null; 
    	root.right = null; 
    	
    	return newRoot; 
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
