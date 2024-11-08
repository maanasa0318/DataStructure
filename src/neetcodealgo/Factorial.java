package neetcodealgo;

public class Factorial {

	public static void main(String[] args) {

		int i = 5;
		//recursive
		int result = recursivefactorial(i);
		System.out.println(result);
		
		int result1 = factorial(i);
		System.out.println(result1);
	}

	private static int factorial(int n) {
		int result = 1;
		while(n > 1) {
			result = result * n;
			n = n-1;
		}
		return result;
		
	}

	private static int recursivefactorial(int n) {
	    // Base case: n = 0 or 1
	    if (n <= 1) {
	        return 1;
	    }
	    // Recursive case: n! = n * (n - 1)!
	    return n * recursivefactorial(n-1);
	}

}
