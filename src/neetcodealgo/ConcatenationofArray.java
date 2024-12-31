package neetcodealgo;

import java.util.Arrays;

public class ConcatenationofArray {

	public static void main(String[] args) {

		int[] nums = {1,2,1};
		int[] res = getConcatenation( nums);
		System.out.println(Arrays.toString(res));
		int [] nums1 = {17,18,5,4,6,1};
		int [] res1 = replaceElements(nums1);
		System.out.println(Arrays.toString(res1));
	}
	
    public static int[] replaceElements(int[] nums) {
    	int rigthMax = -1;
    	int newMax =0;
    	
    	for(int i=nums.length-1; i>=0; i--) { 
    		 newMax = Math.max(nums[i], rigthMax);
    		 nums[i] = rigthMax;
    		 rigthMax = newMax;
    	}
    	
		return nums;
    	
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
