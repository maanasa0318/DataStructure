package neetcodealgo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = {1,2,1,0,4,2,6};
		int k = 3;
		int[] res = swmax(nums,k);
		System.out.println(Arrays.toString(res));
	}

	private static int[] swmax(int[] nums, int k) {
		Deque<Integer> q = new LinkedList<>();
		int n = nums.length;
		int[] output = new int[n-k +1];
		int index =0;
		
		for(int i=0; i<nums.length; i++) {
			//remove numbers out of range q.peek() retreive head of queue
			if(!q.isEmpty() && q.peek() == i - k) {
				q.poll(); // remove elem at front;
			}
			while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
				q.pollLast();
			}
			
			q.offer(i);
			
			if(i >= k-1) {
				output[index++] = nums[q.peek()];
			}
		}
		return output;
		
		
	}

}
