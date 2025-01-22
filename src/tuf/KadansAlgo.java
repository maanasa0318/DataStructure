package tuf;

public class KadansAlgo {

	public static void main(String[] args) {

		int[] nums = new int[] {2,3,5,-2,7, -4};
		int res = maxSum(nums);
		System.out.println(res);
		int res1 = betterMaxSum(nums);
		System.out.println(res1);
		int res2 = kadaAlgo(nums);
		System.out.println(res2);
		int res3 = printKada(nums);
		System.out.println(res3);
	}

	private static int printKada(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum =0;
		int start = 0;
		int ansStart = -1;
		int ansEnd = -1;
		
		for(int i=0; i<nums.length; i++) {
			if(sum == 0) {
				start = i;
			}
			sum += nums[i];
			if(sum > max) {
				max = sum;
				ansStart = start;
				ansEnd = i;
			}
			if(sum < 0) {
				sum =0;
			}
			
			
		}
		for(int i= ansStart; i<= ansEnd; i++) {
			System.out.println(nums[i]);
		}
		return max;
	}	

	private static int kadaAlgo(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum =0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			
			if(sum > max) {
				max = sum;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	private static int betterMaxSum(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			int sum = 0;
			
			for(int j=i; j<nums.length; j++) {
				sum += nums[j];
				max = Math.max(max, sum);
				
			}
		}
		return max;
	}

	private static int maxSum(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length; j++) {
				int sum =0;

				for(int k=i; k<=j; k++) {
					sum += nums[k];
				}
				
				max = Math.max(max, sum);
			}
		}
		return max;
	}

}
