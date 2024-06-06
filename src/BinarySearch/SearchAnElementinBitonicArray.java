package BinarySearch;

public class SearchAnElementinBitonicArray {

	// same as Bitonic Array
	public static void main(String[] args) {

		int[] arr = { 1,3,8,12,4,2};
		int search = 8;
		int peekIndex = findPeek(arr);
		System.out.println("Peek elem is " + peekIndex);
		int  bs1 = binarySearch(0, peekIndex-1, arr, search);
		int  bs2 = binarySearchReverseSortedArray(peekIndex, arr.length-1, arr, search);
		if(bs1 != -1) {
			System.out.println("Elemnt is at index bs1 "+ bs1);
		}else {
			System.out.println("Elemnt is at index bs2 "+ bs2);

		}

	}

	private static int findPeek(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && mid < arr.length - 1) {
				if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
					return mid;
				} else if (arr[mid - 1] > arr[mid]) {
					end = mid - 1;
				} else if (arr[mid + 1] > arr[mid]) {
					start = mid + 1;
				}
			}
			if (mid == 0) {
				if (arr[mid] > arr[mid + 1]) {
					return mid;
				} else {
					return arr[mid + 1];
				}
			}
			if (mid == arr.length - 1) {
				if (arr[mid] > arr[mid - 1]) {
					return mid;
				} else {
					return mid - 1;
				}
			}
		}
		return 0;
	}

	private static int binarySearch(int l, int h, int[] arr, int search) {
		
		while (l <= h) {
			int middle = l + (h - l) / 2;

			if (arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return middle;
			} else if (arr[middle] > search) {
				// shift height
				h = middle - 1;
			} else if (arr[middle] < search) {
				// shift low
				l = middle + 1;
			}
			System.out.println("loop done once");
		}
		return -1;
	}

	private static int binarySearchReverseSortedArray(int start, int end, int[] arr, int search) {

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (arr[middle] == search) {
				return middle;
			} else if (arr[middle] > search) {
				start = middle + 1;
			} else if (arr[middle] < search) {
				end = middle - 1;
			}
			System.out.println("loop done once");

		}
		return -1;

	}

}
