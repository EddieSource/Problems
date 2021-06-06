import java.util.Comparator;
import java.util.PriorityQueue;

public class _0378_KthSmallestElementInASortedMatrix {
    static class Cell {
    	int row; 
    	int col; 
    	int val; 
    	Cell(int row, int col, int val){
    		this.row = row; 
    		this.col = col; 
    		this.val = val; 
    	}

    }
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if(c1.val == c2.val) return 0; 
				return c1.val < c2.val ? -1 : 1; 
			}
		});
		int rows = matrix.length; 
		int columns = matrix[0].length; 
		boolean[][] visited = new boolean[rows][columns]; 
		minHeap.offer(new Cell(0,0,matrix[0][0])); 
		for(int i = 0; i < k - 1; i++) {
			Cell curr = minHeap.poll(); 
			if(curr.row + 1 < rows && !visited[curr.row + 1][curr.col]) {
				visited[curr.row + 1][curr.col]= true; 
				minHeap.offer(new Cell(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col])); 
			}
			if(curr.col + 1 < columns && !visited[curr.row][curr.col + 1]) {
				visited[curr.row][curr.col + 1]= true; 
				minHeap.offer(new Cell(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1])); 
			}
		}
		return minHeap.peek().val; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
