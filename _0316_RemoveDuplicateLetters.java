import java.util.*; 
public class _0316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
    	// greedy algo: use a stack to store the currently 
        // record the last occurrence of a char
    	
    	if(s == null || s.length() == 1) return s; 
    	
    	Map<Character, Integer> lastOccurrence = new HashMap<>(); 
        for(int i = 0; i < s.length(); i++) {
        	lastOccurrence.put(s.charAt(i), i); 
        }
        
        // record the current characters in the result
        Set<Character> in = new HashSet<>(); 
        
        // use a stack whose elements are all the result so far(at current i)
        Deque<Character> stack = new ArrayDeque<>(); 
        
        for(int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i); 
        	
        	if(in.contains(cur)) {
            	// if the top element in stack is greater than the current and will occurr later, we pop it
            	while(!stack.isEmpty() && cur < stack.peekFirst() && lastOccurrence.get(stack.peekFirst()) > i) {
            		in.remove(stack.pollFirst()); 
            	}
            	
            	stack.offerFirst(cur); 
            	in.add(cur); 
        	}

        	
        }
        
        char[] res = new char[stack.size()]; 
        for(int i = res.length - 1; i >= 0; i--) {
        	res[i] = stack.pollFirst(); 
        }
        
        return new String(res, 0, res.length); 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
