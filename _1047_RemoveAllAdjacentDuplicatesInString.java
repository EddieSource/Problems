import java.util.*; 
public class _1047_RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
    	// time complexity: O(n)
    	// space complextiy: O(1)
    	
        char[] arr = s.toCharArray(); 
        // fast: [fast, arr.length) is the unprocessed
        // slow: [0, slow) is the output
        int fast = 0, slow = 0; 
        
        while(fast < arr.length) {
        	if(slow > 0 && arr[fast] == arr[slow - 1]) {
        		slow--; 
        	}
        	else {
        		arr[slow] = arr[fast]; 
        		slow++; 
        	}
        	fast++; 
        }
        return new String(arr, 0, slow); 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates("azxxzy")); 
		
	}

}
