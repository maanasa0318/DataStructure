package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums));
		int[] nums1 = {-45, -45, 0, 0, 2}, nums2 = {-50, -45, 0, 0, 5, 7};
		int[] res = intersectionArray(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}

	private static int longestConsecutive(int[] nums) {
		int longest = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i : set) {
			// check start of seq
			if (!set.contains(i - 1)) {
				int len = 1;
				while (set.contains(i + len)) {
					len++;
				}
				longest = Math.max(len, longest);
			}
		}
		return longest;
	}
	
	public static int[] intersectionArray(int[] nums1, int[] nums2) {
       boolean[] visited = new boolean[nums2.length];
       List<Integer> ls = new ArrayList<>();
       
       for(int i=0; i<nums1.length; i++) {
    	   for(int j=0; j<nums2.length; j++) {
    		   if(nums1[i] == nums2[j] && !visited[j]) {
    			   visited[j] = true;
    			   ls.add(nums1[i]);
                   break;

    		   }
    		   else if (nums2[j] > nums1[i]) 
                   break; 
    	   }
       }
       int index =0;
       int[] res = new int[ls.size()];
       for(int i : ls) {
    	   res[index++] = i;
       }
       return res;
    }

}
