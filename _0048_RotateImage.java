import java.util.*; 
public class _0048_RotateImage {
    public void rotate(int[][] matrix) {
    	// assumption
        if(matrix.length == 0 || matrix[0].length == 0) return; 
        
        helper(matrix, 0, matrix[0].length); 
    }
    
    public void helper(int[][] matrix, int offset, int n) {
    	// middle one 
    	if(offset == n/2) return; 

    	for(int i = offset; i < n - 1 - offset; i++) {
        	int temp = matrix[i][n - 1 - offset]; 
        	matrix[i][n - 1 - offset] = matrix[offset][i]; 
        	matrix[offset][i] = matrix[n - 1 - i][offset]; 
        	matrix[n - 1 - i][offset] = matrix[n - 1 - offset][n - 1 - i]; 
        	matrix[n - 1 - offset][n - 1 - i] = temp; 
    	}


    	helper(matrix, offset + 1, n); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
