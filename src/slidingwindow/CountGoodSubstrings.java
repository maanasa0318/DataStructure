package slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountGoodSubstrings {

	public static void main(String[] args) {

		String s = "xyzzaz";
		// o/p "xyz", "yzz", "zza", and "zaz".
		int goodsubstring = countGoodSubstrings(s);
		System.out.println("Count of good substring is:"+goodsubstring);
		
		//another way
		int count =0;
		char[] ch = s.toCharArray();
		for(int i =0; i< s.length()-3; i++) {
			if(ch[i] != ch[i+1] &&
			   ch[i] != ch [i+2] &&
			   ch[i+1] != ch [i+2]) {
				count = count + 1;
			}
		}
		System.out.println("count is:" + count);
	}

	private static int countGoodSubstrings(String s) {
		int i =0;
		int j =0;
		int goodsubstring = 0;
		List<String> answer = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		while(j < s.length()) {
			
			//list.add(s.charAt(j));
			sb.append(s.charAt(j));
			
			if(j -i + 1 < 3) {
				j++;
			}
			else if( j - i + 1 == 3) {
				answer.add(sb.toString());
				if(sb.charAt(0) == s.charAt(i)) {
					//remove i from list
					sb.deleteCharAt(0);
				}
				i++;
				j++;
			}
		}
		System.out.println(answer);
		goodsubstring = calcuateUniuqeChar(answer);
		return goodsubstring;
	}

	private static int calcuateUniuqeChar(List<String> answer) {
		int count = 0;
		for(String s : answer) {
			 boolean result = extracted(s);
			 if(result) {
				 count = count + 1;
			 }
		}
		return count;
	}

	private static boolean extracted(String s) {
		char[] c = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		
		for(char ch : c) {
			// if char already in set return false
			if(!set.add(ch)) {
				return false;
			}
		}
		return true;
	}

}
