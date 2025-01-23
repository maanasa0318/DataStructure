package tuf;

import java.util.Arrays;

public class SurroundedRegions {

	private static int[] delRow = { 1, 0, -1, 0 };
	private static int[] delCol = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		char[][] mat = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		// Function call to replace surrounded 'O's with 'X's
		char[][] ans = fill(mat);

		int n = ans.length;
		int m = ans[0].length;

		// Output
		System.out.println("The updated matrix is:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	 public static void dfs(int r, int c, boolean[][] vis,char[][] mat){
	        vis[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int newRow = r + delRow[i];
				int newCol = c + delCol[i];

				if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length && !vis[newRow][newCol]
						&& mat[newRow][newCol] == 'O' && !vis[newRow][newCol]) {
					
					dfs(newRow, newCol, vis, mat);
				}
			}
	    }
	   
	    public static char[][] fill(char[][] mat) {
	        int n = mat.length;
			int m = mat[0].length;
			boolean[][] vis = new boolean[n][m];
			

			 for (int j = 0; j < m; j++) {
		            
		            // First row
		            if (!vis[0][j] && mat[0][j] == 'O') {
		                // Start DFS traversal from current node
		                dfs(0, j, vis, mat);
		            }
		            
		            // Last row
		            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') {
		                // Start DFS traversal from current node
		                dfs(n - 1, j, vis, mat);
		            }
		        }
		        
		        for (int i = 0; i < n; i++) {
		            // Check for unvisited 'O's in boundary columns
		            
		            // First column
		            if (!vis[i][0] && mat[i][0] == 'O') {
		                // Start DFS traversal from current node
		                dfs(i, 0, vis, mat);
		            }
		            
		            // Last column
		            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
		                // Start DFS traversal from current node
		                dfs(i, m - 1, vis, mat);
		            }
		        }

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (mat[r][c] == 'O' && !vis[r][c]) {
						mat[r][c] = 'X';
					}
				}
			}
			return mat;
	    }
	}

