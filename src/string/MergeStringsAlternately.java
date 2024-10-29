package string;

public class MergeStringsAlternately {

	public static void main(String[] args) {

		String word1 = "abc";
		String word2 = "pqr";
		String res = mergeAlternately( word1,  word2);
		System.out.println(res);
	}

	private static String mergeAlternately(String word1, String word2) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(i<word1.length() || i<word2.length()){
				
			if(i<word1.length()) {
				sb.append(word1.charAt(i));
			}
			if(i< word2.length()) {
				sb.append(word2.charAt(i));
			}
			i++;
		}
		return sb.toString();
	}

}
