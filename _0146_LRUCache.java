import java.util.*; 
public class _0146_LRUCache {
	static class Node {
        // doubly linked list will realize O(1) time complexity for each operation
	    Node next; 
	    Node prev; 
	    int key; 
	    int value; 

	    Node(int key, int value){
	      this.key = key; 
	      this.value = value; 
	    }

	    void update(int key, int value){
	      this.key = key; 
	      this.value = value; 
	    }
	    
	}
	private Node head; 
	private Node tail; 
    private Map<Integer, Node> map; 
    private int capacity; 
	
    public _0146_LRUCache(int capacity) {
    	this.capacity = capacity; 
        this.map = new HashMap<>(); 
    }
    
    public int get(int key) {
        Node node = map.get(key); 
        if(node == null) {
          return -1; 
        }
        remove(node); 
        append(node); 
        return node.value; 
    }
    
    public void put(int key, int value) {
        Node node = null; 
        if(map.containsKey(key)){
          node = map.get(key); 
          node.value = value; 
          remove(node); 
          append(node); 
        }
        else if(map.size() < capacity){
          node = new Node(key, value); 
          append(node); 
        }
        else {
          node = tail; 
          remove(node); 
          node.update(key,value); 
          append(node); 
        } 
    }
    
    private Node remove(Node node){
        map.remove(node.key); 
        if(node.prev != null){
          node.prev.next = node.next; 
        }
        if(node.next != null){
          node.next.prev = node.prev; 
        }
        if(node == head){
          head = head.next; 
        }
        if(node == tail){
          tail = tail.prev; 
        }
        node.next = null; 
        node.prev = null; 
        return node; 
    }
    
    private Node append(Node node){
        map.put(node.key, node); 
        if(head == null) {
          head = node; 
          tail = node; 
        }
        else {
          node.next = head; 
          head.prev = node; 
          head = node; 
        }
        return node; 
      }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
