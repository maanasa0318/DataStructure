package tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {

		// Example input
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		// Get the combinations
		List<List<Integer>> result = combinationSum2(candidates, target);
		// Print the result
		for (List<Integer> combination : result) {
			System.out.println(combination);
		}

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, res, subset, 0);
		return res;
	}

	public static void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> subset,
			int index) {
		if (target == 0) {
			res.add(new ArrayList<>(subset));
			return;
		}
		if (target < 0 || index >= candidates.length) {
			return;
		}
		for(int j=index; j<candidates.length; j++) {
			if(j > index && candidates[j] == candidates[j-1]) {
				continue;
			}
			subset.add(candidates[j]);
			backtrack(candidates, target-candidates[j], res, subset, j + 1);
			subset.remove(subset.size() - 1);
		}
		

	}

}
