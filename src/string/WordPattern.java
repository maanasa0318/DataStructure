package string;

import java.util.Arrays;
import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {

		String pattern = "abba";
		String s = "dog dog dog dog";
		boolean res = wordPattern(pattern, s);
		System.out.println(res);
	}

	private static boolean wordPattern(String pattern, String s) {
		String[] s1 = s.split(" ");
		System.out.println(Arrays.toString(s1));
		if (pattern.length() != s1.length) {
			return false;
		} else {
			HashMap<Character, String> map = new HashMap<>();
			for(int i=0; i< pattern.length(); i++) {
				char ch = pattern.charAt(i);
				boolean key = map.containsKey(ch);
				if(!key && map.containsValue(s1[i])){
					return false;
				}
				
				if(key && !map.get(ch).equals(s1[i])) {
					return false;
				}
				
				else {
					map.put(ch, s1[i]);
				}
				
			}

		}

		return true;
	}

}
