package BinarySearch;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {

		int[] nums = {5, 1,3 };
		int target = 5;
		int res = serachBS(nums, target);
		System.out.println(res);
	}

	private static int serachBS(int[] nums, int target) {

		 int l = 0;
	        int r = nums.length - 1;

	        while(l <= r) {

	            int mid = (l + r) / 2;

	            if (nums[mid] == target) {
	                return mid;
	            }

	            if (nums[l] <= nums[mid]) {
	                if (target > nums[mid] || target < nums[l]) {
	                    l = mid + 1;
	                } else {
	                    r = mid - 1;
	                }
	            } else {
	                if (target < nums[mid] || target > nums [r]) {
	                    r = mid - 1;
	                } else {
	                    l = mid + 1;
	                }
	            }

	        }

	        return -1;
	}
}
