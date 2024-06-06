package BinarySearch;

public class IndexofFirst1BinarySortedInfiniteArray {

	public static void main(String[] args) {
		int[] arr = { 0,0,1,1,1,1,1,1,1,1 };
		int search = 1;
		int res = searchInInfinitArr(arr, search);
		System.out.println("element is " + res);

	}

	private static int searchInInfinitArr(int[] arr, int search) {
		int start = 0;
		int end = 1;
		while (search >= end) {
			start = end;
			end = end * 2;
		}
		int res = firstOccurence( arr, search, start, end);
		return res; 
	}
	
	private static int firstOccurence(int[] arr, int search, int start2, int end2) {
		int start = 0;
		int end = arr.length-1;
		int res = -1;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] == search) {
				res = mid;
				end = mid - 1;
			}
			else if (arr[mid] > search) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}	
		}
		return res;
	}
}