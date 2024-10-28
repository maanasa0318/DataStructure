package slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
		
		int i =0;
		int j =0;
		int occurence =0;
		List<Character> ch1 = new ArrayList<Character>();
		
		while(j < s.length()) {
			ch1.add(s.charAt(j));
			System.out.println(ch1);
			
			
			if(j - i +1 < s1.length()) {
				j++;
			}
			else if ( j - i + 1 == s1.length()) {
				//now check if given string is anagram.
				boolean result = checkAnagram(s1,ch1);
				if (result) {
					occurence = occurence + 1;
				}
				//now remove element at index i and shift 
			    if(ch1.get(i)== s.charAt(i)) {
			    	ch1.remove(i);
			    }
				i++;
				j++;
			}
			
		}
		return occurence;
		
	}

	private static boolean checkAnagram(String s1, List<Character> ch) {
		char[] ch1 = new char[ch.size()];
		for(int i=0; i <ch.size(); i++) {
			ch1[i] = ch.get(i);
		}
		System.out.println(ch1);
		
		char[] ch2 = s1.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(Arrays.equals(ch1, ch2)) {
			return true;
		}else {
			return false;
		}
	}

}
