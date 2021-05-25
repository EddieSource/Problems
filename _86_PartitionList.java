public class _86_PartitionList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(-1); 
        ListNode largeList = new ListNode(-1); 
        ListNode curOfSmall = smallList; 
        ListNode curOfLarge = largeList; 
        
        while(head != null) {
        	if(head.val < x) {
        		 curOfSmall.next = head; 
        		 curOfSmall = curOfSmall.next; 
        		 head = head.next; 
        	}
        	else {
        		curOfLarge.next = head; 
        		curOfLarge = curOfLarge.next; 
        		head = head.next; 
        	}
        	
        }
        curOfSmall.next = largeList.next;  
        curOfLarge.next = null; // this line is very important
        return smallList.next; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
