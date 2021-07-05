import java.util.*; 
public class _0138_CopyListWithRandomPointer {
	
	// Definition for a Node.
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
    public Node copyRandomList(Node head) {
        if(head == null) return null; 
		Map<Node, Node> lookup = new HashMap<>(); 
		
		// initial state
		Node copyHead = new Node(head.val);
		lookup.put(head, copyHead);  
		
		Node cur = copyHead; 
		while(head != null){
			// check if the next pointer is null - don't lose control of the parent pointer
			// so need to do processing for each parent instead of child in the while loop
		  if(head.next != null){
		    if(!lookup.containsKey(head.next)){
		      lookup.put(head.next, new Node(head.next.val)); 
		    }
		    cur.next = lookup.get(head.next); 
		  } //copy next
		  if(head.random != null){
		    if(!lookup.containsKey(head.random)){
		      lookup.put(head.random, new Node(head.random.val)); 
		    }
		    cur.random = lookup.get(head.random); 
		  }
		  head = head.next; 
		  cur = cur.next; 
		}
		
		return copyHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
