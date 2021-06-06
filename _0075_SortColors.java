
public class _0075_SortColors {
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i]; 
		nums[i] = nums[j]; 
		nums[j] = temp; 
		return; 
	}
	private static void sortColors2(int[] nums) {
		//0,1,2,3 stands for colors: need i, j, k to be walls
		//[0, i)-> 0; [i, j) -> 1, [j, k)->2, [k,t] unknown, [t, nums.length - 1] -> 3
		int i = 0, j = 0, k = 0, t = nums.length - 1; 
		
		while(k <= t) {
			if(nums[k] == 0) {
				swap(nums, k, j); 
				k++; 
				swap(nums, j, i);
				j++;  
				i++; 
				 
			}
			else if(nums[k] == 1) {
				swap(nums, k, j); 
				k++; 
				j++; 
			}
			else if (nums[k] == 2) {
				k++; 
			}
			else {
				swap(nums, k, t); 
				t--; 
			}
		}
	}
	private static void sortColors(int[] nums) {
		//0,1,2 stands for colors: need i, j, k to be walls
		//[0, i)-> 0; [i, j) -> 1, [j, k] unknown, [k, nums.length - 1] -> 2
		int i = 0, j = 0, k = nums.length - 1; 
		
		while(j <= k) {
			if(nums[j] == 0) {
				swap(nums, j, i); 
				i++; 
				j++; 
			}
			else if(nums[j] == 1) {
				j++; 
			}
			else {
				swap(nums, j, k); 
				k--; 
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,1,2,0,1,2}; 
		sortColors2(nums); 
		System.out.println(nums); 
		
		

	}

}
