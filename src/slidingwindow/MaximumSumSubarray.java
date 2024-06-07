package slidingwindow;

public class MaximumSumSubarray {

	/*	Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

	Example:
	
	Input:
	N = 4, K = 2
	Arr = [100, 200, 300, 400]
	Output:
	700
	Explanation:
	Arr3  + Arr4 =700,
	which is maximum. . 
-----------------------------------------*/
	public static void main(String[] args) {
		
		int[] arr = {100, 200, 300, 400};
		int k = 2;
		int maxSum = findMaxSumSubArry(arr, k);
		System.out.println("max sub array is "+maxSum);

	}

	private static int findMaxSumSubArry(int[] arr, int window) {
		int i = 0;
		int j = 0;
		int size = arr.length-1;
		int sum = 0;
		int max = 0;
		while(j <= size) {
			sum = sum + arr[j];
			//Check windows size if less
			if(j -i + 1 < window) {
				j++;
			}
			else if(j - i + 1 == window) {
				max = Math.max(sum, max);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		
		return max;
	}

}
