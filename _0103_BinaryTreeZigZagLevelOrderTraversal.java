import java.util.*; 
public class _0103_BinaryTreeZigZagLevelOrderTraversal {
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
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>(); 
		if(root == null) return res; 
		int level = 0; 
		Deque<TreeNode> deq = new ArrayDeque<>(); 
		deq.offerFirst(root); 
		
		while(!deq.isEmpty()) { 
			List<Integer> cur_level = new ArrayList<>();
			int size = deq.size(); 
			if(level == 1) {
				for(int i = 0; i < size; i++) {
					TreeNode cur_node = deq.pollLast(); 
					cur_level.add(cur_node.val);
					if(cur_node.right != null) deq.offerFirst(cur_node.right); 
					if(cur_node.left != null) deq.offerFirst(cur_node.left); 
					
				}
				level = 0; 
			}
			else {
				for(int i = 0; i < size; i++) {
					TreeNode cur_node = deq.pollFirst(); 
					cur_level.add(cur_node.val);
					if(cur_node.left != null) deq.offerLast(cur_node.left); 
					if(cur_node.right != null) deq.offerLast(cur_node.right); 
				}
				level = 1; 
			}
			res.add(cur_level); 
		}
		return res; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
