package neetcodealgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import varaiableSizeSlidingWindow.ContainsDuplicateII;

public class validSudoku {

	public static void main(String[] args) {
		
		char[][] board = 
						{{'1','2','.','.','3','.','.','.','.'},
						{'4','.','.','5','.','.','.','.','.'},
						{'.','9','8','.','.','.','.','.','3'},
						{'5','.','.','.','6','.','.','.','4'},
						{'.','.','.','8','.','3','.','.','5'},
						{'7','.','.','.','2','.','.','.','6'},
						{'.','.','.','.','.','.','2','.','.'},
						{'.','.','.','4','1','9','.','.','8'},
						{'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println(isValidSudoku(board));
		

	}

	private static boolean isValidSudoku(char[][] board) {
		Map<Integer, Set<Character>> row = new HashMap<>();
		Map<Integer, Set<Character>> col = new HashMap<>();
		Map<String, Set<Character>> sq = new HashMap<>();
		
		for(int r=0; r<9; r++) {
			for(int c =0; c<9; c++) {
				if(board[r][c] == '.') {
					continue;
				}
				String s = (r/3) + "," + (c/3);
				if(row.computeIfAbsent(r, k-> new HashSet<>()).contains(board[r][c]) ||
						col.computeIfAbsent(c, k-> new HashSet<>()).contains(board[r][c]) ||
		                sq.computeIfAbsent(s, k -> new HashSet<>()).contains(board[r][c])){
							return false;
						}
				row.get(r).add(board[r][c]);
				col.get(c).add(board[r][c]);
				sq.get(s).add(board[r][c]);
			}
		}
		return true;
	}

}
