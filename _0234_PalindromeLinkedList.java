
public class _0234_PalindromeLinkedList {
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	public ListNode mid(ListNode head) {
	    if (head == null || head.next == null) return head; 
	    ListNode slow = head; 
	    ListNode fast = head; 
	    while(fast.next != null && fast.next.next != null) {
	      slow = slow.next; 
	      fast = fast.next.next; 
	    }
	    return slow; 
	  }
	      public ListNode reverse(ListNode head) {
	    if (head == null || head.next ==null) return head; 
	    ListNode newHead = reverse(head.next); 
	    head.next.next = head;
	    head.next = null;  
	    return newHead; 
	  }
	    
	    public boolean isPalindrome(ListNode head) {
	         if(head == null || head.next == null) return true; 
	    // Write your solution here
	    ListNode midNode = mid(head); 
	    ListNode head1 = head; 
	    ListNode head2 = reverse(midNode.next); 
	    ListNode curr1 = head1; 
	    ListNode curr2 = head2; 
	    midNode.next = null;
	    while(curr2 != null) {
	      if (curr1.val != curr2.val) return false; 
	      curr1 = curr1.next; 
	      curr2 = curr2.next; 
	    }

	    // ListNode head2 = reverse(head2); 
	    // midNode.next = head2; 
	    return true; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
