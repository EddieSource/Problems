import java.util.*; 

public class _958_checkCompletenessOfABinaryTree {
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
    public boolean isCompleteTree(TreeNode root) {
        // assumption, root is not null
    	boolean hasNull = false;
    	Queue<TreeNode> q = new ArrayDeque<>(); 
    	//initial state: 
    	q.offer(root); 
    	
    	while(!q.isEmpty()) {
    		//expand; 
    		TreeNode cur = q.poll(); 
    		if(cur.left != null) {
    			if(hasNull) return false; 
    			q.offer(cur.left); 
    		}
    		else hasNull = true;  
    		if(cur.right != null) {
    			if(hasNull) return false; 
    			q.offer(cur.right); 
    		}
    		else hasNull = true; 
    	}
    	return true; 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
