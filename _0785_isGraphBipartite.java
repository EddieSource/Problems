import java.util.*; 
public class _0785_isGraphBipartite {
	public static boolean isBipartite_helper(int node, int[][]graph, Map<Integer, Integer> mapNodeToGroup) {
        //already expanded this one
		
        Queue<Integer> q = new ArrayDeque<>(); 
        //initial state; 
        q.offer(node); 
        mapNodeToGroup.put(node, 0); 
        
        while(!q.isEmpty()) {
        	int cur_node = q.poll();
        	
        	int cur_group = mapNodeToGroup.get(cur_node); 
        	int nei_group = cur_group == 0? 1: 0; 
        	
        	for(int nei_node: graph[cur_node]) {
        		if(mapNodeToGroup.get(nei_node)==null) {
        			mapNodeToGroup.put(nei_node, nei_group); 
        			q.offer(nei_node); 
        		}
        		else if(mapNodeToGroup.get(nei_node) != nei_group) {
        			return false; 
        		}
        	}
        }
        return true; 
        
	}
    
	public static boolean isBipartite(int[][] graph) {
		//first integer is the node, second one is the group
		
        Map<Integer, Integer> map = new HashMap<>();
        for(int node = 0; node < graph.length; node++) {
        	if(map.get(node)==null) {
        		if(!isBipartite_helper(node, graph, map)) return false; 
        	}
        }
        return true; 
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}; 
		System.out.println(isBipartite(graph)); 

	}

}
