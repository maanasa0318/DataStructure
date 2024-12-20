package neetcodealgo;

public class WordSearch {

	static int ROWS;
	static int COLS;
	static boolean[][] visited;
	
	public static void main(String[] args) {

		char[][] board = {{'A','B','C','D'},
						{'S','A','A','T'},
						{'A','C','A','E'}};
		String word = "CAT";
		boolean res = exist(board,word);
		System.out.println(res);
		
	}
	
	 public static boolean exist(char[][] board, String word) {
		 ROWS = board.length;
	        COLS = board[0].length;
	        visited = new boolean[ROWS][COLS];

	        for (int r = 0; r < ROWS; r++) {
	            for (int c = 0; c < COLS; c++) {
	                if (dfs(board, word, r, c, 0)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	        
	 }

	private static boolean dfs(char[][] board, String word, int r, int c, int i) {
		if(i == word.length()) {
			return true;
		}
		if(r < 0 || c < 0 || r >= ROWS || c >=COLS || visited[r][c] || board[r][c] != word.charAt(i)) {
			return false;
		}
		visited[r][c] = true;
		boolean res =  dfs(board, word, r+1, c, i+1) ||
					   dfs(board, word, r-1, c, i+1) || 
					   dfs(board, word, r, c+1, i+1) || 
					   dfs(board, word, r, c-1, i+1);
		visited[r][c] = false;
		return res;
	}
	

}
