import java.util.*; 
public class _0141_LinkedListCycle {
	 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false; 
        
        ListNode slow = head, fast = head; 
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next; 
        	fast = fast.next.next; 
        	if(slow == fast) return true; 
        }
        return false; 
        
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
