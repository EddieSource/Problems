
public class _0221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; 
        if(m == 0) return 0; 
        
        int n = matrix[0].length; 
        int max = 0; 
        
        int[][] maxEdgeEndingAt = new int[m][n]; 
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0 || j == 0) {
        			maxEdgeEndingAt[i][j] = matrix[i][j] == '1' ? 1 : 0; 
        		}
        		else if (matrix[i][j] == '1'){
        			maxEdgeEndingAt[i][j] = Math.min(maxEdgeEndingAt[i][j - 1] + 1, maxEdgeEndingAt[i - 1][j] + 1); 
        			maxEdgeEndingAt[i][j] = Math.min(maxEdgeEndingAt[i - 1][j - 1] + 1, maxEdgeEndingAt[i][j]); 
        		}
        		else {
        			maxEdgeEndingAt[i][j] = 0; 
        		}
    			max = Math.max(maxEdgeEndingAt[i][j], max); 
        	}
        }
        return max * max; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
