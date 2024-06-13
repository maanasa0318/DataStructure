package heap;

import java.util.PriorityQueue;

public class SumofElementsbetweenk1smallestk2smallestnumbers {

	public static void main(String[] args) {

		int[] arr = { 1,3,12,5,15,11 };
		int k1 = 3;
		int k2 = 6;
		int res = maxHeap(arr, k1);
		int res1 = maxHeap(arr, k2);
		System.out.println("Kth smallest element is " + res);
		System.out.println("Kth smallest element is " + res1);
		int sum = 0;
		
		for(int i =0; i <= arr.length-1; i++) {
			if (arr[i] > res && arr[i] < res1) {
				sum = sum + arr[i];
			}
		}
		System.out.println("Sum of elments between k1 and k2 is "+ sum);

	}

	private static int maxHeap(int[] arr, int k) {
		//Max Heap: Using comparator to make it a max heap.
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i <= arr.length - 1; i++) {
			maxheap.add(arr[i]);
			if (maxheap.size() > k) {
				maxheap.poll();
			}
		}
		return maxheap.peek();
	}

}
