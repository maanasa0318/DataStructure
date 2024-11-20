package array;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int []nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		
		merge(nums1, m,  nums2, n);
		
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {
	
		int lastIndex = m +n -1;
		while(m > 0 && n >0) {
			if(nums1[m -1] > nums2[n-1]) {
				nums1[lastIndex]=nums1[m -1];
				m = m-1;
			}else {
				nums1[lastIndex]=nums2[n -1];
				n = n-1;
			}
			lastIndex = lastIndex -1;
		}
		
		while(n >0) {
			nums1[lastIndex]=nums2[n -1];
			n = n-1;
			lastIndex = lastIndex -1;
		}
		
		System.out.println(Arrays.toString(nums1));
	}

}
