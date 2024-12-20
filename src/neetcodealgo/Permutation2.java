package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

	public static void main(String[] args) {

		int[] nums= new int[] {1,2,3};
		List<List<Integer>> res = printallPermutation(nums);
		System.out.println(res);
	}

	private static List<List<Integer>> printallPermutation(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<Integer>();
		boolean freq[] = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums,ans,ds, freq);
		return ans;
	}

	private static void dfs(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
		if(ds.size() == nums.length && !ans.contains(ds)) {
			ans.add(new ArrayList<Integer>(ds));
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(freq[i]) {
				continue;
			}
			
			freq[i] = true;
			ds.add(nums[i]);
			
			dfs(nums,ans,ds, freq);
			freq[i] = false;
			ds.remove(ds.size()-1);
			
		}
		
	}

}
