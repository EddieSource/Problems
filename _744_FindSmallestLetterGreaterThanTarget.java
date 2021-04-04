
public class _744_FindSmallestLetterGreaterThanTarget {
	
    public static char nextGreatestLetter(char[] letters, char target) {
        //assumptions 2 < letters.length < 1000 : 
    	if(letters == null || letters.length == 0) return target; 
    	
    	int left = 0; 
    	int right = letters.length - 1; 
    	while(left < right - 1) {
    		//terminate case when left == right: check that only one
    		int mid = left + (right - left)/2; 
    		if(letters[mid] < target) {
    			left = mid + 1; 
    		}
    		else if(letters[mid] == target) {
    			left = mid + 1; 
    		}
    		else {
    			//letters[mid] > target
    			right = mid; 
    			
    		}
    	}
    	if(letters[left] > target) return letters[left]; 
    	if(letters[right] > target) return letters[right]; 
    	else return letters[0]; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] letters = {'c', 'f', 'j'}; 
		System.out.println(nextGreatestLetter(letters, 'a')); 

	}

}
