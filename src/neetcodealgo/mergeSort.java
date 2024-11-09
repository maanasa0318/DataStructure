package neetcodealgo;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {

		int[] arr = {3,2,4,1,6};
		int[] res = mergeSort(arr, 0, 4);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] mergeSort(int[] arr, int l, int r) {
		 if(l < r) {
			 int m = (l + r)/2;
			 
			 mergeSort(arr, l, m);
			 mergeSort(arr, m+1, r);
			 merge(arr, l, m, r);
		 }
		 return arr;
	}

	private static void merge(int[] arr, int l, int m, int r) {

		// cal length of left and right side
		int length1 = m - l +1;
		int length2 = r - m;
		
		// create two arry to store left and right elemts based on length
		int[] left = new int[length1];
		int[] right = new int[length2];
		
		//copy contents of arr to left and right
		for(int i=0; i< length1; i++) {
			left[i] = arr[l + i];
		}
		
		for(int i=0; i< length2; i++) {
			right[i] = arr[m + 1 + i];
		}
		
		// compare and merge
		
		int i=0; // index of left array
		int j =0; // index of right array
		int k = l; // index of arr[l] i. e 0
		
		while( i < length1 && j < length2) {
			
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		// add remain elemts from left and right
		while(i < length1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < length2) {
			arr[k] = right[j];
			j++;
			k++;
		}

		
	}

}
