
public class _0344_ReverseString {
    public void reverseString(char[] s) {
        // assumption: s.length > 0
    	int left = 0, right = s.length - 1; 
    	while(left < right) {
    		char temp = s[left]; 
    		s[left] = s[right]; 
    		s[right] = temp; 
    		left++; 
    		right--; 
    	}
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
