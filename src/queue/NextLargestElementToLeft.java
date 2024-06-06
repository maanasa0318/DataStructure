package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLargestElementToLeft {

	public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        List<Integer> res = nearestGreaterToLeft(arr);
        for(int i : res) {
        	System.out.println(i);
        }
	}

	private static List<Integer> nearestGreaterToLeft(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<= arr.length-1; i++) {
			if(stack.isEmpty()) {
				list.add(-1);
			}
			else if (!stack.isEmpty() && stack.peek() > arr[i]) {
				list.add(stack.peek());
			}
			else if (!stack.isEmpty() && stack.peek() < arr[i]) {
				while(!stack.isEmpty() && stack.peek() < arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}
				else {
					list.add(stack.peek());
				}
			}
			stack.push(arr[i]);
		}
		return list;
	}
}
