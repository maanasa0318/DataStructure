package BinarySearch;

public class SingleElementSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		int res = singleNonDuplicate(nums);
		System.out.println(res);
	}

	private static int singleNonDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		
		while(left < right) {
			int mid = left + ((right - left)/2);
			
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
            {
				left = mid +1;
			}
			else {
				right = mid;
			}
				
		}
		return nums[left];
	}
	
}
