package swapsort;

import java.util.HashSet;

public class DuplicateInteger {

	public static void main(String[] args) {

		int[] nums = {1, 2, 3, 3};
		System.out.println(hasDuplicate(nums));
	}

	private static boolean hasDuplicate(int[] nums) {
		HashSet<Integer> hset = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			if(!hset.contains(nums[i])) {
				hset.add(nums[i]);
			}
			else {
				return true;
			}
		}
		return false;
	}

}
