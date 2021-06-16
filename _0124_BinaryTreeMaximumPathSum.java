
public class _0124_BinaryTreeMaximumPathSum {
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
	
    public int maxPathSum(TreeNode root) {
        // path does not need to pass through root
    	
		// ? expect from each child: the largest path starting from the child
		// ? what to do in each layer: 
		// consider the current root and update max if necessary
		
		// ? what to give: the largest path starting from the current root
		int[] max = new int[] {Integer.MIN_VALUE}; 
    	helper(root, max); 
		
    	return max[0]; 
    }
    
    public int helper(TreeNode root, int[] max) {
    	if(root == null) return 0; 
    	int left = helper(root.left, max); 
    	int right = helper(root.right, max); 
    	
    	left = left < 0 ? 0: left; 
    	right = right < 0 ? 0: right; 
    	max[0] = Math.max(root.val + left + right, max[0]); 
    	return root.val + Math.max(left,  right); 
    		
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


	}

}
