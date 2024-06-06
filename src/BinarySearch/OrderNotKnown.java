package BinarySearch;

public class OrderNotKnown {

	public static void main(String[] args) {

		int[] arr = {20,17,15,13,12,10,9,8,4};
		int search = 4;
		int resIndex = OrdeNotKnow(arr, search);
		System.out.println(search +" present at index "+resIndex);

	}

	private static int OrdeNotKnow(int[] arr, int search) {
		if (arr[0] < arr[1]) {
			return asendingOrder( arr,  search);
		}
		if (arr[0] > arr[1]) {
			return decendingOrder( arr,  search);
		}
		return -1;
	}

	private static int decendingOrder(int[] arr, int search) {
		int start = 0;
		int end = arr.length -1;
		while(start <= end) {
			int middle = start + (end-start)/2;
			
			if(arr[middle] == search) {
				return middle;
			}
			else if(arr[middle] > search) {
				start = middle + 1;
			}
			else if(arr[middle] < search) {
				end = middle - 1;
			}
			System.out.println("loop done once");
		}
		return -1;
	}

	private static int asendingOrder(int[] arr, int search) {
		int l = 0;
		int h = arr.length -1;	
		while(l <= h) {
			int middle = l + (h-l)/2;

			if(arr[middle] == search) {
				return middle;
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
		return -1;
	}

}
