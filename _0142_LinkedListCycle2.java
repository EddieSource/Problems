import java.util.*; 
public class _0142_LinkedListCycle2 {
	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  public ListNode cycleNode(ListNode head) {
		    // write your solution here
		    if(head == null || head.next == null) return null; 
		    Set<ListNode> visited = new HashSet<>(); 
		    // 0 means start, 1 means finished, NUll means not visited yet
		    ListNode res = findCycle(head, visited); 
		    
		    return res;
		  }
		  private ListNode findCycle(ListNode node, Set<ListNode> visited){
		    if(visited.contains(node)){
		      // find cycle
		      return node; 
		    }
		    if(node.next == null) return null; 
		    visited.add(node); 
		    return findCycle(node.next, visited); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
