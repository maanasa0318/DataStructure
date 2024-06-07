package slidingwindow;

/*Problem Description:

Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.

For Input:
k = 5
4 1 1 1 2 3 5
your output is: 
4 . */
public class LargestSubarray {

	public static void main(String[] args) {

		//int[] arr = { 4, 1, 1, 1, 2, 3, 5 };
		int[] arr = { -5, 8, -14, 2, 4, 12 };
		int k = -5;
		int res = findLargestSubArray(arr, k);
		System.out.println("Largest subarray is " + res);

	}

	private static int findLargestSubArray(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		while (i <= arr.length - 1) {
			sum = sum + arr[j];
			if (sum < k) {
				j++;
			} else if (sum == k) {
				if(j-i+1 > max) {
					max = j- i +1;
				}
				j++;
			}else if( sum > k) {
				while(sum >= k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}
		}
		return max;
	}
}
