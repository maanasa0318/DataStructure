package neetcodealgo;

import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {

		int[] list = new int[] {6,2,4,1,3};
		int s = 0;
		int e = list.length -1;
		list = quicksorrt(list, s, e);
		System.out.println(Arrays.toString(list));
	}

	private static int[] quicksorrt(int[] arr, int s, int e) {

		if( e - s + 1 <= 1) {
			return null;
		}
		
		// get pivot and starting index
		int pivot = arr[e];
		int left = s;
		
		// partition arr based on pivot value. Value less then pivot goes left and greater goes right
		for(int i=s; i<e; i++) {
			if(arr[i] < pivot) {
				// swap
				int temp = arr[left];
				arr[left] = arr[i];
				arr[i] = temp;
				left ++;
			}
		}
				
		// reset pivot value
		arr[e] = arr[left];
		arr[left] = pivot;
		
		quicksorrt(arr, s, left - 1);
		quicksorrt(arr, left +1, e);

				
		return arr;
	}

	

}
