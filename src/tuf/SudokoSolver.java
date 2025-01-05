package tuf;

public class SudokoSolver {

	public static void main(String[] args) {

		char[][] board = {
	            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
	            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
	            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
	            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
	            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
	            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
	            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
	            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
	            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	        };
	        solveSudoku(board);
	        for (char[] row : board) {
	            for (char c : row) {
	                System.out.print(c + " ");
	            }
	            System.out.println();
	        }
	    }

	private static void solveSudoku(char[][] board) {
		solve(board);
		
	}

	private static boolean solve(char[][] b) {

		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				if(b[r][c] == '.') {
					for(char digit = '1'; digit<='9'; digit++) {
						if(rulesMet(b, r, c, digit)){
							b[r][c] = digit;
							//go to next digit;
							if(solve(b)) {
								return true;
							}
							else {
								b[r][c]= '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean rulesMet(char[][] b, int r, int c, char digit) {
		for(int i=0;i<9; i++) {
			if(b[r][i] == digit || b[i][c] == digit) {
				return false;
			}
		}
		int sqRow = (r /3) * 3;
		int sqCol = (c/3) * 3;
		for(int i=sqRow; i<sqRow + 3; i++) {
			for(int j=sqCol; j<sqCol + 3; j++) {
				if(b[i][j] == digit) {
					return false;
				}
			}
		}
		return true;
	}
}

