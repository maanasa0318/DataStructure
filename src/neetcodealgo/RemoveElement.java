package neetcodealgo;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {

		int[] nums = {3,2,2,3};
		int val = 3;
		int res = removeElement(nums,  val);
		System.out.println(res);
		
	}

	private static int removeElement(int[] nums, int val) {
		int j =0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				//remove nums[i]
				nums[j] = nums[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return j;
    
	}

}
