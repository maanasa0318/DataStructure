package neetcodealgo;

import java.util.Arrays;

public class insertionSort {

	public static void main(String[] args) {

		int[] arr = {2, 3, 4, 1, 6};
		
		int[] res = insertionSort(arr);
		System.out.println(Arrays.toString(res));
	}

	private static int[] insertionSort(int[] arr) {
 
		for(int i=1; i<arr.length; i++) {
			int j = i-1;
			while (j >=0 && arr[j + 1] < arr[j]) {
				//swap
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
				j = j - 1;				
			}
		}
		return arr;
	}

}
