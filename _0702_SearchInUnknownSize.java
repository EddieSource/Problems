import java.util.*; 
public class _0702_SearchInUnknownSize {
	public class ArrayReader{
		public int get(int index) {
			return 0; // don't speculate implementation of this method
		}
	}
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == Integer.MAX_VALUE) return -1; 
        
        
        // *2
        int left = 0, right = 1; 
        while(reader.get(right) != Integer.MAX_VALUE){
        	right = right * 10;
        	// right = right * 2; 
        }
        
        // search for the range
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            
            if(reader.get(mid) == Integer.MAX_VALUE){
                right = mid; 
            } 
            else {
                left = mid; 
            }
        }
        
        int lastIndex; 
        if(reader.get(right) != Integer.MAX_VALUE) lastIndex = right; 
        else lastIndex = left; 
        
        // run classical binary search
        int start = 0, end = lastIndex; 
        while(start <= end) {
        	int mid = start + (end - start) / 2; 
        	if(target == reader.get(mid)) {
        		return mid; 
        	}
        	else if(target > reader.get(mid)) {
        		start = mid + 1; 
        	}
        	else {
        		end = mid - 1; 
        	}
        }
        return -1; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
