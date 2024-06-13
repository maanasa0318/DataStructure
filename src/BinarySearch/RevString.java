package BinarySearch;

public class RevString {

	public static void main(String[] args) {

		String s = "Hello";
		
		String revString = reverseString(s);
		System.out.println("Revese string is " + revString);
	}

	private static String reverseString(String s) {
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
 		for(int i =ch.length -1 ; i >= 0 ; i--) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}

}
