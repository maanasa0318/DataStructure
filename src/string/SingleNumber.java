package string;

import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {

		int[] nums= {3,2,3};
		int res = singleNumber(nums);
		System.out.println(res);
	}

	private static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int left =0;
		int res = 0;
		int right =1;
		
		while(right < nums.length) {
			if(left < nums.length && nums[left] != nums[right]) {
				
				return nums[left];
			}
			
			left += 2;
			right += 2;
			System.out.println();
			
		}
		return nums[nums.length-1];
	}
}
