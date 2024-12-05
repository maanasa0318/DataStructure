package neetcodealgo;

import java.util.Arrays;

public class ProductsofArrayExceptSelf {

	public static void main(String[] args) {

		int[] nums = {1,2,4,6};
		int[] res = porductSum(nums);
		System.out.println(Arrays.toString(res));
	}

	private static int[] porductSum(int[] nums) {
		int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n];
        int[] suff = new int[n];

        pre[0] = 1;
        suff[n-1] = 1;

        for(int i=1; i< n; i++){
            pre[i] = nums[i-1] * pre[i-1];
        }
        for(int i=n -2; i >=0; i--){
            suff[i] = nums[i +1]*suff[i+1];

        }
        for(int i=0; i<n; i++){
            res[i] = pre[i] * suff[i];
        }
        return res;
	}

}
