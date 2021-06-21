import java.util.*; 
public class _0020_ValidParentheses {
	    public boolean isValid(String s) {
	        Deque<Character> stack = new ArrayDeque<>(); 
	        if(s.length() == 0) return false; 
	        for(int i = 0; i < s.length(); i++) {
	        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
	        	stack.offerFirst(s.charAt(i)); 
	        }
	        	else if(s.charAt(i) == ')' && (stack.isEmpty() || stack.pollFirst() != '(')) return false; 
	        	else if(s.charAt(i) == ']' && (stack.isEmpty() || stack.pollFirst() != '[')) return false; 
	        	else if(s.charAt(i) == '}' && (stack.isEmpty() || stack.pollFirst() != '{')) return false; 
	 	
	        }
	        if(stack.isEmpty()) return true; 
	        return false; 
	    }
		public static void main(String[] args) {
		// TODO Auto-generated method stub

		}

}
