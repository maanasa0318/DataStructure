package string;

public class FindtheIndexFirstOccurrence {

	public static void main(String[] args) {
		String haystack = "sadbutsad";
		String needle = "but"; 
		
		int res = strStr( haystack,  needle);
		System.out.println("Found at:"+res);
	}

	private static int strStr(String haystack, String needle) {
		System.out.println(haystack.length());
		System.out.println(haystack.substring(3,6));
		System.out.println(haystack.length()-needle.length());
		for(int i=0; i<= haystack.length()-needle.length(); i++) {
			System.out.println(haystack.charAt(i));
			if(haystack.substring(i, needle.length()+i).endsWith(needle)){
				return i;
			}
		}
		return -1;
	}

}
