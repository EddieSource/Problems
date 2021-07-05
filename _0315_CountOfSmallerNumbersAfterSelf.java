import java.util.*; 
public class _0315_CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
    	/*
    	 * 
    	 */
    	int n = nums.length; 
    	int[] result = new int[n]; 
    	int[] indices = new int[n]; 
    	
    	// record the index, sort the index
    	for(int i = 0; i < n; i++) {
    		indices[i] = i; 
    	}
        
    	// sort indices with(according to) their corresponding values in nums
    	mergeSort(indices, 0, n, result, nums); 
    	
    	// post-processing
    	List<Integer> resultToReturn = new ArrayList<>(); 
    	for(int i : result) {
    		resultToReturn.add(i); 
    	}
    	return resultToReturn; 
    }
    
    private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
    	// right is not inclusive
    	if(left >= right - 1) return; 
    	int mid = (left + right) / 2; 
    	mergeSort(indices, left, mid, result, nums); 
    	mergeSort(indices, mid, right, result, nums); 
    	merge(indices, left, right, mid, result, nums); 
    }
    
    private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
    	// merge [left, mid) and [mid, right)
    	int i = left; // current start index for the left array
    	int j = mid; // current start index for the right array
    	
    	// use temp to temporarily store sorted array
    	List<Integer> temp = new ArrayList<Integer>(); 
    	while (i < mid && j < right) {
    		if(nums[indices[i]] <= nums[indices[j]]) {
    			// j - mid numbers jump to the left side of indices[i]
    			result[indices[i]] += j - mid; 
    			temp.add(indices[i]); 
    			i++; 
    		}
    		else {
    			temp.add(indices[j]); 
    			j++; 
    		}
    	}
    	
    	while(i < mid) {
    		result[indices[i]] += j - mid; 
    		temp.add(indices[i]); 
    		i++; 
    	}
    	
    	// probabily the current length is odd
    	while (j < right) {
    		temp.add(indices[j]); 
    		j++; 
    	}
    	
    	// restore from temp
    	for(int k = left; k < right; k++) {
    		indices[k] = temp.get(k - left); 
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
