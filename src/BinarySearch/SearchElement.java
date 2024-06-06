package BinarySearch;

public class SearchElement {

	public static void main(String[] args) {

		int[] arr =  {3,6,8,10,25,29,31,36,47,53,55,62};
		int search = 55;
		
		binarySearch(arr,search);
 	}

	private static void binarySearch(int[] arr, int search) {
		int l = 0;
		int h = arr.length -1;

		
		while(l <= h) {
			int middle = l + (h-l)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				break;
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
		
	}

}
