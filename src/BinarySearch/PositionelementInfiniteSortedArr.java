package BinarySearch;

public class PositionelementInfiniteSortedArr {

	public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6,7,8,9,10,10,10,11,12};
      int search = 7;
      int res = searchInInfinitArr(arr, search);
	  System.out.println("element is " + res);

	}

	private static int searchInInfinitArr(int[] arr, int search) {
		int start = 0;
		int end = 1;
		while(search >= end) {
			start = end;
			end = end * 2;
		}
		while(start <= end) {
			int middle = start + (end-start)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return arr[middle];
			}
			else if (arr[middle] > search) {
				// shift height
				end = middle - 1;
			}
			else if(arr[middle] < search) {
				//shift low
				start = middle + 1;
			}
			System.out.println("loop done once");
		}
		return 0;
	}

}
