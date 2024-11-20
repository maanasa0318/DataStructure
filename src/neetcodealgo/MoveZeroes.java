package neetcodealgo;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {

		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
	}

	private static void moveZeroes(int[] nums) {
		//quick sort
		int left =0;
		int right =0;
		
		while( right < nums.length) {
		//for(int right =0; right <nums.length; right++) {
			if(nums[right] != 0) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
			}
			right++;

		}

        
        System.out.println(Arrays.toString(nums));
	}

}
