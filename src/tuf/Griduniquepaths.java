package tuf;

import java.util.Arrays;

public class Griduniquepaths {

	public static void main(String[] args) {

		int m = 3;
		int n = 2;
		// Call the uniquePaths function and print the result
		System.out.println("Number of ways: " + uniquePaths(m-1, n-1));
		int[][] dp = new int[m][n];
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		System.out.println("Number of ways: " + memo(m-1, n-1, dp));
		System.out.println(tabulation(m, n, dp));
		//System.out.println(spaceoptim(m-1, n-1));

	}

	private static int spaceoptim(int i, int j) {
		int prev = 0;
		int prev2 = 0;
		
		return 0;
	}

	private static int tabulation(int m, int n, int[][] dp) {
		
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(r==0 && c==0) {
					dp[r][c] = 1;
					continue;
				}
				int up =0;
				int left =0;
				if(r > 0) {
					 up = dp[r-1][c];
				}
				if(c > 0) {
					left = dp[r][c-1];
				}
				dp[r][c] = up + left;
			}
		}
		return dp[m-1][n-1];
	}

	private static int memo(int m, int n, int[][]dp) {
		if(m ==0 && n == 0) {
			return 1;
		}
		if(m <0 || n <0) {
			return 0;
		}
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		int up = memo(m-1, n, dp);
		int down = memo(m, n-1, dp);
		return dp[m][n] = up+down;
		
	}

	private static int uniquePaths(int m, int n) {
		if(m ==0 && n==0) {
			return 1;
		}
		if(m <0 || n <0) {
			return 0;
		}
		int up = uniquePaths(m-1, n);
		int left = uniquePaths(m, n-1);
		return up+left;
	}
	
	

}
