import java.util.*; 
public class _0139_WordBreak {
	public Set<String> getWordSet(List<String> wordDict){
		Set<String> set = new HashSet<String>(); 
		for(String s: wordDict) {
			set.add(s); 
		}
		return set; 
	}
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = getWordSet(wordDict); 
        //m[i] means if substring [0, i) can be divided to words from dict
        boolean[] m = new boolean[s.length() + 1]; 
        m[0] = true; //[0,0) is empty string which is always true
        for(int i = 1; i < s.length() + 1; i++) { // grow the array
        	boolean canBreak = false; 
        	for(int j = 0; j < i; j++) {	// operation in the current array
        		// each breaking method
        		boolean eachcanBreak = m[j] && set.contains(s.substring(j, i)); 
        		canBreak |= eachcanBreak; 
        	}
        	m[i] = canBreak; 
        }
        return m[s.length()]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
