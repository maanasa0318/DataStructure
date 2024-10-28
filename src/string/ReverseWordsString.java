package string;

public class ReverseWordsString {

	public static void main(String[] args) {
		String s = " the sky is blue ";
		String res = reverseWords(s);
		System.out.println(res);
	}

	private static String reverseWords(String s) {
		String[] str = s.split(" +");
		StringBuilder sb = new StringBuilder();

		for(int i = str.length-1; i>=0; i--) {
			sb.append(str[i]);
			sb.append(" ");
		}
		return sb.toString().trim();
	}

}
