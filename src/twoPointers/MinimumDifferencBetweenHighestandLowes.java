package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifferencBetweenHighestandLowes {

	public static void main(String[] args) {

		int[] nums = {9918, 21297, 44530, 61094, 87063, 93551, 95857};
		int k = 2;
		int res = minimumDifference(nums, k);
		System.out.println(res);
		
	}
	
	private static int minimumDifference(int[] nums, int k) {
		int l = 0;
		int r = k-1;
		int min = Integer.MAX_VALUE;
		Arrays.sort(nums);
		
		while(r < nums.length) {
			min = Math.min(min, nums[r] - nums[l]);
			l++;
			r++;
		}
		return min;
		
	}

		

}
