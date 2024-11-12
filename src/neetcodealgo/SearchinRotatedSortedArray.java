package neetcodealgo;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {

		int[] nums = {3,4,5,1,2};
		int target = 2;
		int res = findMinInRotatedArray(nums, target);
		System.out.println(res);
		
	}

	private static int findMinInRotatedArray(int[] arr, int target) {

		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				return mid;
			}
			if (arr[start] <= mid) {
				if(target >= arr[start] && target <= arr[mid]) {
					end = mid -1;
				}
				else {
					start = mid + 1;
				}
			}else {
				if(target >= arr[mid] && target <= arr[end]) {
					start = mid +1;
				}
				else {
					end = mid -1;
				}
			}

		} 
		return -1;
	}

}
