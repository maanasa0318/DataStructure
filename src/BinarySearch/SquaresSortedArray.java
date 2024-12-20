package BinarySearch;

import java.util.Arrays;

public class SquaresSortedArray {

	public static void main(String[] args) {

		int[] nums = {-4,-1,0,3,10};
		int[] ans = sortedSquares(nums);
		System.out.println(Arrays.toString(ans));
	}
	
	private static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i] * nums[i]);
            ans[i]=nums[i] * nums[i];
        }
        Arrays.sort(ans);
		return ans;
    }

}
