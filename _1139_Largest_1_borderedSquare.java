import java.util.*; 

public class _1139_Largest_1_borderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        
    	int m = grid.length; 
    	int n = grid[0].length; 
    	if(m == 0 || n == 0) {
    		return 0; 
    	}
    	// make sure both are not 0
    	
 	
    	// longest subarray 1 from up to down ending at i, j
    	int[][] up = new int[m][n]; 
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(i == 0) {
    				up[i][j] = grid[i][j] == 1 ? 1 : 0; 
    			}
    			else {
    				up[i][j] = grid[i][j] == 1 ? up[i - 1][j] + 1 : 0; 
    				
    			}
    		}
    	}
    	
    	
    	// longest subarray 1 from left to right ending at i, j
    	int[][] left = new int[m][n]; 
    	
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(j == 0) {
    				left[i][j] = grid[i][j] == 1 ? 1 : 0; 
    			}
    			else {
    				left[i][j] = grid[i][j] == 1 ? left[i][j - 1] + 1 : 0; 	
    			}
    		}
    	}
    	
    	int globalMax = 0; 
    	
    	// compare the max edge of the square which has the largest angle at i, j
    	for(int r = 0; r < m; r++) {
    		for(int c = 0; c < n; c++) {
    			// check if 
    			int maxEdge = Math.min(up[r][c], left[r][c]); 
    			for(int edge = maxEdge; edge >= 1; edge--) {
    				if(left[r - edge + 1][c] >= edge && up[r][c - edge + 1] >= edge) {
    					globalMax = Math.max(edge, globalMax); 
    					break; 
    				}
    			}
    		}
    	}
    	return globalMax * globalMax; 
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
