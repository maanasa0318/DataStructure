package string;

public class ValidParentheses {

	public static void main(String[] args) {

		String s = "([])}";
		System.out.println(isValid(s));
	}

	private static boolean isValid(String s) {
		while(true) {
			if(s.contains("()")) {
				s= s.replace("()", "");
			}
			else if(s.contains("[]")) {
				s= s.replace("[]", "");
			}
			else if (s.contains("{}")) {
				s= s.replace("{}", "");
			}
			else {
				return s.isEmpty();
			}
		}
		
	}

}
