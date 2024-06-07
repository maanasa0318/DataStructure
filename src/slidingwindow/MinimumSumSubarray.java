package slidingwindow;

public class MinimumSumSubarray {
	/*	Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

	Example:
	
	Input:
	N = 4, K = 2
	Arr = [100, 200, 300, 400]
	Output:
	300
	Explanation:
	Arr0  + Arr1 =300,
	which is maximum. . 
-----------------------------------------*/
	public static void main(String[] args) {

		int[] arr = {100, 200, 300, 400};
		int k = 2;
		int maxSum = findMinSumSubArry(arr, k);
		System.out.println("min sub array is "+maxSum);
	}

	private static int findMinSumSubArry(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int size = arr.length-1;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while(j <= size) {
			sum = sum + arr[j];
			if(j - i +1  < k) {
				j++;
			}else if (j - i + 1 == k) {
				min = Math.min(min, sum);
				sum = sum - arr[i];
				i++;
				j--;
			}
		}
		
		return min;
	}

}
