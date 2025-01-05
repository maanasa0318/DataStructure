package tuf;

import java.util.Arrays;

public class Maximumsumnonadjacentelements {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 9 };

		// Call the nonAdjacent function and print the result
		//System.out.println(nonAdjacent(arr));
		//System.out.println(tabulation(arr));
		//System.out.println(spaceoptimizatin(arr));
		System.out.println(houseRobber(arr));

	}
	
	private static int houseRobber(int[] arr) {
		int n = arr.length;
		int[] arr1 = new int[n-1];
		int[] arr2 = new int[n-1];
		int count1 =0;
		int count2 =0;
		
		for(int i=0; i< n-1; i++) {
			arr1[count1++] = arr[i];
		}
		for(int i=1; i< n; i++) {
			arr2[count2++] = arr[i];
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(arr, 0, n-1);
		int[] arr4 = Arrays.copyOfRange(arr, 1, n);
		
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		spaceoptimizatin(Arrays.copyOfRange(arr, 0, n-1));
		spaceoptimizatin(Arrays.copyOfRange(arr, 1, n));
		return Math.max(spaceoptimizatin(Arrays.copyOfRange(arr, 0, n-1)), spaceoptimizatin(Arrays.copyOfRange(arr, 1, n)));
		
	}

	private static int spaceoptimizatin(int[] nums) {
		int n = nums.length;
		int prev = nums[0];
		int prev2 = 0;
		for(int i=1; i<n; i++) {
			int pick = nums[i];
			if(i > 1) {
				pick += prev2;
			}
			int notpick = 0+ prev;
			
			int curr = Math.max(pick, notpick);
			prev2=prev;
			prev= curr;
		}
		return prev;
	}

	private static int tabulation(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n+1];
		if(n==1) {
			return arr[0];
		}
		dp[0] = arr[0];
		
		for(int i=1; i<n; i++) {
			int pick = arr[i];
			if(i > 1) {
				pick += arr[i - 2];
			}
			int notpick = arr[i-1];
			dp[i] = Math.max(pick, notpick);
		}
		
		return dp[n-1];
		
	}

	public static int nonAdjacent(int[] nums) {

		int index = nums.length-1;
		int[] dp = new int[nums.length+1];
		Arrays.fill(dp, -1);
		return memo(index, nums, dp);
		//return func(index, nums);
    }

	private static int memo(int n, int[] nums, int[] dp) {
		if(n==0) {
			return nums[0];
		}
		if(n <0) {
			return 0;
		}
		if(dp[n]!= -1) {
			return dp[n];
		}
		int pick = nums[n] + memo(n-2, nums, dp);
		int notpick = 0 + memo(n-1, nums, dp);
		return dp[n] = Math.max(pick, notpick);
	}

	private static int func(int n, int[] nums) {
		if(n==0) {
			return nums[0];
		}
		if(n <0) {
			return 0;
		}
		
		int pick = nums[n] + func(n-2, nums);
		int notpick = 0 + func(n-1, nums);
		return Math.max(pick, notpick);
	}

}
