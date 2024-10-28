package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationinString {

	public static void main(String[] args) {
		String s1= "ab";
		String s2 = "eidbaooo";
		
		boolean result = checkInclusion( s1,  s2);
		System.out.println("result is: " + result);
	}

	private static boolean checkInclusion(String s1, String s2) {
		int i =0;
		int j =0;
		List<Character> list = new ArrayList<Character>();
		
		while(j < s2.length()) {
			list.add(s2.charAt(j));
			
			if(j - i + 1 < s1.length()) {
				j++;
			}
			else if (j - i +1 == s1.length()) {
				boolean anagram = checkAnagram(s1, list);
				if(anagram) {
					return true;
				}
				//now remove elemnt at index i 
				if(list.get(0) == s2.charAt(i)) {
					list.remove(0);
				}
				i++;
				j++;
			}
		}
		return false;
	}

	private static boolean checkAnagram(String s1, List<Character> list) {
		char[] ch = list.stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
		/*
		 * char[] ch = new char[list.size()]; for(int i =0; i <list.size(); i++) {
		 * ch[i]=list.get(i); }
		 */
		System.out.println(ch);
		
		char[] ch2 = s1.toCharArray();
		Arrays.sort(ch);
		Arrays.sort(ch2);
		if(Arrays.equals(ch, ch2)) {
			return true;
		}
		
		return false;
	}

}
