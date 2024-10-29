package string;

public class ReverseOnlyLetters {

	public static void main(String[] args) {

		String s = "a-bC-dEf-ghIj";
		//0/p j-Ih-gfE-dCba
		String result = reveserString(s);
		System.out.println(result);
	}

	private static String reveserString(String s) {
		int start=0;
		int end =s.length()-1;
		char[] ch = s.toCharArray();
		
		while(start < end) {
			
			if(!Character.isLetter(ch[start])) {
				start++;
			}
			else if(!Character.isLetter(ch[end])) {
				end --;
			}
			else {
				char temp= ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start++;
				end--;
			}
			
		}
		return new String (ch);
	}

}
