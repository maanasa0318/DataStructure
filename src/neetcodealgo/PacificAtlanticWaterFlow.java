package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pecVisit = new boolean[ROWS][COLS];
        boolean[][] atlVisit = new boolean[ROWS][COLS];
        Queue<int[]> pec = new LinkedList<>();
        Queue<int[]> atl = new LinkedList<>();
        
        for(int r =0; r<ROWS; r++) {
        	pec.add(new int[] {r, 0});
        	atl.add(new int[] {r, COLS-1});
        }
        
        for(int c=0; c<COLS; c++) {
        	pec.add(new int[] {c, 0});
        	atl.add(new int[] {ROWS-1, c});
        }
        
        bfs(atl, atlVisit, heights);
        bfs(pec, pecVisit, heights);

        List<List<Integer>>  res = new ArrayList<>();
        
        for(int r=0; r<ROWS; r++) {
        	for(int c=0; c<COLS; c++) {
        		if(pecVisit[r][c] && atlVisit[r][c]) {
        			res.add(Arrays.asList(r, c));
        		}
        	}
        }
        return res;
    }

	private void bfs(Queue<int[]> q, boolean[][] visit, int[][] heights) {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] node = q.poll();
				int row = node[0];
				int col = node[1];
				visit[row][col]= true;
				for(int[] d : directions) {
					int rc = row + d[0];
					int cc = col + d[1];
					
					if(rc >=0 && cc >= 0 && 
							rc < heights.length && 
							cc < heights[0].length && !visit[rc][cc] && heights[rc][cc] >= heights[row][col]) {
						visit[rc][cc]= true;
						q.add(new int[] {rc, cc});
					}
				}
			}
		}
	}
}
