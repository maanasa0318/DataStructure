package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Variable Size Sliding Window
/*Given a string s, find the length of the longest substring without repeating characters.


Example:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
*/
public class LongestSubstringWithWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "pwwkew";
		int res = findLargestSubArrayOfUniqueChars(s);
		System.out.println("Longest sub array Without Repeating Characters is " + res);
	}



	private static int findLargestSubArrayOfUniqueChars(String s) {
		int i = 0;
		int j = 0;
		HashMap<Character, Integer> mymap = new HashMap<>();
		int max = Integer.MIN_VALUE;

		while (j < s.length()) {
			// condition add chart to map
			mymap.put(s.charAt(j), mymap.getOrDefault(s.charAt(j), 0) + 1);

			if (mymap.size() == j - i + 1) {
				max = Math.max(max, j - i + 1);
				j++;
			} else {
				while (mymap.size() < j - i + 1) {
					// remove s.char(i) in map
					mymap.put(s.charAt(i), mymap.get(s.charAt(i)) - 1);
					if (mymap.get(s.charAt(i)) == 0)
						mymap.remove(s.charAt(i));
					i++;
				}
				j++;
			}
		}
		return max;
	}
	
	public static int findLongestSubstring(String s) {
		int windowStart = 0, windowEnd = 0, maxLength = Integer.MIN_VALUE;
		Map<Character, Integer> frequencyMap = new HashMap<>();

		while (windowEnd < s.length()) {
			char rightChar = s.charAt(windowEnd);
			frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

			if (frequencyMap.size() == windowEnd - windowStart + 1) {
				maxLength = Math.max(maxLength, (windowEnd - windowStart + 1));
				windowEnd++;
			} else {
				while (frequencyMap.size() < windowEnd - windowStart + 1) {
					char leftChar = s.charAt(windowStart);
					frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);

					if (frequencyMap.get(leftChar) == 0) {
						frequencyMap.remove(leftChar);
					}
					windowStart++;
				}
			}
		}
		return maxLength;
	}

}