package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

	public static void main(String[] args) {

		int[] nums = {-1,0,1,2,-1,-4};
		int target =0;
		List<List<Integer>> res = sum3(nums, target);
		System.out.println(res);
	}

	private static List<List<Integer>> sum3(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				break;
			}
			if( i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			
			int left = i+1;
			int right = nums.length -1;
			while( left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				
				if(sum > target) {
					right --;
				}
				else if (sum < target) {
					left ++;
				}
				else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// [-2, -2, 0, 0, 2, 2] for below condition check 
					left ++;
					right --;
					while( left < right && nums[left] == nums[left -1]) {
						left++;
					}
				}
			}
			
			
			
		}
		return res;
	}

}
