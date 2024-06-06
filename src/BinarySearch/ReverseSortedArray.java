package BinarySearch;

public class ReverseSortedArray {

	public static void main(String[] args) {

		int[] arr = {20,17,15,13,12,10,9,8,4};
		int search = 17;
		int elemtIndex = findElement(arr,search);
		System.out.println(search +" present at index "+elemtIndex);
	}

	private static int findElement(int[] arr, int search) {

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

}
