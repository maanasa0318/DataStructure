package neetcodealgo;

import java.util.Arrays;

public class bucketSort {

	public static void main(String[] args) {

		int[] arr = new int[] {2,1,2,0,0,2};
		arr = bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] bucketSort(int[] arr) {

		int[] count = {0,0,0};
		for(int nums : arr) {
			count[nums] += 1;
		}

		System.out.println(Arrays.toString(count));
		
		int i=0;
		for(int j =0; j<count.length; j++) {
			for(int k =0; k < count[j]; k++) {
				arr[i] = j;
				i++;
			}
		}
		return arr;
	}
}
