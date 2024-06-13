package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*SEARCH IN A NEARLY SORTED ARRAY:

Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e.,
arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

Example :
Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2 
Output is index of 40 in given array*/
public class SearchInNearlyuSortedArray {

	public static void main(String[] args) {
		
		Integer[] arr1 = {3,7,10,1,6,5};
		List<Integer> mylist = Arrays.asList(arr1);
		Collections.sort(mylist);
		System.out.println(mylist);

		int[] arr = {5,10,30,20,40};
		int search = 20;
		
		int res = serachInNearlySortedArray(arr, search);
		System.out.println("Element is at index " + res);

	}

	private static int serachInNearlySortedArray(int[] arr, int search) {
		int start = 0;
		int end = arr.length -1;
		
		while (start<= end) {
			int mid = start +(end - start)/2;
			
			if(arr[mid] == search) {
				return mid;
			}
			if(mid+1 >= start && arr[mid+1] == search ) {
				return mid+1;

			}
			if(mid+1 <= end && arr[mid -1] == search) {
				return mid-11;
			}
			else if(arr[mid] <= search) {
				end = mid -2;
			}
			else {
				start = mid + 2;
			}
		}
		return 0;
	}

}
