import java.util.*; 
public class _0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        Arrays.sort(nums); 
        for(int i = 0; i < nums.length - 2; i++) {
          if(i > 0 && nums[i] == nums[i - 1]){
            continue; //deduplicate
          }
          int left = i + 1; 
          int right = nums.length; 
          while(left < right - 1){
            int tmp = nums[left] + nums[right - 1]; 
            
            if (tmp + nums[i] == 0){
              result.add(Arrays.asList(nums[i], nums[left], nums[right - 1])); 
              left++; 
              while(left < right - 1 && nums[left] == nums[left - 1]) {
                left++; 
              } 
            }

            else if(tmp + nums[i] < 0){
                left++; 
            } 
      
            else{
                right--; 
            }
          }
        }
        return result; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
