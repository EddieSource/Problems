
public class _0081_SearchInRotatedSortedArray {
	  public int firstOccurrence(int[] array, int target, int left, int right){
	        if(left > right){
	          return -1; 
	        }
	        if(left == right){
	          return array[left] == target ? left: -1; 
	        }

	        //length >= 2
			    while(left < right - 1){
			      int mid = left + (right - left) / 2; 
			      if(target < array[mid]) right = mid; 
			      else if(target > array[mid]) left = mid; 
			      // equal we search the first half of array
			      else right = mid; 
			    }

			    // find first occurrence of a number
			    if(array[left] == target) return left; 
			    if(array[right] == target) return right; 
			    else return -1; 
			  }

	  public int findPivot(int[] array, int left, int right){
	    // pivot must exist
	    // terminate condition of while loop could be [array[pivot]] left < right
	    // or [array[larger], array[pivot]] left < right - 1
	    // or [array[pivot], array[larger]] left < right - 1
	    // 2 2 3 2
	    while(left < right - 1){
	      int mid = left + (right - left) / 2; // could be equal left
	      if(array[mid] > array[right]){
	        // since array[mid] is the larger so it can not be pivot
	        left = mid + 1; 
	      }
	      else if(array[mid] < array[right]){
	        right = mid; 
	      }
	      // duplicate
	      else {
        // array[mid] == array[right]
	        // since mid can not be equal to right
	        // we rule out the right, and the mid position will also decrease

	        if(array[right] == array[right - 1]) right--; 
        // if right could possibly be an answer we move left
        else left++; 
	      }
	    }

	    if(array[left] <= array[right]){
	      return left; 
	    }
	    else return right; 

	  }
			  
	  public boolean search(int[] array, int target) {
	    // Write your solution here

	    // corner case
	    if(array == null || array.length == 0) return false; 

	    int left = 0, right = array.length - 1; 
	    
	    // the array is not rotated
	    if(array[left] < array[right]) return firstOccurrence(array, target, 0, array.length -1) == -1 ? false : true; 
	    //if(array[left] == array[right]) possible to be rotated

	    // first find the pivot where array[pivot - 1] > array[pivot]
	    // pivot - 1 will not be <0 since our array[left] > array[right] there must be a pivot != 0
	    int pivot = findPivot(array, 0, array.length - 1); 

	    // binary search in [0, pivot - 1]
	    // binary search in [pivot, array.length - 1]
	    int found = firstOccurrence(array, target, 0, pivot - 1); 
	    if (found == -1) found = firstOccurrence(array, target, pivot, array.length - 1); 
	    
	    return found == -1 ? false: true; 

	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
