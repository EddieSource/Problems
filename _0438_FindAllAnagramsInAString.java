import java.util.*; 

public class _0438_FindAllAnagramsInAString {
    public boolean match(HashMap<Character, Integer> map){
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0) return false; 
        }
        return true; 
    }
    public List<Integer> findAnagrams(String s, String p) {
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
        
        List<Integer> res = new ArrayList<>(); 
        if(p.length() > s.length()) return res; 
        
        int left = 0, right = 0 + p.length(); 
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i = 0; i < p.length(); i++){
            Integer freq = map.get(p.charAt(i)); 
            if(freq == null) map.put(p.charAt(i), 1); 
            else map.put(p.charAt(i), freq + 1); 
        }
        
        // initial state, beginning window
        for(int i = left; i < right; i++){
            Character ch = s.charAt(i); 
            Integer freq = map.get(ch);
            
            if(freq != null) map.put(ch, freq - 1); 
        }
        
        // compare
        if(match(map)){
            res.add(left); 
        }
        
        // start traversing
        while(right < s.length()){
            Character ch = s.charAt(right); 
            Integer freq = map.get(ch);
            if(freq != null) map.put(ch, freq - 1); 
            right++; 
            
            ch = s.charAt(left); 
            freq = map.get(ch); 
            if(freq != null) map.put(ch, freq + 1); 
            left++; 
            
            if(match(map)) res.add(left); 
        }
        
        
        return res; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
