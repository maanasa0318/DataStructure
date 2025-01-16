package tuf;

import java.util.Arrays;

public class Subsetsumequalstarget {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		int target = 4;

		// Call the isSubsetSum function and print the result
		if (isSubsetSum(arr, target))
			System.out.println("Subset with the given target found");
		else
			System.out.println("Subset with the given target not found");
	}
	
    public static boolean isSubsetSum(int[] arr, int target) {
    	int[][] dp = new int[arr.length][target+1];
    	for(int[] row: dp) {
    		Arrays.fill(row, -1);
    	}
    	return func(arr.length-1, target, arr, dp);
    	
    }


    private static boolean func(int ind, int target, int[] arr, int[][] dp) {
		if(target == 0) {
			return true;
		}
		if(arr[0] == target) {
			return arr[0]== target;
		}
		if(dp[ind][target] != -1) {
			return dp[ind][target] == 0 ? true: false;
		}
		boolean notTake = func(arr.length-1, target, arr, dp);
		boolean take = false;
		if(arr[ind] <= target) {
			take = func(arr.length-1, arr[ind]-target, arr, dp);
		}
		dp[ind][target] = notTake || take ? 1:0;
		return take || notTake;
	}

}
