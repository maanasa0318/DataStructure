package swapsort;

import java.util.Arrays;
import java.util.HashMap;

public class TwoIntegerSum {

	public static void main(String[] args) {

		int[] nums = {3,4,5,6};
		int target = 10;
		// two pass
		//o(n) time and space
		int[] res= twoSum(nums,target);
		System.out.println(Arrays.toString(res));
		int [] onepass = onepass(nums, target);
		System.out.println(Arrays.toString(onepass));
	}

	private static int[] onepass(int[] nums, int target) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int diff = target - nums[i];
			
			if(hmap.containsKey(diff)) {
				return new int [] {hmap.get(diff), i};
			}
			else {
				hmap.put(nums[i], i);
			}

		}
		return new int[] {};
	}

	private static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			hmap.put(nums[i], i);
			// value, index
		}
		for(int i=0; i<nums.length; i++) {
			int diff = target - nums[i];
			if(hmap.containsKey(diff) && hmap.get(diff) != i) {
				return new int [] {i, hmap.get(diff)};
			}	
		}
		return new int[] {};
	}

}
