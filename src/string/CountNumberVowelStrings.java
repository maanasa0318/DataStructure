package string;

public class CountNumberVowelStrings {

	public static void main(String[] args) {

		String[] words = {"vo","j","i","s","i"};
		int left = 0;
		int right = 3;
		int count =  vowelStrings(words, left, right) ;
		System.out.println(count);
		
	}

	private static int vowelStrings(String[] words, int left, int right) {
		int vowelCount =0;
		for(int i=left; i<=right; i++) {
			char firstletter = words[i].charAt(0);
			char lastletter = words[i].charAt(words[i].length()-1);
			boolean isFirstLetterVowel = checkVowel(firstletter);
			boolean isLastLetterVowel = checkVowel(lastletter);
			if (isFirstLetterVowel && isLastLetterVowel) {
				vowelCount ++;
			}
			
		}
		return vowelCount;
	}
	
	private static boolean checkVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}

}
