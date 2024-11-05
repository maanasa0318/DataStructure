package top150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringEncodeDecode {

	public static void main(String[] args) {
		//List<String> strs = Arrays.asList("neet","code","love","you");
		List<String> strs = Arrays.asList("we","say",":","yes","!@#$%^&*()");
		String encodedStr = encode(strs);
		System.out.println(encodedStr);

		List<String> decodedString = decode(encodedStr);
        System.out.println(decodedString.toString());

	}

	private static String encode(List<String> strs) {
		String res = "";
		for (String s : strs) {
			StringBuilder sb = new StringBuilder();
			int len = s.length();
			sb = sb.append(len);
			sb = sb.append("#");
			sb = sb.append(s);
			res = res + sb.toString();
		}
		return res;

	}

	private static List<String> decode(String str) {
		List<String> res = new ArrayList<>();
		String s = "";
		s = str.replaceAll("[0-9#]", " ");
		if (s.contains("") && s.length() == 2) {
			System.out.println(s);
			res.add("");
			return res;
		} else {
			String[] splitString = s.split("\s");
			for (String eachString : splitString) {
				s = eachString.strip();
				if (s.length() != 0) {
					res.add(s);
				}
			}
			return res;
		}

	}

}
