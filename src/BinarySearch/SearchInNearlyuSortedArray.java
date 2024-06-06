package BinarySearch;

public class SearchInNearlyuSortedArray {

	public static void main(String[] args) {

		int[] arr = {5,10,30,20,40};
		int search = 20;
		
		int res = serachInNearlySortedArray(arr, search);
		System.out.println("Element is at index " + res);

	}

	private static int serachInNearlySortedArray(int[] arr, int search) {
		int start = 0;
		int end = arr.length -1;
		
		while (start<= end) {
			int mid = start +(end - start)/2;
			
			if(arr[mid] == search) {
				return mid;
			}
			if(mid+1 >= start && arr[mid+1] == search ) {
				return mid+1;

			}
			if(mid+1 <= end && arr[mid -1] == search) {
				return mid-11;
			}
			else if(arr[mid] <= search) {
				end = mid -2;
			}
			else {
				start = mid + 2;
			}
		}
		return 0;
	}

}
