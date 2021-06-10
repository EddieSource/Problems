import java.util.*; 
public class _0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> in = new HashSet<>(); 
        int slow = 0, fast = 0, max = 0; 
        // [slow, fast) is the substring; fast - slow = length
        while(fast < s.length()) {
        	if(in.contains(s.charAt(fast))) {
        		in.remove(s.charAt(slow)); 
        		slow++;
        	}
        	else {
        		in.add(s.charAt(fast)); 
        		fast++;
        		max = Math.max(fast - slow, max); 
        	}
        }
        return max; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
