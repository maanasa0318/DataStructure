package neetcodealgo;

import java.util.HashSet;

public class lengthOfLongestSubstring {

	public static void main(String[] args) {

		 String s = "zxyzxyz";
		 int len = longestSubString(s);
		 System.out.println(len);
	}

	private static int longestSubString(String s) {
		int l =0;
		int res =0;
		HashSet<Character> set = new HashSet<>();
		
		for(int r=0; r<s.length(); r++) {
			while(set.contains(s.charAt(r))) {
				set.remove(s.charAt(l));
				l++;
			}
			set.add(s.charAt(r));
			res = Math.max(res, r - l +1);
		}
		
		return res;
	}

}
