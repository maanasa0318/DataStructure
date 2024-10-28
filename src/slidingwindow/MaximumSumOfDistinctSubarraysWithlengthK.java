package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithlengthK {

	public static void main(String[] args) {

		// int[] nums = {5,3,3,1,1};
		int[] nums = { 9, 9, 9, 1, 2, 3 };
		int k = 3;
		long ans = maximumSumOfDistinctSubarraysWithlengthK(nums, k);
		System.out.println(ans);
	}

	private static long maximumSumOfDistinctSubarraysWithlengthK(int[] nums, int K) {
		long sum = 0;
		long max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			sum += nums[i];
			if (i >= K - 1) {
				if (map.size() == K)
					max = Math.max(max, sum);

				sum -= nums[i - K + 1];
				map.put(nums[i - K + 1], map.get(nums[i - K + 1]) - 1);

				if (map.get(nums[i - K + 1]) == 0)
					map.remove(nums[i - K + 1]);
			}

		}

		return max;
	}

}
