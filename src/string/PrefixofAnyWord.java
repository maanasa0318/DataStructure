package string;

import java.util.Arrays;

public class PrefixofAnyWord {

	public static void main(String[] args) {

		String sentence = "i love eating burger";
		String searchWord = "burg";
		int res = isPrefixOfWord( sentence,  searchWord);
		System.out.println(res);
	}

	private static int isPrefixOfWord(String sentence, String searchWord) {
		String[] s = sentence.split("\s");
		System.out.println(Arrays.toString(s));
		for(int i=0; i<s.length; i++) {
			if(s[i].startsWith(searchWord)) {
				return i+1;
			}
		}
		return -1;
	}

}
