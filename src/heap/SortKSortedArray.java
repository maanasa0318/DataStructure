package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*Given an array of n elements, where each element is at most k away from its target position,
 *  devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, 
 *  an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Example:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10} . */
public class SortKSortedArray {

	public static void main(String[] args) {

		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
		int k = 3;
		List<Integer> res = minHeap(arr, k);
		System.out.println("Kth smallest element is " + res);
	}

	private static List<Integer> minHeap(int[] arr, int k) {
		ArrayList<Integer> l = new ArrayList<>();
		//min heap
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			if (q.size() > k) {
				l.add(q.poll());
			}
		}
		while (!q.isEmpty()) {
			//or l.add(q.remove());
			l.add(q.poll());
		}
		return l;
	}
}
