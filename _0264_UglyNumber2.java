import java.util.*; 

public class _0264_UglyNumber2 {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>(); 
        // pq.peek() returns the current smallest ugly number ready for expand
        // expand include 2, 3, 5
        // no need visited: they won't be equal, and it's one direction graph
        
        // initial state
        int count = 0; 
        long rootSmallest = 1; 
        pq.offer(rootSmallest); 
//        count++; 
//        
//        if(count == n) {
//        	return rootSmallest; 
//        }
        
        Set<Long> generated = new HashSet<>(); 
        
        while(!pq.isEmpty()) {
        	// expand
        	Long curUglyNum = pq.poll(); 
        	generated.remove(curUglyNum); 
        	count++; 
        	if(count == n) return curUglyNum.intValue(); // find it
        	
        	// generate
        	if(!generated.contains(curUglyNum * 2)) {
        		pq.offer(curUglyNum * 2);
        		generated.add(curUglyNum * 2); 
        	}
        	if(!generated.contains(curUglyNum * 3)) {
        		pq.offer(curUglyNum * 3);
        		generated.add(curUglyNum * 3); 
        	}
        	if(!generated.contains(curUglyNum * 5)) {
        		pq.offer(curUglyNum * 5);
        		generated.add(curUglyNum * 5); 
        	}
        	
        }
        
        // keep compiler happy
        return -1; 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(10)); 
	}

}
