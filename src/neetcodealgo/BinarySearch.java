package neetcodealgo;

public class BinarySearch {

	public static void main(String[] args) {

		 int[] nums = {-1,0,3,5,9,12}; 
		 int target = 9;
		 int res = bs(nums, target);
		 System.out.println(res);
		 
	}

	private static int bs(int[] nums, int target) {
		int left = 0;
		int right = nums.length -1;
		
		while(left <= right) {
			int mid = left + ((right - left)/2);

			if( nums[mid] > target) {
				right = mid -1;
			}
			if(nums[mid] < target) {
				left = mid + 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}

}
