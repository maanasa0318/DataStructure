package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MonotonicArray {

	public static void main(String[] args) {

		int[] nums = {2,7,11,15};
		int[] res = twoSum(nums, 9);
		System.out.println(Arrays.toString(res));
		
		int[] arr = {0,3,7,2,5,8,4,6,0,1};
		int result = longest(arr);
		System.out.println(result);
		
		System.out.println("disppear numbers");
		int[] nums1= {4,3,2,7,8,2,3,1};
		List<Integer> res1 = notApp(nums1);
		System.out.println(res1);
		List<Integer> res2 = anotherApproach(nums1);
		System.out.println(res2);

	}

	private static List<Integer> anotherApproach(int[] nums) {
		for(int i : nums) {
			int index = Math.abs(i);
			if(nums[index -1] > 0) {
				nums[index -1] *= -1;
			}
			
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				list.add(i +1);
			}
		}
		return list;
	}

	private static List<Integer> notApp(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int i : nums) {
			set.add(i);
		}
		 List<Integer> list = new ArrayList<Integer>();
		 for(int i=1; i<nums.length; i++) {
			 if(!set.contains(i)) {
				 list.add(i);
			 }
		 }
		 return list;
	}

	private static int longest(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for(int i =0; i< arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
		}
		
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			int ele = m.getKey();
			
			//check start of sequ
			if(!map.containsKey(ele -1)) {
				int len = 0;
				while(map.containsKey(ele + len)) {
					len ++;
				}
				max = Math.max(max, len);
			}
		}
		return max;
	}

	private static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			int val = target - nums[i];
			if(map.containsKey(val)) {
				return new int[] {i, map.get(val)};
			}
			else {
				map.put(nums[i], i);
			}
		}
		return new int[] {};
	}

	
}
