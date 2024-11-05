package neetcodealgo;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
		int k = removeDuplicates(nums);
		System.out.println(k);
	}

	private static int removeDuplicates(int[] nums) {
		int left = 1;
		for(int right=1; right<nums.length; right++) {
			if(nums[right] != nums[right -1]) {
				nums[left] = nums[right];
				left++;
			}
		}
		return left;
	}

}
