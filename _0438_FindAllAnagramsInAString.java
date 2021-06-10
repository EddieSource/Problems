import java.util.*; 

public class _0438_FindAllAnagramsInAString {
    public boolean match(HashMap<Character, Integer> map){
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0) return false; 
        }
        return true; 
    }
    public List<Integer> findAnagrams(String lo, String sh) {
    // Write your solution here
    // return all the starting indices
        /**
        s, p
        cbaebabacd, abc
        
        p.length > s.length return []
        
        p.length <= s.length
        
        left = 0
        right = 0 + p.length
        
        anagram will lie in [left, right)
        when traversing: add left and right simultaneously
        
        String p -> MapCharToFreq: thats gonna be our initial map
        
        s = 'cbaebabacd', p='abc' map{c:1, a:1, b:1}
                   ^  ^
        currently {c:0, a:0, b:0}: anagaram, add the left -> [0, 6]    
        
        */

    List<Integer> result = new ArrayList<>(); 
    if (lo.length() == 0) return result; 
    if (sh.length() > lo.length()) return result; 
    Map<Character,Integer> map = countMap(sh); 

    // when match = map.size(), we find an anagram
    // match is the number of matched anagram
    int match = 0;

    for(int i = 0; i < lo.length(); i++){
      char tmp = lo.charAt(i); 
      Integer count = map.get(tmp); 

      //processing the right
      if(count != null){
        map.put(tmp, count - 1); 

        // if the count becomes 0 after processing, we fond a matching letter
        if(count - 1 == 0){
          match++; 
        }
      }

      // processing the left
      if(i >= sh.length()){
        tmp = lo.charAt(i - sh.length()); 
        count = map.get(tmp); 
        if(count != null){
          map.put(tmp, count + 1); 
          // if the count is 0 before the processing, we miss a matching number
          if(count == 0){
            match--; 
          }
        }
      }

      //for the current
      if(match == map.size()){
        result.add(i - sh.length() + 1); 
      }
    }
    return result; 

  }

   public Map<Character, Integer> countMap(String sh){
    Map<Character, Integer> res = new HashMap<>(); 

    for(char elem : sh.toCharArray()){
      Integer count = res.get(elem); 
      if(count == null){
        res.put(elem, 1); 
      }
      else{
        res.put(elem, count + 1); 
      }
    }

    return res; 
  }
  
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
