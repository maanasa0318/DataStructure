package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Variable Size Sliding Window
 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters. 
 * If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters.*/
public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int totalChars = 3;
		int res = findLargestSubArrayOfUniqueChars(s, totalChars);
		System.out.println("Longest sub array is " + res);
	}
	
	public static int longestkSubstr(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int j=0;
        int i=0;
        int max=-1;
        
        while (j < s.length()) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() == k) {
                max = Math.max(max, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return max;
    }

	private static int findLargestSubArrayOfUniqueChars(String s, int k) {
		int i = 0;
		int j = 0;
		HashMap<Character, Integer> mymap = new HashMap<>();
		int count = 1;
		int max = Integer.MIN_VALUE;

		while (j < s.length()) {
			// condition add chart to map
			if (!mymap.containsKey(s.charAt(j))) {
				mymap.put(s.charAt(j), 1);
			} else {
				mymap.put(s.charAt(j), ++count);
			}

			if (mymap.size() < k) {
				j++;
			} else if (mymap.size() == k) {
	            max = Math.max(max, j - i + 1);
				j++;
			} else if (mymap.size() > k) {
				while (mymap.size() > k) {
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
	

}
