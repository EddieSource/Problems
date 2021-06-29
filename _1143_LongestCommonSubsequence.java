import java.util.*; 
public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
    	if(text1.length() == 0 || text2.length() == 0) return 0; 
    	int[][] m = new int[text1.length() + 1][text2.length() + 1]; 
    	// m[i][j] means the longest common subsequence of [0, i) text1 and [0, j) text2
    	for (int i = 0; i <= text1.length(); i++) {
    		for (int j = 0; j <= text2.length(); j++) {
    			if(i == 0 || j == 0) m[i][j] = 0; 
    			else if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
    				m[i][j] = 1 + m[i - 1][j - 1]; 
    			}
    			else {
    				// see if new added char at text1 and original text2 will update subsequence
    				// see if new added chat at text2 and original text1 will update subsequence
    				// select the one that will update subsequence(or neither does)
    				m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]); 
    			}
    		}
    	}
    	
    	return m[text1.length()][text2.length()]; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
