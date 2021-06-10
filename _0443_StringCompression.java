import java.util.*; 
public class _0443_StringCompression {
    public int compress(char[] chars) {
        int slow = 0, fast = 0; 
        // [0, slow): our res array; 
        // [fast, char.length) our original array
        boolean restart = true; 
        while(fast < chars.length) {
        	if(restart || chars[fast] != chars[slow - 1]) {
        		chars[slow] = chars[fast]; 
        		slow++; 
        		fast++; 
        		
        		restart = false; 
        	}
        	else {
        		int num = 1;	// because chars[fast] == char[slow - 1]
        		int cur = fast; 
        		// group lengths greater than 10 will be split into multiple characters
        		while(cur < chars.length && chars[cur] == chars[slow - 1]) {
        			num++; 
        			cur++; 
        		}
        		
        		int num_len = copyDigits(num, chars, slow); // returns 1 if num < 10
        		
        		slow += num_len; 
        		fast = cur; 
        		
        		restart = true;	// since the encoded number should not be considered as real number
        	}
        }
        return slow; 
    }
    
    public int copyDigits(int num, char[] chars, int slow) {
    	int num_len = 0; 
    	for(int i = num; i > 0; i /= 10) {
    		slow++;
    		num_len++; 
    	}
    	for(int i = num; i > 0; i /= 10) {
    		int digit = i % 10; 
    		slow--; 
    		chars[slow] = (char)('0' + digit); 
    	}
    	return num_len; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
