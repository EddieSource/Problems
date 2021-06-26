import java.util.*; 
public class _0126_WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // step from beginWord to the currentWord
	    List<List<String>> res = new ArrayList<>(); 
    	
		// O(n)
		Map<String, Integer> wordToStep = new HashMap<>();
		for(String word: wordList) {
			wordToStep.put(word, -1); //-1 means current word in the list is not yet been generated/visited
		}
		
		Map<String, List<String>> wordToPreds = new HashMap<>();
		for(String word: wordList) {
			wordToPreds.put(word, new ArrayList<>()); //empty String means current word in the list does not have a predecessor, not yet visited
		}
		
  
		 // BFS: 
		 Queue<String> q = new ArrayDeque<>(); 
		 q.offer(beginWord); // begin word is not in the wordlist
		 wordToStep.put(beginWord, 0); 
		 
		 wordToPreds.put(beginWord, new ArrayList<>()); 
		 
		 while(!q.isEmpty()) {
		 	// expand the current
		 	String word = q.poll(); 
		 	// step can not be null since every word in the queue is guranteed to be in the hashmap
		 	int step = wordToStep.get(word); 
		 	
		 	// generate
		 	StringBuilder wordModifier = new StringBuilder(word); 
		 	for(int i = 0; i < wordModifier.length(); i++) {
		 		char orig = word.charAt(i); 
		 		for(char j = 'a'; j <= 'z'; j++) {
		 			if(orig == j) continue; // original word just continue, don't do anything
		 			wordModifier.setCharAt(i, j);
		 			String neiWord = wordModifier.toString(); 
		 			if(wordToStep.containsKey(neiWord)) {
		 				// generate
		 				// deduplicate: if visited we don't generate
		 				if(wordToStep.get(neiWord) == -1) {
		     				q.offer(neiWord); 
		     				wordToStep.put(neiWord, step + 1); 
		     
		     				wordToPreds.get(neiWord).add(word); // map the neighbor word to its predecessor
		 				}
		 				else if(wordToStep.get(neiWord) == step + 1) {
		 					// no need to push
		 					wordToPreds.get(neiWord).add(word); 
		 				}
		 				
		 			}
		 		}
		 		// set state back
		 		wordModifier.setCharAt(i, orig);
		 	} 	
		 	
		 }
		 
		 
		 // if endWord is not in the given list or the endWord in the given list but never be visited return empty list
		if(wordToPreds.get(endWord) == null || wordToPreds.get(endWord).size() == 0) return res; 
		
		List<String> cur = new ArrayList<>(); 
		cur.add(endWord); 
		// else we start to find the path
		helper(endWord, wordToPreds, cur, res); 
		return res; 
//		 
//		Integer step = wordToStep.get(endWord); 
//		if(step == null) return 0; // if end word is not in the dict/list return 0
//		else return step + 1; // -1 will return 0(according to the problem assumption
	}
    
    public static void helper(String childWord, Map<String, List<String>> wordToPreds, List<String> cur, List<List<String>> res) {
    	if(wordToPreds.get(childWord).isEmpty()) {
    		List<String> cur_reverse = new ArrayList<>(cur); 
    		Collections.reverse(cur_reverse);
    		res.add(cur_reverse); 
    		return; 
    	}
    	for(String s: wordToPreds.get(childWord)) {
    		cur.add(s); 
    		helper(s, wordToPreds, cur, res); 
    		cur.remove(cur.size() - 1); 
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")); 
		
		System.out.println(findLadders("hit", "cog", l)); 

	}

}
