import java.util.*;

public class _0254_FactorCombinations {
	public static void helper(List<Integer> increasingFactors, int index, int num, List<Integer> cur, List<List<Integer>> res ) {
		if(index == increasingFactors.size()) {
			if(num == 1) {
				res.add(new ArrayList<>(cur)); 
			}
			return; 
		}
		if(num == 1) {
			res.add(new ArrayList<>(cur)); 
			return; 
		}
		
		// 0 current factor
		helper(increasingFactors, index + 1, num, cur, res); 
		
		int factor = increasingFactors.get(index); 
		// loop all possible combinations of the current factor
		
		int howMany = 0; 
		// from 1 to log_factor(n) current factor
		while(num % factor == 0) {
			cur.add(factor);
			howMany++; 
			num /= factor; 
			helper(increasingFactors, index + 1, num, cur, res); 
		}
		
		for(int i = 0; i < howMany; i++) {
			cur.remove(cur.size() - 1); 
		}
		
		
		
	}
    public List<List<Integer>> getFactors(int n) {
        // find all the factors
    	List<Integer> increasingFactors = new ArrayList<>(); 
    	List<List<Integer>> res = new ArrayList<>(); 
    	for(int i = n / 2; i > 1; i--) {
    		if(n % i == 0) increasingFactors.add(i); 
    	}
    	
    	if(increasingFactors.size() == 0) return res; 
    	List<Integer> cur = new ArrayList<>(); 
    	helper(increasingFactors, 0, n, cur, res); 
    	return res; 
    	
    	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_0254_FactorCombinations a = new _0254_FactorCombinations(); 
//		a.getFactors(12); 

    	System.out.println(a.getFactors(12)); 
	}

}
