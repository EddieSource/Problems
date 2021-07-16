import java.util.*; 
public class _0217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>(); 
        for(int i = 0; i < nums.length; i++){
          if(s.contains(nums[i])) return true; 
          s.add(nums[i]); 
        }
        return false; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
