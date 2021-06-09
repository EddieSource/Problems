import java.util.*; 

public class _0253_MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
        // assumption: intervals.length >=1 
	    Arrays.sort(intervals, new Comparator<int[]>() {
	    	@Override
	    	public int compare(int[] a, int[] b) {
	    		return a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0; 
	    	}
	    });
	    
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length); 
	    
	    // initial state
	    minHeap.add(intervals[0][1]); 
	    
	    for(int i = 1; i < intervals.length; i++) {
	    	
	    	//if the room freed up the earliest is free, assign
	    	if(intervals[i][0] >= minHeap.peek()) {
	    		minHeap.poll(); 
	    	}
	    	minHeap.add(intervals[i][1]); 
	    }
	    return minHeap.size(); 
	   
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}
