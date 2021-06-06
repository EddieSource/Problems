
public class _0028_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        // assumption haystack.length >= 0
    	if(needle.length() == 0) return 0; 
    	if(needle.length() > haystack.length()) return -1; 
    	
    	//needle.length() > 1 && haystack.length > 1
    	for(int i = 0; i <= haystack.length() - needle.length(); i++) {
    		if(partialEqual(haystack, needle, i)) {
    			return i; 
    		}
    	}
    	
    	return -1; 
    }
    public boolean partialEqual(String haystack, String needle, int offset) {
    	for(int i = 0; i < needle.length(); i++) {
    		if(needle.charAt(i) != haystack.charAt(i + offset)) {
    			return false; 
    		}
    	}
    	return true; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
