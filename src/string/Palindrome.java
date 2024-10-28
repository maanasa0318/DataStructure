package string;

public class Palindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		 boolean res = isPalindrome(s);
		 System.out.println(res);
	}

	private static boolean isPalindrome(String s) {
		String str = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
		String revese = "";
		for(int i=str.length()-1; i>=0; i--) {
			revese=revese+str.charAt(i);
		}
		if(revese.equals(str)) {
			return true;
		}else {
			return false;
		}
	}

}
