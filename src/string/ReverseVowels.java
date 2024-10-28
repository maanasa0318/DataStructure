package string;

public class ReverseVowels {

	public static void main(String[] args) {

		String s = "hello";
		String res = revVowel(s);
		System.out.println(res);
	}

	private static String revVowel(String s) {
		char[] ch = s.toCharArray();
		int start =0;
		int end = s.length()-1;
		
		while(start < end) {
			if(!checkVowel(ch[start])) {
				start ++;
			}
			else if(!checkVowel(ch[end])) {
				end --;
			}
			else {
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start ++;
				end --; 
				
			}
		}
		return String.valueOf(ch);
	}

	private static boolean checkVowel(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}

}
