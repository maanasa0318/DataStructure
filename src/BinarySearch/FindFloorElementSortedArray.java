package BinarySearch;

//smallest element less then search
public class FindFloorElementSortedArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,8,10,20,30};
		int floorSearch = 5;
		
		int res = findFloorInBS(arr, floorSearch);
		System.out.println("Floor element is " + res);
		
	}

	private static int findFloorInBS(int[] arr, int search) {
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
				h = middle - 1;
			}
			else if(arr[middle] < search) {
				//shift low
				res = arr[middle];
				l = middle + 1;
			}
			System.out.println("loop done once");
		}
		return res;
	}

}
