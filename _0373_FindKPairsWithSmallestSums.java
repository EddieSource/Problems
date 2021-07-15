import java.util.*; 

public class _0373_FindKPairsWithSmallestSums {
		
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(); 
        // asumption: nums1.length, nums2.length >= 1
        
        
        PriorityQueue<List<Integer>> minHeap= new PriorityQueue<>(new Comparator<List<Integer>>(){
        	@Override
        	public int compare(List<Integer> one, List<Integer> two) {
        		int sumOfOne = nums1[one.get(0)] + nums2[one.get(1)]; 
        		int sumOfTwo = nums1[two.get(0)] + nums2[two.get(1)];
        		if(sumOfOne == sumOfTwo) return 0; 
        		return sumOfOne < sumOfTwo ? -1 : 1; 
        	}
        }); 
        
        Set<List<Integer>> generated = new HashSet<>(); 
        
        // initial state
        int p1 = 0, p2 = 0;
        int v1 = nums1[p1], v2 = nums2[p2]; 
        
        //generate ininitial pair
        List<Integer> root = new ArrayList<>(); 
        root.add(p1); 
        root.add(p2); 
        
        minHeap.add(root); 
        generated.add(root); 
        
        while(!minHeap.isEmpty()) {
        	List<Integer> node = minHeap.poll(); 
        	// expand node
        	
        	List<Integer> cur = new ArrayList<>(); 
        	cur.add(nums1[node.get(0)]); 
        	cur.add(nums2[node.get(1)]); 
        	res.add(cur); 
        	
        	k--; 
        	if(k == 0) return res; 
        	
        	// generate its neighbor
        	List<List<Integer>> neighbors = getNeighbor(node, nums1, nums2); 
        	for(List<Integer> nei: neighbors) {
        		if(generated.contains(nei)) continue; 
        		
        		minHeap.offer(nei); 
        		generated.add(nei); 
        	}
        	
        }
        
        // possibly k > 0
        return res; 
    }

	private List<List<Integer>> getNeighbor(List<Integer> node, int[] nums1, int[] nums2){
		List<List<Integer>> neighbors = new ArrayList<>(); 
		int p1 = node.get(0), p2 = node.get(1);  
	
		// move p1
		p1++; 
		if(p1 < nums1.length) {
			List<Integer> nei = new ArrayList<>(); 
			nei.add(p1); 
			nei.add(node.get(1)); 
			neighbors.add(nei); 
		}
		
		// move p2 
		p2++; 
		if(p2 < nums2.length) {
			List<Integer> nei = new ArrayList<>(); 
			nei.add(node.get(0));
			nei.add(p2); 
			neighbors.add(nei); 
		}
		
		return neighbors; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
