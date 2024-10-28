package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter {

	public static void main(String[] args) {

		String s = "leetcode";
		int index = firstUniqChar(s) ;
		System.out.println(index);
	}

	private static int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1 );
			}
			else {
				map.put(s.charAt(i),1 );
			}
		}
		
		System.out.println(map);
		return 0;
	}

}
