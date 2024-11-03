package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortanArray {

	public static void main(String[] args) {

		int[] arr = { 5,2,3,1 };
		int[] res = minHeap(arr);
		System.out.println("Largest elemt at index 3 is "+Arrays.toString(res));
	}

	private static int[] minHeap(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] res = new int[arr.length];
		int count =0;
		for(int i=0; i<arr.length; i++) {
			pq.add(arr[i]);
		}
		while(!pq.isEmpty()) {
			res[count] = pq.poll();
			count++;
		}
		return res;
	}

}
