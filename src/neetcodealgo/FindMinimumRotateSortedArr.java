package neetcodealgo;

public class FindMinimumRotateSortedArr {

	//TODO This answer goes to time out  need to check better logic  
	public static void main(String[] args) {

		int[] nums = { 3, 1, 2 };
		int res = findMinInRotatedArray(nums);
		System.out.println(res);
	}

	private static int findMinInRotatedArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int n = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			int previous = (mid - 1 + n) % n;
			int next = (mid + 1) % n;

			if (arr[mid] < arr[previous] && arr[mid] < arr[next])
			{
				return mid;
			}

			if (arr[mid] > arr[start] && arr[mid] > arr[end]) { 
				start = mid + 1;
			}
			if( arr[mid] < arr[start] && arr[mid] > arr[end]) {
				end = mid -1;
			}

		}
		return -1;
	}

}
