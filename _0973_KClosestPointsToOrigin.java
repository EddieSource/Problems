import java.util.*; 
public class _0973_KClosestPointsToOrigin {
	public class PointsComparator implements Comparator<int[]> {
		@Override
        public int compare(int[] cur, int[] other) {
            if(Math.sqrt((cur[0] * cur[0] + cur[1] * cur[1])) == Math.sqrt(other[0] * other[0] + other[1] * other[1])) return 0; 
            return Math.sqrt((cur[0] * cur[0] + cur[1] * cur[1])) > Math.sqrt(other[0] * other[0] + other[1] * other[1]) ? -1 : 1; 
        }
		
	}
    public int[][] kClosest(int[][] points, int k) {
        /*
         * several points: [[1,3],[-2,2]], k
         * return an array of points[[],[],[]]
         * 
         * initial state of a priorityqueue; of a visited/generated map/set
         * map: points to distance
         * 
         * pq: top of pq will be the cur closest point; map 
         * 
         * while pq is not empty: 
         * expand the current closest point: 
         * - get the distance from the map points to distance
         * - 
         */
    	int[][] res = new int[k][2]; 
    	
    	PointsComparator c = new PointsComparator(); 
    	
    	PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, c); 
    	
    	// if the current input point is smallest than the max point, pop max point insert the smaller point
    	// so the top after all will be the kth smallest
    	int count = 0; 
    	
    	for(int[] point: points) {
    		if(count < k) {
    			maxHeap.offer(point); 
    			count++;
    			continue; 
    		}
    		if(c.compare(point, maxHeap.peek()) > 0) {
    			maxHeap.poll(); 
    			maxHeap.offer(point); 
    		}
    	}
    	
    	for(int i = 0; i < res.length; i++) {
    		int[] point = maxHeap.poll(); 
    		res[i][0] = point[0]; 
    		res[i][1] = point[1]; 
    	}
    	
    	return res; 
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
