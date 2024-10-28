package varaiableSizeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bcbbbcba";
		//int result = maximumLengthSubstring(s);
		//System.out.println(result);
		int result1 = anotherApproach(s);
		System.out.println(result1);

	}

	private static int anotherApproach(String s) {
		int i=0;
		int j=0;
		int maxLength=0;
		Map<Character, Integer> map = new HashMap<>();
		//"bcbbbcba";

		while(j <s.length()) {
			if(map.containsKey(s.charAt(j))) {
				if(map.get(s.charAt(j)) <= 2) {
					map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
				}else {
					//no need to put move i++;
					map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
					i++;
				}
			}
			else {
				map.put(s.charAt(j), 1);
			}
			/*
			 * if(map.get(s.charAt(j)) > 3) { // need to shift right map.put(s.charAt(i),
			 * map.getOrDefault(s.charAt(i), 0)-1); i++; }
			 */
			
			maxLength = Math.max(maxLength, j-i +1);
			j++;		
		}
		return maxLength;
	}

	private static int maximumLengthSubstring(String s) {
		int maxOcuu = 0;
		
		for(int i=0; i<s.length(); i++ ) {
			Map<Character, Integer> map = new HashMap<>();

		for(int j=i; j<s.length(); j++ ) {
			if(map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
			}else {
				map.put(s.charAt(j), 1);
				
			}
			
			if(map.get(s.charAt(j)) == 3)
			{
				break;
			}
			
			maxOcuu = Math.max(maxOcuu, j-i+1);
		}
			
		}
		return maxOcuu;
	}

}
