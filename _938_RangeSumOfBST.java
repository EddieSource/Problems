
public class _938_RangeSumOfBST {
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int left_sum = 0, right_sum = 0, middle = 0; 
        if(low < root.val) left_sum = rangeSumBST(root.left, low, high); 
        if(root.val >= low && root.val <= high) middle = root.val; 
        if(high > root.val)right_sum = rangeSumBST(root.right, low, high);
        return left_sum + right_sum + middle; 
        
    }
    
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
