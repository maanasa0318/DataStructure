package string;

public class LengthofLastWord {

	public static void main(String[] args) {

		String s = "a";
	    int res = lengthOfLastWord(s);
	    System.out.println(res);

	}

	private static int lengthOfLastWord(String s) {
		String str= s.trim();
		int count =0;
		for(int i=str.length() -1; i>=0; i--) {
			if(str.charAt(i) == '\s') {
				return count;
			}else {
				count++;
			}
		}
		return count;
	}

}
