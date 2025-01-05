package tuf;

import java.util.Arrays;

public class FrogjumpwithKdistances {

	public static void main(String[] args) {

		int[] heights = {15, 4, 1, 14, 15};
        int k = 3;
        int res = frogJump(heights, k);
        System.out.println(res);
	        
	}
	
    public static int frogJump(int[] heights, int k) {
    	int n = heights.length-1;
    	int[] dp = new int[n+1];
    	Arrays.fill(dp, -1);
    	//return frogJumpRecusrion(heights, k, n);
    	return frogJumpMemo(heights, k, n, dp);

    }

	private static int frogJumpMemo(int[] heights, int k, int index, int[] dp) {
		if(index ==0) {
			return 0;
		}
		if(dp[index] != -1) {
			return dp[index];
		}
		int minStep = Integer.MAX_VALUE;
		
		for(int i=1; i<=k; i++) {
			if(index - i >= 0) {
				int jump = frogJumpMemo(heights, k, index-1, dp) + Math.abs(heights[index]-heights[index-i]);
				minStep = Math.min(minStep, jump);
			}
		}
		dp[index] = minStep;
		return dp[index];
	}

	private static int frogJumpRecusrion(int[] heights, int k, int index) {
		if(index ==0) {
			return 0;
		}
		int minStep = Integer.MAX_VALUE;
		
		for(int i=1; i<=k; i++) {
			if(index-i >= 0) {
				int jumpone = frogJumpRecusrion(heights, k, index-i) + Math.abs(heights[index] - heights[index-i]);
				minStep = Math.min(minStep, jumpone);
			}
		}
		return minStep;
	}

}
