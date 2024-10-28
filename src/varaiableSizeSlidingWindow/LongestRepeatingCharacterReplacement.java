package varaiableSizeSlidingWindow;

import java.util.Map;
import java.util.HashMap;


public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "AABABBA"; int k = 1;
		int res = characterReplacement(s, k);
		System.out.println("result is: "+res);

	}

	private static int characterReplacement(String s, int k) {
		int i=0;
		int max = 0;
		int maxRepeatedLetterCount = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int j=0; j<s.length(); j++) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
			maxRepeatedLetterCount= Math.max(maxRepeatedLetterCount, map.get(s.charAt(j)));
			
			//calculate remaining char less then k i.e length - maxchar = remaini char
			//AABA - here length = 4, A=3 so (3-0+1) -3 = 1
			if(j - i +1 - maxRepeatedLetterCount > k) {
				// shift i to right and remove element of char at i
				map.put(s.charAt(i), map.get(s.charAt(i))-1);
				i++;
			}
			max = Math.max(max, j-i+1);
			
		}
		return max;
	}

	private static boolean isValid(String s, int i, int j, int k, Map<Character, Integer> map) {
		int length = j -i +1;
		int maxCount =0;
		for(Map.Entry<Character, Integer> charMap : map.entrySet()) {
			maxCount = Math.max(maxCount, charMap.getValue());
		}
		int rem = length - maxCount;
		return rem <= k;
	}

}
