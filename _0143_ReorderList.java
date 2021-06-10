import java.util.*; 
public class _0143_ReorderList {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head; 
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next; 
			slow = slow.next; 
		}
		return slow; 
	}
	
	public ListNode reverse(ListNode head) {
		ListNode pre = null; 
		while(head != null) {
			ListNode next = head.next; 
			head.next = pre; 
			pre = head; 
			head = next; 
		}
		return pre; 
	}
	
	public void merge(ListNode firstHalf, ListNode secondHalf) {
		// first half might be longer than the second half when the length is odd
		ListNode dummy = new ListNode(); 
		ListNode head = firstHalf; //keep track of head
		
		ListNode cur = dummy; 
		while(secondHalf != null) {
			cur.next = firstHalf;
			firstHalf = firstHalf.next; 
			cur = cur.next; 
			
			cur.next = secondHalf; 
			secondHalf = secondHalf.next; 
			cur = cur.next; 
		}
		if(firstHalf != null) cur.next = firstHalf; // if the length is odd
		
		// dereference the head
		head.next = dummy.next.next; 
	}
	
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) return; 
    	 
        
        ListNode mid = findMid(head); 
        ListNode secondHalf = mid.next; 
        mid.next = null; //make the last element of the firstHalf to be null
        
        secondHalf = reverse(secondHalf);
        merge(head, secondHalf); 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
