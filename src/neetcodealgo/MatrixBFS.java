package neetcodealgo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MatrixBFS {

	public static void main(String[] args) {

		int[][] grid = { { 0, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };

		int res = bfs(grid);
		System.out.println(res);
		int res1 = bfs1(grid);
		System.out.println(res1);

	}

	private static int bfs1(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
        Set<String> visit = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit.add("0,0");

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] neighbor : neighbors) {
                    int dr = neighbor[0], dc = neighbor[1];
					if (Math.min(r + dr, c + dc) < 0 ||
                        r + dr == ROWS || c + dc == COLS ||
                        visit.contains((r + dr) + "," + (c + dc)) || grid[r + dr][c + dc] == 1) {
                        continue;
                    }
                    queue.add(new int[]{r + dr, c + dc});
                    visit.add((r + dr) + "," + (c + dc));
                }
            }
            length++;
        }
        return -1;
	}

	private static int bfs(int[][] grid) {
		int ROWS = grid.length;
		int COLS = grid[0].length;
		int[][] visit = new int[4][4];
		Deque<int[]> queue = new ArrayDeque<int[]>();

		queue.add(new int[2]); // add(0, 0) first position
		visit[0][0] = 1;

		int length = 0;
		while (!queue.isEmpty()) {
			int queueLen = queue.size();
			for (int i = 0; i < queueLen; i++) {

				int pair[] = queue.poll();
				int r = pair[0];
				int c = pair[1];
				if (r == ROWS - 1 && c == COLS - 1) {
					return length;
				}

				int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c } };
				for(int j =0; j < 4; j++) {
					int newR = neighbors[j][0];
					int newC = neighbors[j][1];
					if(Math.min(newR, newC) < 0 ||
							newR == ROWS || newC == COLS ||
							visit [newR][newC] == 1 ||
							grid[newR][newC] == 1) {
						continue;
					}
					queue.add(neighbors[j]);
					visit[newR][newC] = 1;
				}
			}
			length++;
		}

		return length;
	}

}
