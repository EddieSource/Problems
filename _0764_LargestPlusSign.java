import java.util.*; 
public class _0764_LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
    	// assumption: mine.length >= 1; 
        HashSet<Integer> set = new HashSet<>(); 
        for(int[] mine : mines) {
        	int loc = mine[0] * n + mine[1]; 
        	set.add(loc); 
        }
        
        
        // up matrix
        int[][] up = new int[n][n]; 
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0) {
        			// if the first row
        			up[i][j] = set.contains(i * n + j) ? 0 : 1; 
        		}
        		else {
            		up[i][j] = set.contains(i * n + j) ? 0: up[i - 1][j] + 1; 
        		}
        	}
        }
             
        // down matrix
        int[][] down = new int[n][n]; 
        for(int i = n - 1; i >= 0; i--) {
        	for(int j = 0; j < n; j++) {
        		if(i == n - 1) {
        			// if the last row
        			down[i][j] = set.contains(i * n + j) ? 0 : 1; 
        		}
        		else {
            		down[i][j] = set.contains(i * n + j) ? 0: down[i + 1][j] + 1; 
        		}
        	}
        }
        
        
        // left matrix
        int[][] left = new int[n][n]; 
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(j == 0) {
        			// if the last row
        			left[i][j] = set.contains(i * n + j) ? 0 : 1; 
        		}
        		else {
            		left[i][j] = set.contains(i * n + j) ? 0: left[i][j - 1] + 1; 
        		}
        	}
        }
        
        
        // right matrix
        int[][] right = new int[n][n]; 
        for(int i = 0; i < n; i++) {
        	for(int j = n - 1; j >= 0; j--) {
        		if(j == n - 1) {
        			// if the last row
        			right[i][j] = set.contains(i * n + j) ? 0 : 1; 
        		}
        		else {
            		right[i][j] = set.contains(i * n + j) ? 0: right[i][j + 1] + 1; 
        		}
        	}
        }
        
        
        // start fill the res 
        int maxEdge = -1; 
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int verticalLimit = Math.min(up[i][j], down[i][j]); 
        		int horizontalLimit = Math.min(right[i][j], left[i][j]); 
        		int curLimit = Math.min(verticalLimit, horizontalLimit); 
        		maxEdge = Math.max(curLimit, maxEdge); 
        	}
        }
        
        return maxEdge; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
