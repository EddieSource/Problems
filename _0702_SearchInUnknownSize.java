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
        while(reader.get(right) < target){
            right = right * 10; 
        }
        
        // search for the range
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(reader.get(mid) != Integer.MAX_VALUE && reader.get(mid) == target) return mid; 
            else if(reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target){
                right = mid - 1; 
            } 
            else {
                left = mid + 1; 
            }
        }
        return -1; 
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
