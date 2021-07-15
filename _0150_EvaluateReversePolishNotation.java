import java.util.*; 
public class _0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	// assumption: RPN is always valid
        Deque<Integer> stack = new ArrayDeque<>(); 
        for(String token: tokens) {
        	if(token.equals("+")) {
        		int y = stack.pollFirst(); 
        		int x = stack.pollFirst();
        		int res = x + y; 
        		stack.offerFirst(res); 
        	}
        	else if(token.equals("-")) {
        		int y = stack.pollFirst(); 
        		int x = stack.pollFirst();
        		int res = x - y; 
        		stack.offerFirst(res); 
        	}
        	else if(token.equals("*")) {
        		int y = stack.pollFirst(); 
        		int x = stack.pollFirst();
        		int res = x * y; 
        		stack.offerFirst(res); 
        	}
        	else if(token.equals("/")) {
        		int y = stack.pollFirst(); 
        		int x = stack.pollFirst();
        		int res = x / y; 
        		stack.offerFirst(res); 
        	}
        	else {
        		int num = stringToNum(token); 
        		stack.offerFirst(num); 
        	}
        }
        
        return stack.pollFirst(); 
    }
    
    private int stringToNum(String token) {
    	int res = 0; 
    	boolean positive = true; 
    	for(int i = 0; i < token.length(); i++) {
    		if(token.charAt(i) == '-') {
    			positive = false; 
    			continue; 
    		}
    		res = res * 10 + (token.charAt(i) - '0'); 
    	}
    	if(!positive) res = 0 - res; 
    	return res; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[] {"4","13","5","/","+"}; 
		_0150_EvaluateReversePolishNotation a = new _0150_EvaluateReversePolishNotation(); 
		a.evalRPN(s); 
		

	}

}
