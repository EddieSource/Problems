import java.util.*; 
public class _0658_FindKClosestElements {
	public int findClosestElement(int[] arr, int x) {
		
        int left = 0, right = arr.length - 1; 
        while(left < right - 1) {
        	// 2 elements left after while loop: terminate condition: left = right - 1; 
        	int mid = left + (right - left) / 2; 
        	if(x == arr[mid]) {
        		return mid; 
        	}
        	else if(x < arr[mid]) {
        		right = mid; 
        	}
        	else {
        		left = mid; 
        	}
        }
        if(Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) return left; 
        else return right; 
	}
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	// 1 2 3 4 5
    	// L   M   R
        if(arr.length == 0 || k > arr.length) return new ArrayList<>(); 
        int pos = findClosestElement(arr, x); 
        List<Integer> res = new ArrayList<>(); 

        k--; 
        
        int left = pos - 1, right = pos + 1; 
        // left: [0, pos), right: [pos + 1, arr.length); 
        while(k > 0) {
        	if(left >= 0 && right < arr.length) {
        		if(Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {

        			k--; 
        			left--; 
        		}
        		else {

        			k--; 
        			right++; 
        		}
        	}
        	else if(left >= 0) {

    			k--; 
    			left--; 
        	}
        	else {
        		// right <= arr.length

    			k--; 
    			right++; 
        	}
        }
        for(int i = left + 1; i < right; i++) {
        	res.add(arr[i]); 
        }
        
        
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
