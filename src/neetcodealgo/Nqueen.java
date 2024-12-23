package neetcodealgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nqueen {
	static Set<Integer> col = new HashSet<>();
	static Set<Integer> posDiag = new HashSet<>();
	static Set<Integer> negDiag = new HashSet<>();
	static List<List<String>> res = new ArrayList<>();

	public static void main(String[] args) {
		
		int N = 4;
		List<List<String>> queen = solveNQueens(N);
		int i = 1;
		for (List<String> it : queen) {
			System.out.println("Arrangement " + i);
			for (String s : it) {
				System.out.println(s);
			}
			System.out.println();
			i += 1;
		}
	}

	private static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		dfs(0, board, n);
		return res;
	}

	private static void dfs(int r, char[][] board, int n) {
		if (r == board.length) {
			List<String> copy = new ArrayList<String>();
			for (char[] row : board) {
				copy.add(new String(row));
			}
			res.add(copy);
			return;
		}
		for (int c = 0; c < n; c++) {
			if (col.contains(c) || posDiag.contains(c) || negDiag.contains(c)) {
				continue;
			}

			col.add(c);
			posDiag.add(r + c);
			negDiag.add(r - c);
			board[r][c] = 'Q';

			dfs(r + 1, board, n);

			col.remove(c);
			posDiag.remove(r + c);
			negDiag.remove(r - c);
			board[r][c] = '.';
		}
	}
}
