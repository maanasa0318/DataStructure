package string;

public class FirstUniqueCharacter {

	public static void main(String[] args) {

		String s = "leetcode";
		int index = firstUniqChar(s) ;
		System.out.println(index);
	}

	private static int firstUniqChar(String s) {
		int[] freq = new int[26];
		char[] ch = s.toCharArray();
		
		for(Character c : ch) {
			freq[c-'a']++;
		}
		
		for(int i=0; i<ch.length; i++) {
			
			if(freq[ch[i]-'a']==1) {
				return i;
			}
		}
		return -1;
	}

}
