import java.util.*; 
public class _0127_WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // step from beginWord to the currentWord
	    	
		// O(n)
		Map<String, Integer> wordToStep = new HashMap<>();
		for(String word: wordList) {
			wordToStep.put(word, -1); //-1 means current word in the list is not yet been generated/visited
		}
 
		 
		 // BFS: 
		 Queue<String> q = new ArrayDeque<>(); 
		 q.offer(beginWord); // begin word is not in the wordlist
		 wordToStep.put(beginWord, 0); 
		 
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
		 				}
		 			}
		 		}
		 		// set state back
		 		wordModifier.setCharAt(i, orig);
		 	} 	
		 	
		 }
 
		Integer step = wordToStep.get(endWord); 
		if(step == null) return 0; // if end word is not in the dict/list return 0
		else return step + 1; // -1 will return 0(according to the problem assumption
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")); 
		
		System.out.println(ladderLength("hit", "cog", l)); 

	}

}
