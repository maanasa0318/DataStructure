package tuf;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

	public static void main(String[] args) {

		 int[] nums = {1, 2, 3};
        List<Integer> result = subsetSums(nums);
	        
        System.out.println("Subset sums are: " + result);
	}

	private static List<Integer> subsetSums(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		dfs(0, 0, ans, nums);
		return ans;
	}

	private static void dfs(int index, int sum, List<Integer> ans, int[] nums) {

		if(index >= nums.length) {
			ans.add(sum);
			return;
		}
		dfs(index+1, sum+nums[index], ans, nums);
		dfs(index+1, sum, ans, nums);
	}
	
}


