package neetcodealgo;

public class FirstBadVersion {

	public static void main(String[] args) {

		 int[] nums = {1,2,3,4,5}; 
		 int badversion = 4;
		 int res = badVersion(nums.length);
		 System.out.println(res);
	}

	private static int badVersion(int n) {
		int low =0;
		int high = n;
		int badversion = -1;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if(isBadVersion(mid)) {
				badversion = mid;
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
			
		}
		
		return badversion;
	}

	private static boolean isBadVersion(int mid) {
		if(mid == 4 || mid == 5) {
			return true;
		}
		return false;
	}

	

}
