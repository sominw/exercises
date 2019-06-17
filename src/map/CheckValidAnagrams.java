package map;

import java.util.HashMap;
import java.util.Map;

public class CheckValidAnagrams {
	
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		
		Map<Character, Long> map1 = new HashMap<Character, Long>();
		Map<Character, Long> map2 = new HashMap<Character, Long>();
		
		for(char c: s.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0l) + 1l);
		}
		
		for (char c: t.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0l) + 1l);
		}
		
		for (char c: map1.keySet()) {
			if (!map2.containsKey(c) || (map2.get(c) != map1.get(c))) 
				return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s, t));

	}

}
