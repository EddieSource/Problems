
public class testing {
	public static int numIncreasingSubsequences(int[] a) {
	    // Write your solution here
	    if (a.length == 0) return 0; 
	    int[] m = new int[a.length]; 
	    // m[i] represents the count of ascending subsequence ending at i
	    
	    m[0] = 1; 
	    
	    // initial status
	    
	    int count = 1; 

	    for (int i = 1; i < a.length; i++) {
	      for (int j = 0; j < i; j++) {
	    	// letter itself is an ascending array
	    	m[i] = 1; 
	        if (a[i] > a[j]) {// ascending
	          m[i] = m[i] + m[j]; 
	        } 
	        
	        // if not we don't do anything just reset max SubLength
	        count += m[i]; 
	      }
	    }

	    return count; 
	  
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numIncreasingSubsequences(new int[] {1,2,3})); 
	}

}
