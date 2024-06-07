package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

Example 1:

Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:

Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt. . */
public class CountOccurrencesOfAnagrams {

	public static void main(String[] args) {
		String s = "aabaabaa";
		String s1 = "aaba";
		System.out.println(s1.length());
		int count = findNoOfOccu(s,s1);
		System.out.println("no of occrs " + count);
	}

	private static int findNoOfOccu(String s, String s1) {
		int i = 0;
		int j = 0;
		int size = s.length();
		int res = 0;
		int k = s1.length();
		StringBuilder sb = new StringBuilder();
		
		while(j <= size) {
			
			sb = sb.append(s.charAt(j));
			
			if( j -1 + 1 < k) {
				j++;
			}
			else if( j - i +1 == k) {
				boolean isEqual = checkIfStringsConatinsSameChar(sb.toString(), s1);
				System.out.println(isEqual);
				if(isEqual) {
					res = res + 1;
				}
				sb.deleteCharAt(i);
				i++;
				j++;
			}	
		}	
		return res;
	}

	private static boolean checkIfStringsConatinsSameChar(String s, String s1) {
		char[] c1 = s.toCharArray();
		char[] c2 = s1.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (c1 == c2) {
			return true;
		}else {
			return false;
		}	
	}

}
