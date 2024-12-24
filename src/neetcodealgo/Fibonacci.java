package neetcodealgo;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {

		int i =5;
		int res = fibbonacci(5);
		System.out.println(res);
		int res1 = dpfibbonacci(10);
		System.out.println(res1);
	}


	private static int dpfibbonacci(int n) {
		if(n <= 1) {
			return n;
		}
		if(map.containsKey(n)) {
			return map.get(n);
		}
		int res = dpfibbonacci(n-1) + dpfibbonacci(n-2);
		map.put(n, res);
		return res;
	}

	private static int fibbonacci(int n) {

		if( n <= 1) {
			return n;
		}
		// f(n) = F(n-1) + F(n-2)
		return fibbonacci(n-1) + fibbonacci(n-2);
	}
	
	

}
