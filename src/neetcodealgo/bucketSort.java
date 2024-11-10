package neetcodealgo;

import java.util.Arrays;

public class bucketSort {

	public static void main(String[] args) {

		int[] arr = new int[] {2,1,2,0,0,2};
		arr = bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] bucketSort(int[] arr) {

		// we know we have three value input
		int[] counts = {0, 0, 0};
		
		for(int num : arr) {
			counts[num] += 1; 
		}
		
		System.out.println(Arrays.toString(counts));
		
		// Fill each bucket in the original array
	    int i = 0;
	    for (int n = 0; n < counts.length; n++) {
	        for (int j = 0; j < counts[n]; j++) {
	            arr[i] = n;
	            i++;
	        }
	    }
	    return arr;
	}

}
