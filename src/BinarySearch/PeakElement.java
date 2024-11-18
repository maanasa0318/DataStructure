package BinarySearch;

public class PeakElement {
    // same as Bitonic Array
	public static void main(String[] args) {

		//int[] arr = { 50, 10, 20, 15 };
		int[] arr = {1};
		int res = findPeek(arr);
		System.out.println("Peek elem is " + res);
	}

	private static int findPeek(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			if(arr.length == 1) {
				return 0;
			}
			int mid = start + (end - start) / 2;
			if (mid > 0 && mid < arr.length - 1) {
				if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
					return mid;
				}
				else if( arr[mid -1] > arr[mid]) {
					end = mid -1;
				}
				else if (arr[mid+1] > arr[mid]) {
					start = mid +1;
				}
			}
			if(mid == 0) {
				if(arr[mid] > arr[mid+1]) {
					return mid;
				}
				else {
					start = mid +1;
				}
			}
			if(mid == arr.length-1){
				 if(arr[mid] > arr[mid-1]) {
					return mid;
				 }
				 else {
					 end = mid -1;
				 }
			}
		}
		return start;
	}

}
