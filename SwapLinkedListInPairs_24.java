
public class SwapLinkedListInPairs_24 {
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
