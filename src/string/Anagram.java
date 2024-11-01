package string;

public class Anagram {

	public static void main(String[] args) {

		String s = "xx";
		String t = "bb";
		System.out.println(validAnagram(s,t));
	}

	private static boolean validAnagram(String s, String t) {
		int[] freqCount = new int[26];
		if(s.length() != t.length()) {
			return false;
		}
		for(int i=0; i<s.length(); i++) {
			freqCount[s.charAt(i)-'a']++;
			freqCount[t.charAt(i)-'a']--;
		}
		
		for(int i=0; i<freqCount.length; i++) {
			if(freqCount[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
