package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodingDecoding {

	public static void main(String[] args) {

		String [] input= {"neet","code","love","you"};
		String res = encode(input);
		System.out.println(res);
		
		List<String>  decodedString = decode(res);
		System.out.println(decodedString);
	}

	private static List<String>  decode(String str) {
		List<String> res = new ArrayList<String>();
		int i=0;
		while(i < str.length()) {
			int j = i;
			if(str.charAt(j) != '#') {
				j++;
			}
			
			int len = Integer.parseInt(str.substring(i, j));
			System.out.println("len is: " + len);
			i = j +1;
			j = i + len;
			res.add(str.substring(i, j));
			i = j;
		}
		return res;
	}

	private static String encode(String[] input) {
		StringBuilder sb = new StringBuilder();
		for(String s : input) {
			sb.append(s.length()).append("#").append(s);
		}
		return sb.toString();
	}

}
