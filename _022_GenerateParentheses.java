import java.util.*; 
public class _022_GenerateParentheses {
	public void DFS(List<String> res, int left, int right, StringBuilder cur) {
		if(left == 0 && right == 0) {
			res.add(cur.toString()); 
			return; 
		}
		// for both branch it needs both conditions
		if(left > 0) {
			// choose left
			cur.append('('); 
			DFS(res, left - 1, right, cur); 
			cur.deleteCharAt(cur.length() - 1); 
		}
		
		if(left < right) {
			// choose right
			cur.append(')'); 
			DFS(res, left, right - 1, cur); 
			cur.deleteCharAt(cur.length() - 1); 	//remember to get back to the parent state
		}
	}
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); 
        StringBuilder cur = new StringBuilder(); 
        DFS(res, n, n, cur); 
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
