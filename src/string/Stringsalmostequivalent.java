package string;

public class Stringsalmostequivalent {

	public static void main(String[] args) {

	   String word1 = "aaaa";
	   String word2 = "bccb";
	   System.out.println(checkAlmostEquivalent( word1, word2));
	}

	private static boolean checkAlmostEquivalent(String word1, String word2) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		
		for(int i=0; i<word1.length(); i++) {
			freq1[word1.charAt(i)-'a']++;
		}
		
		for(int i=0; i<word2.length(); i++) {
			freq2[word2.charAt(i)-'a']++;
		}
		
		//calculate diff
		for(int i=0; i<freq1.length; i++) {
			int diff = freq1[i]- freq2[i];
			if(Math.abs(diff) > 3) {
				return false;
			}
		}
		
		return true;
	}

}
