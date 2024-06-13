package BinarySearch;

public class FindElementInRotatedSortedArray {

	public static void main(String[] args) {
		//int[] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int[] arr = {15,2,5,6,8,11,12};
		int search = 15;
		
		// find number of times array is rotate this gives min element in array
		int indexMin = findMinElementIndex(arr);
		System.out.println("min index is " + indexMin);
		int res = binarySearch(arr, 0, indexMin -1, search);
		int res1 = binarySearch(arr, indexMin, arr.length-1, search);
		if (res != -1) {
			System.out.println("Element is at index " + res);
		}
		else if (res1 != -1) {
			System.out.println("Element is at index " + res1);
		}
		else {
			System.out.println("Element is not present" );
		}
	}

	private static int binarySearch(int[] arr, int start, int end, int search) {
	
		while(start <= end) {
			int middle = start + (end-start)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return middle;
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
		return -1;		
	}

	private static int findMinElementIndex(int[] arr) {
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			int next = (mid + 1)% arr.length;
			int prev = (mid - 1 + arr.length) % arr.length;
			
			if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
				return mid;	
			}
			if (arr[start] <= arr[mid] && arr[mid] >= arr[end]) {
				start = mid + 1;
			}
			if (arr[start] <= arr[mid] && arr[mid] <= arr[end]) {
				end = mid - 1;
			}
		} 
		return -1;
	}

}
