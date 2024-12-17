package neetcodealgo;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {

		int[] nums1 = {1,2}, nums2 = {3};
		double res = median(nums1, nums2);
		System.out.println(res);
		
	}

	private static double median(int[] nums1, int[] nums2) {
		int[] A = nums1;
		int[] B = nums2;
		int total = A.length + B.length;
		int half = (total +1)/ 2;
		
		//swap
		if(B.length < A.length){
			int[] temp = A;
			A = B;
			B = temp;
		}
		
		int l=0;
		int r = A.length;
		
		while(l<=r) {
			
			int i=(l+r) /2;
			int j = half - i;
			
			int Aleft = i> 0 ? A[i -1] : Integer.MIN_VALUE;
			int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
			int Bleft = j >0 ? B[j -1] : Integer.MIN_VALUE;
			int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;
			
			if(Aleft <= Bright && Bleft <= Aright) {
				if(total % 2 != 0) {
					return Math.max(Aleft, Bleft);
				}
			
				else if(Aleft > Bright) {
					r = i -1;
				}
				else if(Aleft < Bright) {
					l = i +1;
				}
				return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
			}
		}
		
		
		
		return -1;
	}

}

