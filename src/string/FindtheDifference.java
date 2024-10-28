package string;

public class FindtheDifference {

	public static void main(String[] args) {

		String s = "abcd";
		String t = "abcde";
		char c = findTheDifference( s, t);
		System.out.println(c);
	}

	private static char findTheDifference(String s, String t) {
		int total =0;
		for(int i=0; i<s.length(); i++) {
			total = total + s.charAt(i);
		}
		
		for(int i=0; i<t.length(); i++) {
			total = total - t.charAt(i);
		}
		
		return (char)Math.abs(total);
	}

}
