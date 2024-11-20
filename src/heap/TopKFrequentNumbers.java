package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the top (According to their decreasing frequency) every time a new number is read. We basically need to print top k numbers sorted by frequency when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

Example:
Input :  arr[] = {5, 2, 1, 3, 2}
k = 4
Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5 . 

Top is used in ques so min heap*/
public class TopKFrequentNumbers {

	public static void main(String[] args) {
		int arr[] = {1,1,1,3,2,2,4};
		int k = 2;
		 topKFrq(arr, k);
		 int[] res = topKFreqNeetCode(arr, k);
		 System.out.println(Arrays.toString(res));
		
	}

	private static int[] topKFreqNeetCode(int[] arr, int k) {
		  //Using queue
					// time: O(nlogk) space: O(n+k)
		Map<Integer, Integer> count = new HashMap<>();
	    for (int num : arr) {
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

	private static void topKFrq(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i <= arr.length-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for(Entry<Integer, Integer> m : map.entrySet()){
			System.out.println(m.getKey()+": "+m.getValue());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)-> b-a);
		
		for(int i :map.keySet()) {
			pq.add(i);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		while(pq.size() >0) {
			System.out.println(pq.poll());
		}
			
	}

}
