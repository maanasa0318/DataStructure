package neetcodealgo;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
		
	}
	
	private static int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<Integer>();
       int longest =0;
       
       for(int i=0; i<nums.length; i++) {
		   set.add(nums[i]);
       }
       
       for (int i : set) {
    	   // check if i -1 is a start of sequence
    	   if(!set.contains(i-1)) {
    	       int length =1;
    		   while(set.contains(i+length)) {
    			   length++;
    		   }
    		   longest = Math.max(longest, length);
    	   }
       }
      

       return longest;
    }

}
