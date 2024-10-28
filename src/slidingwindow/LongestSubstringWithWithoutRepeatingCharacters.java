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
		int result = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (j < s.length()) {
			// add char at j to map
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

			if (map.size() == j - i + 1) {
				result = Math.max(result, j - i + 1);
				j++;
			} else {
				while (map.size() < j - i + 1) {
					// remove element at index i
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0) {
						map.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		return result;

	}
}