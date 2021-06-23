import java.util.*; 

public class _0106_ConstructBinaryTreeFromInorderAndPostOrder {
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
        public TreeNode helper(int[] postorder, int postleft, int postright, int inleft, int inright, Map<Integer, Integer> inPos) {
        	// [1 3 2 6 5 4]
        	// [1 2 3 4 5 6]
        	if(inleft > inright) return null; 
        	TreeNode root = new TreeNode(postorder[postright]); 
        	int inPosOfRoot = inPos.get(root.val); 
            
        	int rightSize = inright - inPosOfRoot; 
        	root.left = helper(postorder, postleft, postright - rightSize - 1, inleft, inPosOfRoot - 1, inPos); 
            
        	root.right = helper(postorder, postright - rightSize, postright - 1, inPosOfRoot + 1, inright, inPos); 
        	return root; 
        	
        }
            
        public TreeNode buildTree(int[] inorder, int[] postorder) {
        	if (inorder.length == 0 || postorder.length == 0) return null; 
        
        	Map<Integer, Integer> inPos = new HashMap<>(); 
        	for(int i = 0; i < inorder.length; i++) {
        		inPos.put(inorder[i], i); 
        	}
        	
        	return helper(postorder, 0, inorder.length - 1, 0, postorder.length - 1, inPos); 
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
