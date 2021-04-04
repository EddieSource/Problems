
public class _075_SortColors {
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i]; 
		nums[i] = nums[j]; 
		nums[j] = temp; 
		return; 
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
		int[] nums = {2,0,2,1,1,0}; 
		sortColors(nums); 
		System.out.println(nums); 
		
		

	}

}
