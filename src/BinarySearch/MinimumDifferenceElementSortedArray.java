package BinarySearch;

public class MinimumDifferenceElementSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,3,8,10,15};
		int key = 12;
		int res = findMinDiffElemt(arr, key);
		System.out.println("Min diff element is " + res);

	}

	private static int findMinDiffElemt(int[] arr, int search) {
		int l = 0;
		int h = arr.length -1;

		while(l <= h) {
			int middle = l + (h-l)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return arr[middle];
			}
			else if (arr[middle] > search) {
				// shift height
				h = middle - 1;
			}
			else if(arr[middle] < search) {
				//shift low
				l = middle + 1;
			}
			System.out.println("loop done once");
		}
		int lowVal = Math.abs(arr[l]- search);
		int highVal = Math.abs(arr[h]- search);
		
		if(lowVal < highVal) {
			return arr[l];
		}
		else {
			return arr[h];
		}
	}

}
