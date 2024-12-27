package neetcodealgo;

public class JumpGame {

	public static void main(String[] args) {

		int[] nums ={1,2,0,1,0};
		boolean res = canJump(nums);
		System.out.println(res);
	}

	private static boolean canJump(int[] nums) {
		int goal = nums.length -1;
		for(int i = nums.length-2; i >=0; i--) {
			if( i + nums[i] >= goal) {
				goal = i;
			}
		}
		return goal ==0;
	}

}
