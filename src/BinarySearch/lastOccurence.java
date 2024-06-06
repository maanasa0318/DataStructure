package BinarySearch;

public class lastOccurence {

	public static void main(String[] args) {
		int[] arr = { 3, 6, 8, 10, 25, 31, 31, 31, 31, 31, 36, 47, 53, 55, 62 };
		int search = 31;
		int resIndex = lastOccur(arr, search);
		System.out.println(search + " first occurence present at index " + resIndex);
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
			}
			else if(arr[mid] > search) {
				end = mid -1;
			}else {
				start = mid + 1;
			}

		}
		return res;
	}
}
