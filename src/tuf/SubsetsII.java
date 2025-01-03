package tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> result = subsetsWithDup(nums);
		        
        System.out.println("Subset sums are: " + result);

	}

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> subset = new ArrayList<>();
    	Arrays.sort(nums);
    	dfs(res, subset, 0, nums);
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> subset, int i, int[] nums) {

		if(i == nums.length) {
			res.add(new ArrayList<>(subset));
			return;
		}
		
		subset.add(nums[i]);
    	dfs(res, subset, i+1, nums);
    	subset.remove(subset.size()-1);
    	for(int j=i+1; j<nums.length; j++) {
    		if(nums[j] != nums[i]) {
            	dfs(res, subset, j, nums);
            	return;
    		}
    	}
    	dfs(res, subset, nums.length, nums);
	
	}

}
