package neetcodealgo;

public class Search2DMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 60;
		boolean res = searchMatrixBrutForce( matrix,  target);
		System.out.println(res);
		boolean onpass = searchMatrix(matrix, target);
		System.out.println(onpass);
		
	}

	//O(m * n)
	private static boolean searchMatrixBrutForce(int[][] matrix, int target) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.println(matrix[i][j]);
				if(matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean searchMatrix(int[][] matrix, int target) {
	       int ROWS = matrix.length;
	       int COLUMN = matrix[0].length;
	       
	       int left =0;
	       int right = ROWS * COLUMN -1;
	       
	       while( left <= right) {
	    	   int mid = left + (( right - left)/2);
	    	   int r = mid / COLUMN;
	    	   int c = mid % COLUMN;
	    	   
	    	   if(matrix[r][c] == target) {
	    		   return true;
	    	   }
	    	   else if( target < matrix[r][c]) {
	    		  right = mid -1;
	    	   }
	    	   else if(target > matrix[r][c]) {
	    		   left = mid + 1;
	    	   }
	       }
	       return false;
	    }
	}


