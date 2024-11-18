package BinarySearch;

//smallest element less then search
public class FindFloorElementSortedArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,8,10,20,30};
		int floorSearch = 5;
		
		int res = findFloorInBS(arr, floorSearch);
		int celei = findCeli(arr, floorSearch);
		System.out.println("Floor element is " + res);
		System.out.println("celi element is " + celei);

	}

	private static int findCeli(int[] arr, int search) {
		int left = 0;
		int right= arr.length -1;
		int res = -1;

		while(left <= right) {
			int mid = left + ((right-left)/2);
			
			if(arr[mid] == search) {
				return arr[mid];
			}
			else if ( arr[mid] > search) {
				res = arr[mid];
				right = mid -1;
			}
			else if ( arr[mid] < search) {
				left = mid + 1;
			}

		}
		return res;
	}

	private static int findFloorInBS(int[] arr, int search) {
		int left = 0;
		int right= arr.length -1;
		int res = -1;

		while(left <= right) {
			int mid = left + ((right-left)/2);
			
			if(arr[mid] == search) {
				return arr[mid];
			}
			else if ( arr[mid] > search) {
				right = mid -1;
			}
			else if ( arr[mid] < search) {
				res = arr[mid];
				left = mid + 1;
			}

		}
		return res;
	}

}
