package varaiableSizeSlidingWindow;

public class SubarraySumEqualsK {

	public static void main(String[] args) {

		int[] nums = {-1, -1, 1};
		int k = 0;
		int result = subarraySum(nums, k);
		System.out.println("Sub array is:" + result);
	}

	private static int subarraySum(int[] nums, int k) {

		int i = 0;
		int j = 0;
		int sum = 0;
		int count = 0;

			while (j < nums.length) {
				// condition
				sum = sum + nums[j];

				if (sum < k) {
					j++;
				} else if (sum == k) {
					count = count + 1;
					sum = sum - nums[i];
					i++;
					j++;
				} else if (sum > k) {
					while (sum > k) {
						sum = sum - nums[i];
						if (sum > 0 && sum == k) {
							count = count + 1;
						}
						i++;
					}
					j++;
				}

			}
		
		return count;
	}

}
