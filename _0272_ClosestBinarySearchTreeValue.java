import java.util.*;

public class _0272_ClosestBinarySearchTreeValue {
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
	public void helper(TreeNode root, double target, int k, Queue<Integer> window) {
		if(root == null) return; 
		helper(root.left, target, k, window); 
		if(window.size() < k) {
			window.offer(root.val); 
		}
		else if(Math.abs(root.val - target) < Math.abs(window.peek() - target)) {
				window.poll(); 
				window.offer(root.val);
		}
		helper(root.right, target, k, window); 
	}
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> window= new ArrayDeque<>(); 
        helper(root, target, k, window); 
        List<Integer> res = new ArrayList<>(); 
        while(!window.isEmpty()) {
        	res.add(window.poll()); 
        }
        return res; 
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
