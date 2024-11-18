package BinarySearch;

public class FindMinimumRotatedSortedArray {

	public static void main(String[] args) {

		int[] nums = {3,4,5,1,2};
		int min = rotatedSortedArray(nums);
		System.out.println(min);
	}

	// O(log n)
	private static int rotatedSortedArray(int[] nums) {
		int left =0;
		int right = nums.length -1;
		int result = Integer.MAX_VALUE;
		
		while(left < right) {
			if(nums[left] < nums[right]) {
				result = Math.min(nums[left], result);
				break;
			}
			
			int mid = left + ((right - left)/2);
			if(nums[mid] >= nums[left]) {
				//arr is sorted move right
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return result;
	}

}
