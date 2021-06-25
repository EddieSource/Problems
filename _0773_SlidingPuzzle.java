import java.util.*; 
public class _0773_SlidingPuzzle {
	public int myHash(int[][] board) {
		int code = 0; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				code = code * 10 + board[i][j]; 
			}
		}
		return code; 
	}
	
	public int[] findZero(int[][] board){
		int[] pos = new int[2]; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0) {
					pos[0] = i; 
					pos[1] = j; 
					return pos; 
				}
			}
		}
		return null; 
	}
	public void swap(int[][] board, int r1, int c1, int r2, int c2) {
		int temp = board[r1][c1]; 
		board[r1][c1] = board[r2][c2]; 
		board[r2][c2] = temp; 
	}
	public boolean outOfBound(int[][] board, int r, int c) {
		if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return true; 
		return false; 
	}
	
	public int[][] copyOf(int[][] matrix){
		int[][] copy = new int[matrix.length][matrix[0].length]; 
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				copy[i][j] = matrix[i][j]; 
			}
		}
		return copy; 
	}

    public int slidingPuzzle(int[][] board) {
    	// each graphNode is one of the board
    	int[][] startBoard = new int[][]{{1,2,3},{4,5,0}}; 
    	int startCode = myHash(startBoard); 	// from solution to each graphNode
    	
    	int endCode = myHash(board); 
    	
    	Map<Integer, Integer> codeToStep = new HashMap<>(); 
    	Queue<int[][]> q = new ArrayDeque<>(); 
    	q.offer(startBoard);
    	
    	codeToStep.put(startCode, 0); 
    	int[][] directions = new int[][] {{1,0}, {-1, 0},{0,1},{0,-1}}; 
    	
    	
    	while(!q.isEmpty()) {
    		int[][] curBoard = q.poll(); 
    		int curCode = myHash(curBoard);
    		Integer step = codeToStep.get(curCode); 		
    		int[] zeroPos = findZero(curBoard); 
    		for(int[] direction : directions) {
    			int[] newZeroPos = new int[] {zeroPos[0] + direction[0], zeroPos[1] + direction[1]}; 
    			if(!outOfBound(board, newZeroPos[0], newZeroPos[1])) {
    				swap(curBoard, newZeroPos[0], newZeroPos[1], zeroPos[0], zeroPos[1]); //out of if because of more time efficient, no need to copy a 2d array every time
    				if(!codeToStep.containsKey(myHash(curBoard))) {
        				int[][] newBoard = copyOf(curBoard); 
        				q.offer(newBoard); 
        				codeToStep.put(myHash(curBoard), step + 1); 
    				}
    				// swap back
    				swap(curBoard, newZeroPos[0], newZeroPos[1], zeroPos[0], zeroPos[1]); 
    			}
    		}
    		
    	}
    	
    	return codeToStep.getOrDefault(endCode, -1); 
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0773_SlidingPuzzle s = new _0773_SlidingPuzzle(); 
		int[][] board = new int[][] {{1,2,3},{4,0,5}}; 
		System.out.println(s.slidingPuzzle(board)); 

	}

}
