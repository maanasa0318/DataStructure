package tuf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Numberdistinctislands {

	public static void main(String[] args) {
		int[][] grid = {
	            {1, 1, 0, 1, 1},
	            {1, 0, 0, 0, 0},
	            {0, 0, 0, 0, 1},
	            {1, 1, 0, 1, 1}
	        };

	        int ans = numDistinctIslands(grid);

	        // Output
	        System.out.println("The count of distinct islands in the given grid is: " + ans);
	    }
	
	public static int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> distinctIslands = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    bfs(grid, visited, i, j, shape, i, j);
                    distinctIslands.add(String.join(",", shape));
                }
            }
        }

        return distinctIslands.size();
    }

    private static void bfs(int[][] grid, boolean[][] visited, int x, int y, List<String> shape, int baseX, int baseY) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0], curY = current[1];

            // Record the relative position
            shape.add((curX - baseX) + ":" + (curY - baseY));

            for (int[] dir : directions) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length 
                    && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

	

}
