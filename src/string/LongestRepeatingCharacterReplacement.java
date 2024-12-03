package string;

import java.util.Collections;
import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {

		String s = "AABABBA";
		int k = 1;
		int res = lengLongRepChar(s, k);
		System.out.println(res);
		
		int res1 =characterReplacement(s,k);
		System.out.println(res1);
	}

	private static int lengLongRepChar(String s, int k) {
		int left = 0;
		int result = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxf = 0;
		
        for (int right = 0; right < s.length(); right++) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) +1);
            maxf = Math.max(maxf, map.get(s.charAt(right)));
            
            while((right - left + 1)- maxf > k) {
    			map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) -1);
    			left++;
            }
            result = Math.max(result, right - left +1);

		}
		return result;
	}
	
	private static int  characterReplacement(String s, int k) {
	        HashMap<Character, Integer> count = new HashMap<>();
	        int res = 0;

	        int l = 0, maxf = 0;
	        for (int r = 0; r < s.length(); r++) {
	            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
	            maxf = Math.max(maxf, count.get(s.charAt(r)));

	            while ((r - l + 1) - maxf > k) {
	                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
	                l++;
	            }
	            res = Math.max(res, r - l + 1);
	        }

	        return res;
	 }

}
