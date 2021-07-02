import java.util.*; 
public class _1209_RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        /*
        deeedbbcccbdaa, k=3
  
  slow  0 1
        d d eee d bb ccc b
        1 2 123 3 12 123 3
        slow = 0
        slow = 1,2,3
        [1]
        */
    	Deque<Integer> stack = new ArrayDeque<>(); 
    	char[] arr = s.toCharArray(); 
    	int slow = 0, fast = 0; 
    	// [0, slow) result array
    	// [fast, arr.length) unprocessed
    	
    	while (fast < arr.length) {
    		if(!stack.isEmpty() && arr[fast] == arr[slow - 1]) {
    			int count = stack.pollFirst(); 
    			count = count + 1; 
    			if (count == k) {
    				slow = slow - k + 1; 
    			}
    			else {
    				arr[slow] = arr[fast]; 
    				slow++; 
    				stack.offerFirst(count); 
    			}
    		}
    		else {
    			arr[slow] = arr[fast]; 
    			slow++; 
    			stack.offerFirst(1); 
    		}
    		fast++; 
    	}
    	return new String(arr, 0, slow); 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
