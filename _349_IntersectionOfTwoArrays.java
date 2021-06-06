import java.util.*; 
public class _349_IntersectionOfTwoArrays {
	public int[] intersection_helper(HashMap<Integer, Integer> smallMap, int[] smallNums, int[] largeNums) {
		int[] res = new int[smallNums.length]; 
		int index = 0; 
		for(int smallNum: smallNums) {
			smallMap.put(smallNum, 1); 
		}
		for(int largeNum: largeNums) {
			Integer count = smallMap.get(largeNum); 
			if(count != null && count == 1) {
				smallMap.put(largeNum, count + 1); 
				res[index] = largeNum; 
				index++; 
			}
		}
		return Arrays.copyOf(res, index); 
	}
    public int[] intersection(int[] nums1, int[] nums2) {
    	//assumption: the smaller nums' length is greater than 0; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        return nums1.length <= nums2.length ? intersection_helper(map, nums1, nums2): intersection_helper(map, nums2, nums1); 
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
