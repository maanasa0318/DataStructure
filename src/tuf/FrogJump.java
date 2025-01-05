package tuf;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {

		int[] height = {2,1,3,5,4};
		int res = frogJump(height);
		System.out.println(res);
	}

	private static int frogJump(int[] height) {
		int n = height.length;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		//return frogJumpMemization(n-1, height, dp);
		//return frogJumpTabulation(n-1, height, dp);
		//return frogJumpRecursion(n-1, height);
		return frogJumpOptimization(n-1, height, dp);
	}

	private static int frogJumpRecursion(int step, int[] height) {
		if(step==0) {
			return 0;
		}
		int stepOne = frogJumpRecursion(step-1, height) + Math.abs(height[step]- height[step-1]);
		int stepTwo = Integer.MAX_VALUE;
		if(step > 1) {
			stepTwo = frogJumpRecursion(step-2, height) + Math.abs(height[step]- height[step-2]);
		}
		return Math.min(stepOne, stepTwo);
	}
	
	//memoization 
	private static int frogJumpMemization(int step, int[] height, int[] dp) {
		if(step==0) {
			return 0;
		}
		if(dp[step] != -1) {
			return dp[step];
		}
		int stepOne = frogJumpRecursion(step-1, height) + Math.abs(height[step]- height[step-1]);
		int stepTwo = Integer.MAX_VALUE;
		if(step > 1) {
			stepTwo = frogJumpRecursion(step-2, height) + Math.abs(height[step]- height[step-2]);
		}
		return dp[step] = Math.min(stepOne, stepTwo);
	}
	
	//tabulation 
	private static int frogJumpTabulation(int step, int[] height, int[] dp) {
		//base case
		dp[0] = 0;
		for(int i=1; i<step; i++) {
			if(dp[step] != -1) {
				return dp[step];
			}
			int stepOne = dp[step-1] + Math.abs(height[step]- height[step-1]);
			int stepTwo = Integer.MAX_VALUE;
			if(step > 1) {
				stepTwo = dp[step-2] + Math.abs(height[step]- height[step-2]);
			}
			dp[step] = Math.min(stepOne, stepTwo);
		}
		return dp[step-1];
	}
	
	private static int frogJumpOptimization(int step, int[] height, int[] dp) {
		int prev=0;
		int prev2=0;
		
		for(int i=1; i<step; i++) {
		
			int stepOne = prev + Math.abs(height[step]- height[step-1]);
			int stepTwo = Integer.MAX_VALUE;
			if(step > 1) {
				stepTwo = prev2 + Math.abs(height[step]- height[step-2]);
			}
			int curr = Math.min(stepOne, stepTwo);
			prev2=prev;
			prev=curr;
		}
		return prev;
	}

}
