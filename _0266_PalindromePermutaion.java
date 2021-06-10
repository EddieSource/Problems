import java.util.*; 
public class _0266_PalindromePermutaion {
    public boolean canPermutePalindrome(String s) {
    	// first see the pattern of the palindrome, or string; this problem does not need DFS or any permutations
        // assumptions
        HashSet<Character> set = new HashSet<>(); 
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i)); 
            }
            else {
                set.add(s.charAt(i)); 
            }
        }
        return set.size() <= 1; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
