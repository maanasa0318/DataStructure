package tuf;

import java.util.Arrays;

public class Minimumpathsumingrid {
	public static int ROW =4;
	public static int COL =4;
	public static int[][]dp = new int [4][4];
	
	public static void main(String[] args) {

		int[][] matrix = {
	            {1, 2, 10, 4},
	            {100, 3, 2, 1},
	            {1, 1, 20, 2},
	            {1, 2, 2, 1}
	        };
	    
	       
	        // Call the minFallingPathSum function and print the result
	        System.out.println("memon result" + minFallingPathSum(matrix));
	        //System.out.println(tab(matrix));

	}

	private static int tab(int[][] matrix) {
		for(int[] r : dp) {
			Arrays.fill(r, -1);
		}
		//int ROW = matrix.length;
		//int COL = matrix[0].length;
		//dp = new int [ROW][COL];
		//for(int[] r : dp) {
			//Arrays.fill(r, -1);
		//}
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(r == 0 && c ==0) {
					dp[r][c]= matrix[r][c];
				}
				else {
					int up = matrix[r][c];
					if(r > 0) {
						up += dp[r-1][c];
					}
					else {
						up += Integer.MAX_VALUE;
					}
					
					int down = matrix[r][c];
					if(c>0) {
						down += dp[r][c-1];
					}
					else {
						down += Integer.MAX_VALUE;
					}
					dp[r][c] = Math.min(up, down);
				}
			}
		}
		return dp[ROW-1][COL-1];
	}

	private static int minFallingPathSum(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int [row][col];
		for(int[] r : dp) {
			Arrays.fill(r, -1);
		}
		return memo(0, 0, matrix);
		//return recursion(row-1, col-1, matrix);
	   
	}

	private static int memo(int row, int col, int[][] matrix) {
		if(row==matrix.length -1 && col==matrix[0].length-1) {
			return matrix[row][col];
		}
		if(row == matrix.length || col == matrix[0].length) {
			return Integer.MAX_VALUE;
		}
		if(dp[row][col] != -1) {
			return dp[row][col];
		}
        dp[row][col] = matrix[row][col] + Math.min(memo(row + 1, col, matrix), memo(row, col + 1, matrix));

		 return dp[row][col];
	}

	private static int recursion(int row, int col, int[][] matrix) {
		if(row ==0 && col ==0) {
			return matrix[0][0];
		}
		if(row<0 || col < 0) {
			return Integer.MAX_VALUE;
		}
		int up = matrix[row][col] + recursion(row-1, col, matrix);
		int left = matrix[row][col] + recursion(row, col-1, matrix);
		
		return Math.min(up, left);
	}

}
