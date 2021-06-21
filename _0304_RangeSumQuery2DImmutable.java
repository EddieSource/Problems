import java.util.*; 
public class _0304_RangeSumQuery2DImmutable {
//    public NumMatrix(int[][] matrix) {
	int[][] prefix; //m[i][j] means the 2d sum whose left up point is 0, 0 and right down point is i, j
    public _0304_RangeSumQuery2DImmutable(int[][] matrix) {
    	int m = matrix.length; 
    	int n = matrix[0].length; 
        if(m == 0 || n == 0) return; 
        prefix = new int[m + 1][n + 1]; 
        
        for(int r = 0; r < m; r++) {
        	for(int c = 0; c < n; c++) {
        			prefix[r + 1][c + 1] = matrix[r][c] + prefix[r][c + 1] + prefix[r + 1][c] - prefix[r][c]; 
        	}
        		
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	return prefix[row2 + 1][col2 + 1] - prefix[row2 + 1][col1] - prefix[row1][col2 + 1] + prefix[row1][col1]; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix [][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}}; 
		
		_0304_RangeSumQuery2DImmutable a = new _0304_RangeSumQuery2DImmutable(matrix); 
		a.sumRegion(2, 1, 4, 3); 

	}

}
