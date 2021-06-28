import java.util.*; 
public class _0207_CourseSchedule1 {
	public boolean DFS(int node, List<List<Integer>> graph, HashMap<Integer, Integer> status) {
		status.put(node, 1); // start processing, update status
		
		for(int neighbor : graph.get(node)) {
			if(status.get(neighbor) == 1) return false; //find cycle
			
			else if(status.get(neighbor) == 0) { // not visited yet
				if(DFS(neighbor, graph, status) == false) return false; // if it is true we just keep going
			}
			
			// if it's already finished we don't do anything
		}
		
		status.put(node, 2); // finished update status
		return true; 
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> graph = new ArrayList<>(); 
    	for(int node = 0; node < numCourses; node++) {
    		graph.add(new ArrayList<>()); // index means the node
    	}
    	
    	for (int[] pair : prerequisites) {
    		int course = pair[0]; 
    		int prerequisite = pair[1]; 
    		graph.get(prerequisite).add(course); 
    	}	// create the graph
    	
    	
    	HashMap<Integer, Integer> status = new HashMap<>(); 
    	for(int node = 0; node < graph.size(); node++) {
    		status.put(node, 0); // new-state
    	}
    	// put every status to be new
    	
    	for(int node = 0; node < graph.size(); node++) {
    		if(status.get(node) == 0) {	// if it is new, we start our DFS cycle detection
    			if(DFS(node, graph, status) == false)return false; 
    		}
    	}
    	
    	return true; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
