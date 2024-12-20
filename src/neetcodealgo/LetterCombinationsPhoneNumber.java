package neetcodealgo;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	public static List<String> res = new ArrayList<>();
    public static String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    
	public static void main(String[] args) {
		List<String> res = letterCombinations("23");
		System.out.println(res);
	}
	



    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        dfs(0, "", digits);
        return res;
    }

    public static void dfs(int i, String currStr, String digit) {
        if(currStr.length()== digit.length()){
            res.add(currStr);
            return;
        }

        String chars = digitToChar[digit.charAt(i)-'0'];
        for(char c: chars.toCharArray()) {
        	dfs(i+1, currStr+c, digit);
        }

    }

}
