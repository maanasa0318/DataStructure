package neetcodealgo;

public class Fibonacci {

	public static void main(String[] args) {

		int i =5;
		int res = fibbonacci(5);
		System.out.println(res);
	}

	private static int fibbonacci(int n) {

		if( n <= 1) {
			return n;
		}
		// f(n) = F(n-1) + F(n-2)
		return fibbonacci(n-1) + fibbonacci(n-2);
	}

}
