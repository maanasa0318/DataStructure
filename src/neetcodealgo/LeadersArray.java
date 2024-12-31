package neetcodealgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersArray {

	public static void main(String[] args) {

		 int[] nums = {1, 2, 5, 3, 1, 2};
		 List<Integer> ans = leader(nums);
		 System.out.println(ans);
	}

	private static List<Integer> leader(int[] nums) {
		int prev = nums[nums.length-1];
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(prev);
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] > prev){
                ls.add(nums[i]);
            }
            prev = nums[i];
        }

        Collections.reverse(ls);
        return ls;
	}

}
