package string;

public class ValidAnagram {

	public static void main(String[] args) {

		String s = "anagram";
		String t = "nagaram";
		boolean res = checkAnagram(s,t);
		System.out.println(res);
	}

	private static boolean checkAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		else {
			int[] count = new int[27];
			for(int i =0; i<s.length(); i++){
				count[s.charAt(i)-'a']++;
			}
			for(int i =0; i<t.length(); i++){
				count[t.charAt(i)-'a']--;
			}
			
			for(int i=0; i<count.length; i++) {
				if(count[i] != 0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
