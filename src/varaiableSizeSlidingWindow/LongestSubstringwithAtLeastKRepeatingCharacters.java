package varaiableSizeSlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	//https://www.youtube.com/watch?v=8hCBgTuynVw
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbaaaa";
		int totalChars = 3;
		int res = longestSubstringwithAtLeastKRepeatingCharacters(s, totalChars);
		System.out.println("Longest sub array is " + res);

	}

	/**
	 * Given a string s and an integer k, return the length of the longest substring
	 * of s such that the frequency of each character in this substring is greater
	 * than or equal to k. if no such substring exists, return 0.
	 * 
	 * @param s
	 * @param totalChars
	 * @return
	 */
	private static int longestSubstringwithAtLeastKRepeatingCharacters(String s, int k) {
		List<Character> problamaticLetter = new ArrayList<Character>();
		boolean valid = true;
		int j =0;
        Map<Character,Integer> map=new HashMap<>();

		while(j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) +1);
			j++;
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+":"+ entry.getValue());
			if(entry.getValue() < k) {
				problamaticLetter.add(entry.getKey());
				valid = false;
			}
		}
		System.out.println("Problmatic letters are:" +problamaticLetter);
		if (valid)
            return s.length();
		
		// split the string;
		for (Character c : problamaticLetter) {
			s = s.replace(c.toString(), " ");	
		}
		
		String[] words = s.split("\\s+"); 	
		int answer =0;
		for (String newString : words) {
			//remove added empty space
			System.out.println(newString.trim());
			answer = Math.max(answer, longestSubstringwithAtLeastKRepeatingCharacters(newString.trim(),k));
		}
		
		return answer;
		
	}

}
