import java.util.*; 
public class _0084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
    	// non-decreasing stack
       Deque<Integer> monostack = new ArrayDeque<>(); 
       // heights[monostack's element] is non-decreasing
       monostack.add(-1); 
       
       /*
        * max: 10
        * [1, 4, 5
        * 
        * 4
        */
       
       int max = 0; 
       
       for(int i = 0; i < heights.length; i++) {
    	   while(monostack.peekFirst() != -1 && heights[i] < heights[monostack.peekFirst()]) {
    		   int curHeight = heights[monostack.pollFirst()]; 
    		   int curWidth = i - monostack.peekFirst() - 1; 
    		   max = Math.max(curWidth * curHeight, max); 
    	   }
    	   monostack.offerFirst(i); 
       }
       
       while (monostack.peek() != -1) {
    	   int curHeight = heights[monostack.pollFirst()]; 
    	   int curWidth = heights.length - monostack.peekFirst() - 1; 
    	   max = Math.max(curHeight * curWidth, max); 
       }
       
       return max; 
       
       
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
