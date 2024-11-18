package BinarySearch;

public class Sqrt {

	public static void main(String[] args) {
		int res = mySqrt(7);
		System.out.println(res);
	}
	
	 private static int mySqrt(int x) {
	        
		 long left = 0; 
		 long right = x;
		 int res = 0;
		 while(left <= right) {
			 long mid = left + ((right - left)/2);
			 if (mid * mid > x) {
				 right = mid -1;
			 }
			 if(mid * mid < x) {
				 left = mid +1;
				 res = (int) mid;

			 }
			 if(mid * mid == x) {
				 return (int) mid;
			 }
			 
		 }
		 return res;
	 }
}
