
public class _0509_FibonacciNumber {
    public int fib(int n) {
    	// O(n)
    	if(n == 0) return 0; 
    	if(n == 1) return 1; 
    	
    	int[] m = new int[n + 1]; 
    	m[0] = 0;
    	m[1] = 1; 
    	for(int i = 2; i < n + 1; i++) {
    		m[i] = m[i - 1] + m[i - 2]; 
    	}
    	return m[n]; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
