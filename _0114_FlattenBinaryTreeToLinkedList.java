import java.util.*;

public class _0114_FlattenBinaryTreeToLinkedList {
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
	public void helper(TreeNode root, TreeNode[] prev) {
		if(root == null) return; 
		TreeNode left = root.left; 
		TreeNode right = root.right; 
		
		if(prev[0] != null) {
			prev[0].right = root; 
		}
		
		root.left = null; 
		prev[0] = root; 
		
		helper(root.left, prev); 
		helper(root.right, prev); 
		
	}
    public void flatten(TreeNode root) {
    	TreeNode dummy = new TreeNode(); 
        TreeNode[] prev = new TreeNode[] {null}; // initial state for root
        helper(root, prev); 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
