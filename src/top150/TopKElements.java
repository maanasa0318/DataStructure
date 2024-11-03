package top150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {

	public static void main(String[] args) {

		int[] arr = {-1,-1};
		int k = 2;
		int[] res = topKFrequent(arr, k);
		System.out.println(Arrays.toString(res));
		int[] res1 = topKFreqBucketSort(arr, k);
		System.out.println(Arrays.toString(res1));
	}

	private static int[] topKFreqBucketSort(int[] arr, int k) {
		
		return null;
	}

	private static int[] topKFrequent(int[] nums, int k) {
		//Using queue
		// time: O(nlogk) space: O(n+k)	
		 Map<Integer, Integer> count = new HashMap<>();
	        for (int num : nums) {
	            count.put(num, count.getOrDefault(num, 0) + 1);
	        }

	        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
	            heap.offer(new int[]{entry.getValue(), entry.getKey()});
	            if (heap.size() > k) {
	                heap.poll();
	            }
	        }

	        int[] res = new int[k];
	        for (int i = 0; i < k; i++) {
	            res[i] = heap.poll()[1];
	        }
	        return res;
	}

}
