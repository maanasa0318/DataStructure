package string;

import java.util.ArrayList;
import java.util.List;

public class Findwordscontainingcharacter {

	public static void main(String[] args) {

		String[] words = {"leet","code"};
		char x = 'e';
		List<Integer> res = findWordsContaining( words,  x);
		System.out.println(res);
	}

	private static List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<words.length; i++) {
			CharSequence ch = x+"";
			 // or words[i].contains(String.valueOf(x));
			if(words[i].contains(ch)) {
				res.add(i);
			}
		}
		return res;
	}

}
