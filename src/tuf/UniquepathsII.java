package tuf;

import java.util.Arrays;

public class UniquepathsII {

	public static void main(String[] args) {

		 int[][] maze = {
		            {0, 0, 0},
		            {0, 1, 0},
		            {0, 0, 0}
		        };

		        System.out.println("Number of paths with obstacles: " + uniquePathsWithObstacles(maze));
	}

	private static int uniquePathsWithObstacles(int[][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		//return uniquePath(row-1, col-1, maze);
		int[][] dp = new int[row][col];
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		//return uniquePathmemo(row-1, col-1, maze, dp);
		return tabulation(row, col, maze, dp);
	}

	private static int tabulation(int row, int col, int[][] maze, int[][] dp) {
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(maze[r][c] == 1) {
					dp[r][c] = 0;
					continue;
				}
				if(r==0 && c==0) {
					dp[r][c] = 1;
					continue;
				}
				int up = 0;
				int left = 0;
				if(r > 0) {
					up = dp[r-1][c];
				}
				if(c > 0) {
					left = dp[r][c-1];
				}
				dp[r][c] = up + left;
			}
		}
		return dp[row-1][col-1];
	}

	private static int uniquePathmemo(int i, int j, int[][] matrix, int[][] dp) {
		 // Base cases
        if (i == 0 && j == 0) return 1;
        if (i > 0 && j > 0 && matrix[i][j] == 1) return 0;
        if (i < 0 || j < 0) return 0;
        
        // If the result is already computed, return it
        if (dp[i][j] != -1) return dp[i][j];

        /* Calculate the number of ways by
        moving up and left recursively.*/
        int up = uniquePathmemo(i - 1, j, matrix, dp);
        int left = uniquePathmemo(i, j - 1, matrix, dp);

        // Memoize the result and return the total ways
        return dp[i][j] = up + left;
	}

	private static int uniquePath(int row, int col, int[][] maze) {
		if(row > 0 && col > 0 && maze[row][col] == 1) {
			return 0;
		}
		if(row == 0 && col == 0) {
			return 1;
		}
		if(row < 0 || col < 0) {
			return 0;
		}
		int up = uniquePath(row-1, col, maze);
		int left = uniquePath(row, col-1,maze);
		return up + left;
	}

}
