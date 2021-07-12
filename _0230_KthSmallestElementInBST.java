import java.util.*;

public class _0230_KthSmallestElementInBST {
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
    public int kthSmallest(TreeNode root, int k) {
    	// O(k) time complexity
    	// O(logn) space complexity
        if(root == null) return 0; 
        int[] res = new int[1];
        int[] kth = new int[] {k}; //k starts from 1
        helper(root, kth, res); 
        return res[0]; 
    }
    public void helper(TreeNode root, int[] kth, int[] res) {
    	if(root == null) return; 
    	helper(root.left, kth, res); 
    	
    	kth[0]--; 
    	if(kth[0] == 0) {
    		res[0] = root.val;
    		return; 
    	}
    	
    	helper(root.right, kth, res); 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
