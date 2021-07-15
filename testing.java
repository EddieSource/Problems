import java.util.*; 
public class testing {
	public int kthSum(int[] A, int[] B, int k) {
	    // Write your solution here

	    // assumption K > 0 && K <= m * n
	    if(A == null || B == null) return -1; 

	    int a = 0, b = 0;  
	    while(a < A.length && b < B.length){
	      // a and b must be in the 
	      int sum = A[a] + B[b]; 
	      k--; 
	      if(k == 0) return sum; 

	      if(A[a] < B[b]) a++; 
	      else b++; 
	    }

	    while(a < A.length){
	      // A left
	      int sum = A[a] + B[B.length - 1]; 
	      k--; 
	      if(k == 0) return sum; 
	      a++; 
	    }
	    
	    while(b < B.length){
	      // B left
	      int sum = A[A.length - 1] + B[b]; 
	      k--; 
	      if(k == 0) return sum; 
	      b++; 
	    }

	    return -1; 
	    
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<List<Integer>, Boolean> a = new HashMap<>(); 
		
		List<Integer> b = new ArrayList<>(); 
		b.add(1); 
		b.add(2); 
		
		List<Integer> c = new ArrayList<>(); 
		c.add(1); 
		c.add(2); 
		a.put(b, true); 
		a.put(c, false); 
		
		List<Integer> d = new ArrayList<>(); 
		d.add(1); 
		d.add(2);
		
		System.out.println(a.get(b)); 
		System.out.println(a.containsKey(d)); 
		
	}

}
