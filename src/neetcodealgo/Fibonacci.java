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
		//tabulation top down
		int n = 5;
		fibTabulation(n);
		
		
	}


	private static void fibTabulation(int n) {
		int prev2 = 0;
		int prev = 1;
		int curr =0;
		
		for(int j=2; j<=n; j++) {
			curr = prev + prev2;
			prev2 = prev;
			prev = curr;

		}
		System.out.println(prev);
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
