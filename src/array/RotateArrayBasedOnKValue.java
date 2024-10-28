package array;

import java.util.Arrays;

public class RotateArrayBasedOnKValue {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5,6,7}; // o/p {5,6,7,1,2,3,4}
		int k = 3;
		int[] res = rotateArray(nums, k);
		System.out.println(Arrays.toString(res));
	}

	private static int[] rotateArray(int[] nums, int k) {
		int n = nums.length;
		// fix out of bound 
		k=k%n;
		// {7,6,5,4,3,2,1} 
		reverseArray(nums, 0, n-1);
	    System.out.println("reverse array is:"+Arrays.toString(nums));

		// {5,6,7,4,3,2,1}
		reverseArray(nums, 0, k-1);
	    System.out.println("rotat1 array is:"+Arrays.toString(nums));
	    
	    //{5,6,7,1,2,3,4}
	    reverseArray(nums, k, n-1);
	    System.out.println("rotat1 array is:"+Arrays.toString(nums));

		
		
		return nums;
	}

	private static void reverseArray(int[] nums, int start, int end) {
		while(start<=end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end --;
		}
	}

}
