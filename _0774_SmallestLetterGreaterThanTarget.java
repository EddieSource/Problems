import java.util.*; 
public class _0774_SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        // if(letters.length == 0) return ' '; 
        // assumption letters.length >= 2
    	
        int left = 0, right = letters.length - 1; 
        
        
        // smallest letter larger than target
        while(left < right - 1) {
        	int mid = left + (right - left) / 2; 
        	if(target == letters[mid]) {
        		left = mid; 
        	}
        	else if(target < letters[mid]) {
        		right = mid; 
        	}
        	else {
        		// target > letter[mid]
        		left = mid; 
        	}
        }
        
        if(letters[left] > target) return letters[left]; 
        if(letters[right] > target) return letters[right]; 
        return letters[0]; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
