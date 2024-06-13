package heap;

import java.util.PriorityQueue;

/*write an efficient program for printing k largest elements in an array.
 *  Elements in array can be in any order.

For example, if given array is [1, 23, 12, 9, 30, 2, 50]
 and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23. . */
public class ReturnKlargestElements {

	public static void main(String[] args) {

		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		minHeap(arr, k);
	}

	private static void minHeap(int[] arr, int k) {
		PriorityQueue<Integer> maxheap = new PriorityQueue<>();
		for (int i = 0; i <= arr.length - 1; i++) {
			maxheap.add(arr[i]);
			if (maxheap.size() > k) {
				maxheap.poll();
			}
		}
		maxheap.stream()
				.forEach(System.out :: println);
	}
}