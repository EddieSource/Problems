/*
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.

 
 */
public class _024_SwapLinkedListInPairs {
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
	 
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
    
        ListNode pairHead = head.next; 
        ListNode subhead = swapPairs(pairHead.next); 
    
        pairHead.next = head; 
        head.next = subhead; 
        return pairHead; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
