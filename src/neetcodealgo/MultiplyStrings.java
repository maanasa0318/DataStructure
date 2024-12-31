package neetcodealgo;

public class MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "123", num2 = "456";
		String ans = multiply(num1, num2);
		System.out.println(ans);
	}
	
    public static String multiply(String num1, String num2) {
    	char[] s1 = rev(num1);
    	char[] s2 = rev(num2);
    	int[] res = new int[num1.length() + num2.length()];
    	
    	for(int i=0; i<s1.length; i++) {
    		int start =i;
    		int carry =0;
    		
    		for(int j=0; j<s2.length; j++) {
    			int n1 = s1[i]-'0';
    			int n2 = s2[j]-'0';
    			int sum = (n1 * n2)+res[start]+carry;
    			int digit = sum%10;
    			carry = sum/10;
    			res[start++] = digit;
    		}
    		if(carry !=0) {
    			res[start] = carry;
    		}
    	}
    	//remove 0's
    	int i = res.length-1;
    	while(i > 0 && res[i]==0) {
    		i--;
    	}
    	String ans = "";
    	while(i>=0) {
    		ans += res[i--];
    	}
 		return ans;
    	
    }

    public static char[] rev(String s){
    	char[] ans = s.toCharArray();
        int start =0;
        int end = s.length() -1;
        while(start <= end){
            char c = ans[start];
            ans[start] = ans[end];
            ans[end] = c;
            start++;
            end--;
        }
        return ans;
    }
    
    

}
