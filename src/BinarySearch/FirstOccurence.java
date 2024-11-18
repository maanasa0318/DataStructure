package BinarySearch;

public class FirstOccurence {

	public static void main(String[] args) {

		int[] arr =  {3,6,8,10,25,31,31,31,31,31,36,47,53,55,62};
		int search = 31;
		searchRange(arr, search);

	}
	
	private static int[] searchRange(int[] nums, int target) {
		int resIndex = firstOccurence(nums, target);
		int lastOccu = LastOccurence(nums, target);
		System.out.println(nums +" first occurence present at index "+resIndex + " last occ " +lastOccu);
		int[] res = {resIndex, lastOccu};
		
		return res;
	 }

	private static int LastOccurence(int[] arr, int search) {
		int left =0;
		int right = arr.length -1;
		int res = -1;
		
		while(left <= right) {
			int mid = left +((right - left)/2);
			
			if(arr[mid] == search) {
				res = mid;
				left = mid +1;	
			}
			
			else if(arr[mid] > search) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return res;
	}

	private static int firstOccurence(int[] arr, int search) {
		int left =0;
		int right = arr.length -1;
		int res = -1;
		
		while(left <= right) {
			int mid = left +((right - left)/2);
			
			if(arr[mid] == search) {
				res = mid;
				right = mid -1;	
			}
			
			else if(arr[mid] > search) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return res;
	}

}
