import java.util.*; 
public class _0133_CloneGraph {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
    public Node cloneGraph(Node node) {
        // lets first use the BFS method
    	if(node == null) return null; 
    	
    	HashMap<Node, Node> generated = new HashMap<>(); 
    	Queue<Node> realQ = new LinkedList<>();

    	// initial state 
    	realQ.offer(node); 

    	
    	Node cloneRoot = new Node(node.val); //initialized value

    	
    	// important to initialize the generated map
    	generated.put(node, cloneRoot); 
    	
    	while(!realQ.isEmpty()) {
    		//expand
    		Node realNode = realQ.poll(); 
    		Node cloneNode = generated.get(realNode); 
    		
    		//generate
    		for(Node realNeighbor: realNode.neighbors) {
    			Node cloneNeighbor = generated.get(realNeighbor); 
    			if(cloneNeighbor == null) {
    				// real neighbor has not been generated yet
    				
    				// initialize the new neighbor
    				cloneNeighbor = new Node(realNeighbor.val);
    				
    				// add it to the current clone node
    				cloneNode.neighbors.add(cloneNeighbor); 
    				
    				// add the new node to neighbor
    				generated.put(realNeighbor, cloneNeighbor); 
    				
    				realQ.offer(realNeighbor); 

    			}
    			else {
    				cloneNode.neighbors.add(cloneNeighbor); 
    			}
    		}
    		
    	}
    	return cloneRoot; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
