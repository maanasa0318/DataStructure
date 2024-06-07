package slidingwindow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example:

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7] . */
public class Maximumofallsubarrays {

	public static void main(String[] args) {

		int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		List maxSum = findMaxofAllSubArry(arr, k);
		System.out.println("max sub array is "+maxSum);

	}

	private static List findMaxofAllSubArry(int[] arr, int window) {
		int i = 0;
		int j = 0;
		int size = arr.length-1;
		List<Integer> myList = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		while(j <= size) {
			
			myList.add(arr[j]);
			
			//Check windows size if less
			if(j -i + 1 < window) {
				j++;
			}
			else if(j - i + 1 == window) {
				int res = Collections.max(myList);
				answer.add(res);
				if(arr[i] == myList.get(0)) {
					myList.remove(0);
				}
				i++;
				j++;
			}
		}
		
		return answer;
	}
}