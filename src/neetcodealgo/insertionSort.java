package neetcodealgo;

import java.util.Arrays;

public class insertionSort {

	public static void main(String[] args) {

		int[] arr = {2, 3, 4, 1, 6};
		int len = arr.length;
		
		int[] res = insertionSort(arr);
		System.out.println(Arrays.toString(res));
	}
	

	// time complexity - o(n^2) space is : o(1)
	 
	private static int[] insertionSort(int[] arr) {
 
		for(int i=0; i<arr.length; i++) {
			int j = i-1;
			while(j >=0 && arr[j+1]< arr[j]) {
				//swap
				int temp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = temp;
				j = j -1;
			}
		}
		return arr;
		
	}

}
