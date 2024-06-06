package BinarySearch;

public class NumberTimeArrRotated {

	public static void main(String[] args) {
		int[] arr = { 11, 12, 15, 18, 2, 5, 6, 8 };
		int res = countTimes(arr);
		System.out.println("Array is rotated " + res + " times");
	}

	private static int countTimes(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % arr.length;
			int prev = (mid - 1 + arr.length) % arr.length;

			if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
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
