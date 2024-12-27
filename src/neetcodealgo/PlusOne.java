package neetcodealgo;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {

		int[] digits = {7,9,0};
		int[] res = plusone(digits);
		System.out.println(Arrays.toString(res));
	}

	private static int[] plusone(int[] digits) {
		int n = digits.length;
		System.out.println(n);
		for(int i=n-1; i>=0; i--) {
			if(digits[i] < 9) {
				digits[i] = digits[i] +1;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] res = new int[n +1];
		res[0] = 1;
		return res;
	}

}
