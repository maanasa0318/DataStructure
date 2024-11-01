package swapsort;

import java.util.HashSet;

public class DuplicateNumber {

	public static void main(String[] args) {

		int[] nums = {1,3,4,2,2};
		System.out.println(hasDuplicate(nums));
	}

	private static int hasDuplicate(int[] nums) {
		HashSet<Integer> hset = new HashSet<>();
		int dupliacteNumber= 0; 
		for(int i=0; i<nums.length; i++) {
			if(!hset.contains(nums[i])) {
				hset.add(nums[i]);
			}
			else {
				dupliacteNumber = nums[i];
				return dupliacteNumber;
			}
		}
		return dupliacteNumber;
	}

}
