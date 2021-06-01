import java.util.*;
public class _102_BinaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); //initial state
        
        while(!q.isEmpty()) {
        	List<Integer> level = new ArrayList<>(); 
        	int level_length = q.size(); 
        	for(int i = 0; i < level_length; i++) {
        		TreeNode curr = q.poll(); 
        		level.add(curr.val); //visit its value
        		if(curr.left != null) {
        			TreeNode left = curr.left; 
        			q.offer(left);  
        		}
        		if(curr.right != null) {
        			TreeNode right = curr.right; 
        			q.offer(right); 
        		}
        	}
        	res.add(level); 	
        }
        return res; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
