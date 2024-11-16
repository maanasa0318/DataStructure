package BinarySearch;

public class SearchInsertPosition {

	public static void main(String[] args) {

		int[] nums = {1,3,5,6};
		int target = 7;
		int res = bs(nums,target);
		System.out.println(res);
	}

	private static int bs(int[] nums, int target) {

		int left =0;
		int right = nums.length-1;
		
		while(left <= right) {
			int mid = left + ((right - left)/2);
			
			if(nums[mid]==target) {
				return mid; 
			}
			
			if(nums[mid] > target) {
				right = mid -1;
			}
			
			if (nums[mid] < target) {
				left = mid +1;
			}
		}
		return left;
	}

}
