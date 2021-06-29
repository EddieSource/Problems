import java.util.*; 
public class _0004_ {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length; 
        int half = total / 2;
        
        int[] sh, lo; 
        if(nums1.length < nums2.length) {
        	sh = nums1; 
        	lo = nums2; 
        }
        else {
        	sh = nums2; 
        	lo = nums1; 
        }
        
        int shlen = sh.length; 
        int lolen = lo.length; 
        
        int low = 0, high = shlen; 
        
        while(low <= high) {
        	int cutsh = (low + high) / 2; 
        	int cutlo = (shlen + lolen + 1) / 2 - cutsh; 
        	
        	int shLeft = cutsh == 0 ? Integer.MIN_VALUE : sh[cutsh - 1]; 
        	int loLeft = cutlo == 0 ? Integer.MIN_VALUE : lo[cutlo - 1]; 
        	
        	int shRight = cutsh == shlen ? Integer.MAX_VALUE : sh[cutsh]; 
        	int loRight = cutlo == lolen ? Integer.MAX_VALUE : lo[cutlo]; 
        	
        	
        	if(shLeft <= loRight && loLeft <= shRight) {
        		// odd
        		if (total % 2 == 1) {
        			return (double)Math.max(shLeft, loLeft); 
        		}
        		// even
        		else {
        			// remember to divide by 2.0 can't by an integer and conver to double
        			return Math.max(shLeft, loLeft) + Math.min(shRight, loRight) / 2.0; 
        		}
        	}
        	
        	else if (shLeft > loRight) {
        		high = cutsh - 1; 
        	}
        	else {
        		low = cutsh + 1; 
        	}
        }
        return 0; 
       
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
