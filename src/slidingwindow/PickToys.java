package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Variable size 
 * Problem Description: No Where, it was an interview problem

John is at a toy store help him pick maximum number of toys. He can only select in a continuous manner and he can select only two types of toys.


Example:
Input:
1
abaccab
o/p - acca*/

public class PickToys {

	public static void main(String[] args) {
		String s = "abaccab";
		int totalChars = 2;
		int res = findLargestSubArrayOfUniqueChars(s, totalChars);
		System.out.println("Longest sub array is " + res);
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