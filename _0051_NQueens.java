import java.util.*; 
public class _0051_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(); 
        List<String> cur = new ArrayList<>(); 
        DFS(n, 0, cur, res); 
        return res; 
    }
    public void DFS(int n, int row, List<String> cur, List<List<String>> res) {
    	if(row == n) {
    		res.add(new ArrayList<>(cur)); 
    	}
    	
    	// each row there is a default char array with all '.'
    	char[] arr = new char[n]; 
    	Arrays.fill(arr, '.');
    	
    	// select all cols
    	for(int col = 0; col < n; col++) {
    		// check if (row, col) is valid
    		if(isValid(cur, n, row, col)) {
    			arr[col] = 'Q'; 
    			cur.add(new String(arr, 0, n)); 
    			DFS(n, row + 1, cur, res); 
    			
    			arr[col] = '.'; 
    			cur.remove(cur.size() - 1); 
    		}
    	}	
    }
    
    public boolean isValid(List<String> cur, int n, int row, int col) {
    	// horizontal: no need to check since we are traversing each row
    	
    	// vertical 
    	// diagonal
    	for(int i = 0; i < row; i++) {
    		// if position row
    		int diff = row - i; 
    		if(cur.get(i).charAt(col) == 'Q' || col + diff < n && cur.get(i).charAt(col + row - i) == 'Q' || col - diff >= 0 && cur.get(i).charAt(col - diff) == 'Q') return false;
    	}
    	return true; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0051_NQueens solution = new _0051_NQueens(); 
		System.out.println(solution.solveNQueens(4)); 
	}

}
