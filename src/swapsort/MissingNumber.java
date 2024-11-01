package swapsort;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {

		//int[] nums = {1,2,3,1,5};
		int [] nums = {9,6,4,2,3,5,7,0,1};
		int res = missingNumber(nums);
		System.out.println(res);
	}

	private static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int missing =0;
		int duplicate =0;
		
		for(int i=0; i<nums.length; i++) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[0];
				nums[0] = temp;
				continue;
			}
			System.out.println();
			if(nums[nums[i]-1] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[temp -1] = temp;
			}else {
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != i+1) {
				missing = i+1;
				duplicate = nums[i];
			}
		}
		return missing;
	}
	

}
