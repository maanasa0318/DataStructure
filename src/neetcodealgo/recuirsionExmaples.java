package neetcodealgo;

import java.util.Arrays;

public class recuirsionExmaples {
	static int count =0;

	public static void main(String[] args) {
		printName("maanasa", count);
		printLinearly(0, 10);
		System.out.println();
		printNto1(4,4);
		System.out.println();
		printLineralyBacktrack(3,3);
		System.out.println();
		parameterisedSum(3, 0);
		System.out.println();
		int res = functionRecursion(3);
		System.out.println(res);
		int res1 = factorial(5);
		System.out.println("factrorial=" +res1);
		int[] arr = new int [] {2,3,6,9};
		int l=0;
		int r = arr.length-1;
		swap(arr,l, r );
		System.out.println(Arrays.toString(arr));
		
	}
	



	private static void swap(int[] arr, int l, int r) {
	    if(l>=r) {
	    	return;
	    }
	    int temp = arr[l];
	    arr[l] = arr[r];
	    arr[r]=temp;
	    swap(arr, l+1, r-1);
	}

	private static int factorial(int i) {
		if(i ==0) {
			return 1;
		}
		return i * factorial(i-1);
	}

	private static int functionRecursion(int n) {
		if(n ==0) {
			return 0;
		}
		return n + functionRecursion(n-1);
	}


	private static void parameterisedSum(int n, int sum) {
		if(n < 1) {
			System.out.println(sum);
			return;
		}
		
		parameterisedSum(n-1, sum+n);

	}

	private static void printLineralyBacktrack(int i, int n) {
		if(i < 1) {
			return;
		}
		printLineralyBacktrack(i-1,3);
		System.out.println(i);
		
	}

	private static void printNto1(int start, int n) {
		if(start < 1) {
			return;
		}
		System.out.println(start);
		printNto1(start-1, n);
	}

	private static void printLinearly(int start, int n) {
		if(start > n) {
			return;
		}
		System.out.println(start);
		printLinearly(start+1, n);

	}

	private static void printName(String string, int count) {
		if(count >5) {
			return;
		}
		System.out.println(string+":"+count);
			count++;
			printName(string, count);
		}
	}


