package varaiableSizeSlidingWindow;

public class LongestEvenOddSubarrayWithThreshold {

	public static void main(String[] args) {

		int[] nums = {2,3,4,5};
		int threshold = 5;
		int result = longestAlternatingSubarray( nums, threshold);
		System.out.println(result);
	}

	private static int longestAlternatingSubarray(int[] nums, int threshold) {
		int ans =0;
		
		for(int j=0; j < nums.length; j++) {
			
			if (nums[j] % 2 == 0 && nums[j] <= threshold) {
				int e = j+1;
				while (e < nums.length && nums[e] <= threshold && nums[e] % 2 != nums[e - 1] % 2 ) {
					e++;
				}
				ans = Math.max(ans, e-j);
			
			}
		}
		return ans;
	}

}
