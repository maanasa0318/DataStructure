package neetcodealgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
		
		for(int r =0; r<9; r++) {
			for(int c =0; c<9; c++) {
				if(board[r][c] == '.') {
					continue;
				}
				String sqKey = (r/3) +"," +(c/3);
				 
				if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
					cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
					squares.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[r][c])) {
					return false;
				}
				 
				 
				 rows.get(r).add(board[r][c]);
				 cols.get(c).add(board[r][c]);
				 squares.get(sqKey).add(board[r][c]);

			}
			
		}
		
		return true;
	}

}
