import java.util.*; 
public class _0023_MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    
    public ListNode mergeKLists(ListNode[] lists) {
    	// time complexity k * n * logk // if n is the average length of each linkedlists in lsits
    	
    	// if there's no lists
    	if(lists.length == 0) return null; 
    	
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode cur, ListNode other) {
        		if(cur.val == other.val) return 0; 
        		return cur.val < other.val ? -1: 1; 
        	}
        }); 
        
        for(ListNode node: lists) {
        	// if the lists contains null listnode we shouldn't offer it into the queue
        	if(node != null) minHeap.offer(node); 
        }
        
        ListNode dummy = new ListNode(); 
        ListNode ind = dummy; 
        
        while(!minHeap.isEmpty()) {
        	ListNode cur = minHeap.poll();
        	
        	// update the result list
        	ind.next = cur; 
        	ind = ind.next; 
        	
        	// update the priority queue
        	cur = cur.next; 
        	if(cur != null) minHeap.offer(cur); 
        }
        
        ind.next = null; 
        return dummy.next; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
