import java.util.*; 
public class _692_TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>(); 
        Map<String, Integer> mapWordToCount = new HashMap<>(); 
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(words.length, 
        		new Comparator<Map.Entry<String, Integer>>() {
        	@Override
        	public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        		if(e1.getValue() == e2.getValue()) {
        			return e1.getKey().compareTo(e2.getKey()); 
        		}
        		return e1.getValue() > e2.getValue() ? -1 : 1; 
        	}
        }); 
        
        //fill mapWordToCount
        for(String word : words) {
        	Integer count = mapWordToCount.get(word); 
        	if(count == null) {
        		mapWordToCount.put(word, 1);        		
        	}
        	else {
        		mapWordToCount.put(word, count + 1); 
        	}
        }
        
        // fill the minHEap
        for(Map.Entry<String, Integer> entry : mapWordToCount.entrySet()) {
        	maxHeap.offer(entry); 
        }
        for(int i = 0; i < k; i++) {
        	res.add(maxHeap.poll().getKey()); 
        }

        
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = new String[] {
				"i", "love", "leetcode", "i", "love", "coding"
		}; 
		
		System.out.println(topKFrequent(words, 2)); 
		
		

	}

}
