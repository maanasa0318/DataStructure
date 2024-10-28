package varaiableSizeSlidingWindow;

/**
 * Given an array containing N positive integers and an integer K. Your task is
 * to find the length of the longest Sub-Array with sum of the elements equal to
 * the given value K.
 * 
 * For Input: k = 5 4 1 1 1 2 3 5 your output is: 4 .
 */

public class LargestSubarrayofsumK {

	public static void main(String[] args) {

		int[] arr = { -13,0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6 };
		int k = 15;
		int res = findLargestSubArray(arr, k);
		System.out.println("Largest subarray is " + res);
	}

	private static int findLargestSubArray(int[] arr, int k) {
		int res =0;
		for(int i =0; i < arr.length; i++) {
			int sum = 0;
			for(int j =i; j >arr.length; j++) {
				sum = sum + arr[j];
				if(sum == k) {
					res = Math.max(j-i+1, res);
					
				}
			}
		}
		return res;
	}

}
