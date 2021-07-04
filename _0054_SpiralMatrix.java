import java.util.*; 
public class _0054_SpiralMatrix {
	public void helper(int[][] matrix, int m, int n, int offset, List<Integer> res) {
		
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		/*
		 * m = 4, n = 5
		 * 
		 * offset = 0
		 * 0, 0 -> 0, 4
		 * 	|		|
		 * 3, 0	<- 3, 4
		 * 
		 * offset = 1
		 * 1, 1 -> 1, 3
		 * 	|		|
		 * 2, 1	<- 2, 3
		 * 
		 */
		List<Integer> list = new ArrayList<>(); 
		int m = matrix.length; 
		if(m == 0){
			return list; 
		}
		int n = matrix[0].length; 
	    int left = 0; 
	    int right = n - 1;
	    int up = 0; 
	    int down = m - 1; 
	    while(left < right && up < down){
	    	for(int i = left; i <= right; i++){
		        list.add(matrix[up][i]); 
		    }
		    for(int i = up + 1; i <= down - 1; i++){
		        list.add(matrix[i][right]); 
		    }
		    for(int i = right; i >= left; i--){
		    	list.add(matrix[down][i]); 
		    }
		    for(int i = down - 1; i >= up + 1; i--){
		        list.add(matrix[i][left]); 
		    }
	      left++;
	      right--; 
	      up++; 
	      down--; 
	    }
	    
	    //nothing left
	    if(left > right || up > down){
	      return list; 
	    }

	    //one column left; 
	    if(left == right){
	      for(int i = up; i <= down; i++){
	        list.add(matrix[i][left]); 
	      }
	    }

	    //one row left; 
	    else{
	      for(int i = left; i <= right; i++){
	        list.add(matrix[up][i]);
	      }
	    }
	    return list; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
