import java.util.*; 

public class _0105_ConstructBinaryTreeFromPreorderAndInorder {
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
	public TreeNode helper( int[] preorder, Map<Integer, Integer> pos, int preLeft, int preRight, int inLeft, int inRight) {
		if(inLeft > inRight) return null; 
		
		int rootVal = preorder[preLeft]; 
		int inposOfRoot = pos.get(rootVal);
        int LeftSize = inposOfRoot - inLeft; 
        
		TreeNode root = new TreeNode(rootVal); 
        
		root.left = helper(preorder, pos, preLeft + 1, preLeft + LeftSize, inLeft, inposOfRoot - 1);
        
		root.right = helper(preorder, pos, preLeft + LeftSize + 1, preRight, inposOfRoot + 1, inRight); 
		
        return root; 
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// initialze inorder position lookup 
		Map<Integer, Integer> pos = new HashMap<>(); 
		for(int i = 0; i < inorder.length; i++) {
			pos.put(inorder[i], i); 
		}
		int rootVal = preorder[0]; 
		
		return helper(preorder, pos, 0, preorder.length - 1, 0, inorder.length - 1); 
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
