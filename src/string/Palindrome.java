package string;

public class Palindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		 boolean res = isPalindrome(s);
		 System.out.println(res);
		 
		 //Valid Palindrome II
		 String input = "abca";
		 boolean rs1 = validPal(input);
		 System.out.println(rs1);
	}
	
	private static boolean validPal(String s) {
		int i =0;
		int j = s.length()-1;
		
		while(i <= j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else {
				return isPali(s, i+1, j) || isPali(s,i, j-1 );
			}
			
		}
		return true;
	}

	private static boolean isPali(String s, int i, int j) {
		while(i <= j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else {
				return false;
			}
		}
		return true;
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
