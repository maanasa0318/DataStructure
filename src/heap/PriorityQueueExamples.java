package heap;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PriorityQueueExamples {

	public static void main(String[] args) {


		int[] arr = { 6, 5, 5, 6, 8, 10, 9 };
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
		for(int i =0; i <= arr.length-1 ; i++) {
			pq.offer(arr[i]);
			System.out.println(pq.peek());
		}
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		queue.add("TestQuue1");  // will return true        
		queue.add("TestQuue2");  // will return true
		queue.add("TestQuue3");  // will throw "java.lang.IllegalStateException: Queue full

		BlockingQueue<String> queue1 = new ArrayBlockingQueue<>(2);
		queue1.offer("TestQuue1"); // will return true       
		queue1.offer("TestQuue2"); // will return true   
		queue1.offer("TestQuue3"); // will return false and will not throw any exception
	}

}
