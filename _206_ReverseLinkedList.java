
public class _206_ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    public ListNode reverseList_iterative(ListNode head) {
    	ListNode prev = null; 
        while(head != null) {
            ListNode next = head.next;
            head.next = prev; 
            prev = head; 
            head = next; 
        }
    	return head; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
