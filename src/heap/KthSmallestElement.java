package heap;

import java.util.PriorityQueue;

/*Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that all array elements are distinct.

Example:
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7 . */
public class KthSmallestElement {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int res = maxHeap(arr, k);
		System.out.println("Kth smallest element is " + res);
	}

	private static int maxHeap(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b-a);

		for(int i =0; i< arr.length; i++) {
			queue.add(arr[i]);
			System.out.println(arr[i]);
			if(queue.size() > k) {
				queue.poll();
			}
		}
		
		return queue.peek();
	}

}
