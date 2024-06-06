package BinarySearch;

public class CeilelementSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,8,10,18,20,30};
		int floorSearch = 9;
		
		int res = findceilElement(arr, floorSearch);
		System.out.println("ceil element is " + res);
		
	}

	private static int findceilElement(int[] arr, int search) {
		int l = 0;
		int h = arr.length -1;
		int res = -1;

		while(l <= h) {
			int middle = l + (h-l)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return middle;
			}
			else if (arr[middle] > search) {
				// shift height
				res = arr[middle];
				h = middle - 1;
			}
			else if(arr[middle] < search) {
				//shift low
				l = middle + 1;
			}
			System.out.println("loop done once");
		}
		return res;
	}
}