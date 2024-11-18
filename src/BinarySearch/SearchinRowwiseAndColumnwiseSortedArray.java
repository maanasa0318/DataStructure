package BinarySearch;

public class SearchinRowwiseAndColumnwiseSortedArray {

	public static void main(String[] args) {
                      ///// This is J
		int[][]arr = { {10,20,30,40} , //
				       {12,25,35,45} , // this is i (downward)
				       {27,29,37,45},
				       {32,33,39,50}
				      };
		int search = 29;
		
		int rows = arr.length;
        int columns = arr[0].length; // Assuming all rows have the same length

        System.out.println("Rows: " + rows);
        System.out.println("Columns: " + columns);
	        
		int dimension= 4;
		int index = findElement(arr, search, dimension);
		//System.out.println("index is at "+index);
	}

	private static int findElement(int[][] arr, int search, int dimension) {
		int i = 0;
		int j = dimension-1;
		
		while( i >=0 && i < dimension
				&& j >=0 && j < dimension) {
			
			if(arr[i][j] == search) {
				System.out.println("Elme is at index is at "+i+ " and " +j);
				return arr[i][j];
			}
			// our search key is less then the arr[i][j] so do j--
			else if( arr[i][j] > search) {
				j --;
			}
			else if( arr[i][j] < search) {
				i ++;
			}
		}
		
		return 0;
	}

}
