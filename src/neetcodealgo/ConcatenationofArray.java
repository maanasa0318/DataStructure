package neetcodealgo;

import java.util.Arrays;

public class ConcatenationofArray {

	public static void main(String[] args) {

		int[] nums = {1,2,1};
		int[] res = getConcatenation( nums);
		System.out.println(Arrays.toString(res));
		
	}

	private static int[] getConcatenation(int[] nums) {
		int[] ans = new int[2 * nums.length];
		for(int i =0; i<nums.length; i++) {
			//ans[i] == nums[i] and ans[i + n] == nums[i]
			ans[i + nums.length] = ans[i] = nums[i];
		}
		return ans;
	}

}
