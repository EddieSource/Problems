
public class _0151_reverseWordsInAString {
	public static int removeSpaces(char[] arr) {
		int slow = 0, fast = 0; 
		//[0, slow) processed array
		//[fast, arr.length) unknown array
		
		while(fast < arr.length) {
			// when not add: no duplicated ' ' or no leading ' '
			if(arr[fast] == ' ' && (slow == 0 || arr[slow - 1] == ' ')) {
				fast++; 
			}
			else {
				arr[slow] = arr[fast]; 
				slow++; 
				fast++; 
			}
		}
		// need to deal with that no trailing ' '
		if(arr[slow - 1] == ' ') slow--; 
		return slow; 
	}
    public static void reverseString(char[] s, int left, int right) {
        // assumption: s.length > 0
    	while(left < right) {
    		char temp = s[left]; 
    		s[left] = s[right]; 
    		s[right] = temp; 
    		left++; 
    		right--; 
    	}
    }
    
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray(); 
        int end = removeSpaces(arr); 
        //[0, end) is the desired string
        int slow = 0, fast = 0; 
        while(fast <= end) {
        	// fast - 1 >= 0 because ' ' is not at beginning or end
        	// don't forget that the last word is not ended with ' ' but also need to reverse
        	if(fast == end || arr[fast] == ' ') {
        		reverseString(arr, slow, fast - 1); 
        		slow = fast + 1; 
        		fast = fast + 1; 
        	}
        	else {
        		fast++; 
        	}
        }
        reverseString(arr, 0, end - 1); 
        return new String(arr, 0, end);  
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a good   example"; 
		System.out.println(reverseWords(s)); 

	}

}
