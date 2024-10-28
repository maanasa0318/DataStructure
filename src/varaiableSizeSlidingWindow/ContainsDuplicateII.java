package varaiableSizeSlidingWindow;

import java.util.HashMap;

public class ContainsDuplicateII {

	public static void main(String[] args) {

		int nums[] = {1,0,1,1};
		int k = 2;
	    boolean res = containsNearbyDuplicate(nums, k);
	    System.out.println(res);

	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		boolean result = false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}else {
				int key = map.get(nums[i]);
				if(Math.abs(key - i) <= k || key == i) {
					result = true;
				}else {
					map.put(nums[i], i);
				}
			}
		}
		return result;
	}

}
