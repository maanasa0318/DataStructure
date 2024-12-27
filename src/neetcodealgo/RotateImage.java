package neetcodealgo;

public class RotateImage {

	public static void main(String[] args) {

		int[][]matrix = {
		                 {1,2},
		                 {3,4}
		                 };
		rotate(matrix);
		optimalApproach(matrix);
	}
	
    private static void optimalApproach(int[][] matrix) {
    	int n = matrix.length;
    	for(int i=0; i<n-2; i++) {
    		for(int j= i+1; j<n-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
    		}
    	}
    	 for(int row =0; row <=n-1; row++){
             reverse(matrix,row);
         }
	}

	private static void reverse(int[][] matrix, int row) {

		int n = matrix[row].length;
		int i=0;
		int j=n-1;
		while(i <= j) {
			int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
		}
	}

	public static void rotate(int[][] matrix) {
    	int n = matrix.length;
    	int[][] ans = new int[n][n];
    	for(int i=0;i<n; i++) {
    		for(int j=0; j<n; j++) {
    			ans[j][n -1 -i] = matrix[i][j];
    		}
    	}
    	
    	for(int i=0;i<n; i++) {
    		for(int j=0; j<n; j++) {
    			matrix[i][j] = ans[i][j];
    		}
    	}
    }

}
