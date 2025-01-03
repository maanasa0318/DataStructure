package tuf;

public class subsequenceswithsumK {

	public static void main(String[] args) {

	        int[] nums1 = {1, 2, 3, 4};
	        int target = 5;
	        System.out.println("Number of subsequences with target sum " + target + ": "
	                +countSubsequenceWithTargetSum(nums1, target));
	}

	
	    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
	        int index =0;
	        return func(index,nums, k);
	    }

	    public static int func(int ind, int[] nums, int sum){
	        if(sum == 0){
	            return 1;
	        }
	        if(sum < 0 || ind == nums.length){
	            return 0;
	        }

	        return func(ind + 1, nums, sum-nums[ind]) + func(ind + 1, nums, sum);
	    }
	}

