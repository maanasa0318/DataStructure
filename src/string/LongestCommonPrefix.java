package string;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strs = {"flower","flow","flight"};
		String res = longestCommonPrefix(strs);
		System.out.println(res);
	}

	private static String longestCommonPrefix(String[] strs) {
		int index =0;
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		String str1 = strs[0];
		String str2 = strs[strs.length-1];
		
		while(index < str1.length()) {
			
			if(str1.charAt(index) == str2.charAt(index)) {
				index ++;
			}else {
				break;
			}
			
		}
		return index==0?"":str1.substring(0, index);
	}

}
