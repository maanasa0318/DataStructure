package neetcodealgo;

public class GuessNumberHigherorLower {

	public static void main(String[] args) {
		int res = guessNumber(10);
		System.out.println(res);
		
	}
	
	/** 
	 * Forward declaration of guess API.
	 * @param  num   your guess
	 * @return 	     -1 if num is higher than the picked number
	 *			      1 if num is lower than the picked number
	 *               otherwise return 0
	 * int guess(int num);
	 */
	private static int guessNumber(int n) {
		int low =0;
		int high = n;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if(guess(mid) == -1) {
				low = mid + 1;
			}
			else if (guess(mid) == 1) {
				high = mid -1;
			}
			else if (guess(mid) == 0) {
				return mid;
			}
		}
		
		return -1;
        
    }
	
	private static int guess(int n) {
		 if (n > 10) {
		        return 1;
		    } else if (n < 10) {
		        return -1;
		    } else {
		        return 0;
		    }
	}

	

}
