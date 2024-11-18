package string;

public class ValidPerfectSquare {

	public static void main(String[] args) {

		boolean res = validSq(9);
		System.out.println(res);
		System.out.println(bs(14));
	}

	private static boolean bs(int i) {
		int left = 1;
		int right = i;
		
		while(left <= right) {
			int mid = left + ((right - left)/2);
			if(mid * mid == i) {
				return true;
			}
			if(mid * mid > i) {
				right = mid -1;
			}
			if(mid * mid < i) {
				left = mid + 1;
			}
			
		}
		return false;
	}

	private static boolean validSq(int i) {

		if(i >0) {
			long res = (long)Math.sqrt(i);
			
			return(res * res == i);
		}
		return false;
	}

}
