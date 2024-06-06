package BinarySearch;

public class CountElement {
	public static void main(String[] args) {

		int[] arr = { 3, 6, 8, 10, 25, 31, 31, 31, 31, 31, 36, 47, 53, 55, 62 };
		int search = 31;
		int firstIndex = firstOccurence(arr, search);
		int lastIndex = lastOccur(arr, search);
		int count = lastIndex - firstIndex + 1;
		System.out.println(search + " first occurence present at index " + count);
	}

	private static int firstOccurence(int[] arr, int search) {
		int start = 0;
		int end = arr.length - 1;
		int res = -1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == search) {
				res = mid;
				end = mid - 1;
			} else if (arr[mid] > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static int lastOccur(int[] arr, int search) {
		int start = 0;
		int end = arr.length - 1;
		int res = -1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (arr[mid] == search) {
				res = mid;
				start = mid + 1;
			} else if (arr[mid] > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return res;
	}
}
