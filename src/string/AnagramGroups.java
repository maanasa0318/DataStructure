package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramGroups {

	public static void main(String[] args) {

		String [] strs = {"act","pots","tops","cat","stop","hat"};
		//Time complexity: 
		//O(m∗n) Where m is the number of strings and n is the length of the longest string.
		//Space complexity: 
		//O(m)
		List<List<String>>  res = groupAnagrams(strs);

		System.out.println(res);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		
		for(String s : strs) {
			char[] ch = s.toCharArray();
			int[] freqCount = new int[26];
			for(char c : ch) {
				freqCount[c - 'a']++;
			}
			
			String key = Arrays.toString(freqCount);
			map.putIfAbsent(key, new ArrayList<String>());
			map.get(key).add(s);
			
		}
		return new ArrayList<>(map.values());
	}

}
