package tuf;

import java.util.HashMap;

public class LongestsubarraywithsumK {

	public static void main(String[] args) {

		int[] nums = {1, 2, 1, 2, 1};

		int k=3;
		int len = brute(nums, k);
		System.out.println(len);
		int len1 = better(nums, k);
		System.out.println(len);
		int len2 = best(nums, k);
		System.out.println(len2);
		int len3 = twoPointer(nums, k);
		System.out.println(len3);
	}

	private static int twoPointer(int[] nums, int k) {
		int left =0;
		int right = 0;
		int sum =nums[0];
		int longSeq = 0;
		while(right < nums.length) {
			while( left <= right && sum > k) {
				sum -= nums[left];
				left++;
			}
			if(sum == k) {
				longSeq = Math.max(longSeq, right - left + 1);
			}
			right ++;
			if(right < nums.length) {
				sum += nums[right];
			}
		}
		return longSeq;
	}

	private static int best(int[] nums, int k) {
		int n = nums.length;
	    HashMap<Integer, Integer> map = new HashMap<>();
	    int sum = 0;
	    int longSe = 0;

	    for (int i = 0; i < n; i++) {
	        sum += nums[i];

	        // Check if the current sum equals k
	        if (sum == k) {
	            longSe = Math.max(longSe, i + 1);
	        }

	        int rem = sum - k;  // Calculate the required sum to find in the map

	        // Check if there is a prefix with the required sum
	        if (map.containsKey(rem)) {
	            // Update the longest subarray length found
	            int len = i - map.get(rem);
	            longSe = Math.max(longSe, len);
	        }

	        // Store the current sum with index only if it is not already stored
	        if (!map.containsKey(sum)) {
	            map.put(sum, i);
	        }
	    }
	    return longSe;
	}

	private static int better(int[] nums, int k) {
		int longSeq = 0;
		int n = nums.length;
		int sum =0;
		for(int i=0; i<n; i++) {
			 
			for(int j=i; j<n; j++) {
				sum += nums[j];
				
				longSeq = Math.max(longSeq, j - i + 1);

			}
			
		}
		return longSeq;
	}

	private static int brute(int[] nums, int k) {
		int longSeq = 0;
		int n = nums.length;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				
				int sum =0;
				for(int  m=i; m<=j; m++) {
					sum += nums[m];
				}
				
				if(sum == k) {
					longSeq = Math.max(longSeq, j-i+1);
				}
			}
		}
		return longSeq;
	}

}
