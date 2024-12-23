package neetcodealgo;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> res = partition(s);
		System.out.println(res);
		
	}
	
	 public static List<List<String>> partition(String s) {
		 List<List<String>> ans = new ArrayList<>();
		 List<String> partion = new ArrayList<>();
		 dfs(ans, partion, s, 0);
		return ans;
	        
	 }
	 
	 private static void dfs(List<List<String>> ans, List<String> partion, String s, int index) {
		 if(index == s.length()) {
			 ans.add(new ArrayList<>(partion));
		 }
		 
		 for(int i=index; i<s.length(); i++) {
			 if(isPalindrom(s, index, i)) {
				 partion.add(s.substring(index, i+1));
				 dfs(ans, partion, s, i+1);
				 partion.remove(partion.size()-1);
			 }
		 }
		 
	}

	public static boolean isPalindrom(String s, int start, int end) {
		 while(start <= end) {
			 if(s.charAt(start) == s.charAt(end)) {
				 start++;
				 end--;
			 }
			 else {
				 return false;
			 }
		 }
		 return true;
	 }

}
