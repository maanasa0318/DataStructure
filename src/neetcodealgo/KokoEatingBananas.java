package neetcodealgo;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {

		int[] piles = {3,6,7,11};
		int h = 8;
		int res = minEatingSpeed(piles,  h);
		System.out.println(res);
	}

	private static int minEatingSpeed(int[] piles, int h) {

		int left = 0;
		int right = Arrays.stream(piles).max().getAsInt();
		int result = right;
		
		while( left <= right) {
			int mid = left + ((right - left)/ 2);
			
			long time =0;
			for( int i : piles) {
				time += Math.ceil((double)i/mid);
			}
			
			if(time <= h) {
				result = mid;
				right = mid -1;
			}
			else {
				left = mid + 1;
			}
		}
		return result;
	}


}
