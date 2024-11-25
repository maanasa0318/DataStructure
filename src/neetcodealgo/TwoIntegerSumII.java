package neetcodealgo;

import java.util.Arrays;

public class TwoIntegerSumII {

	public static void main(String[] args) {

		int[] nums = {1,3,4,5,7,10,11};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
	}

	private static int[] twoSum(int[] nums, int target) {
		int left=0;
		int right =nums.length-1;
		while( left < right ) {
			int sum = nums[left] + nums[right];
			if(sum > target) {
				right --;
			}
			else if(sum < target) {
				left ++;
			}
			else if(sum == target) {
				return new int[] {left+1, right+1};
			}
		}
		return new int[] {};
	}

}
