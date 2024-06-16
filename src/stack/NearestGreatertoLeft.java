package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Input : arr[] = {10, 5, 11, 6, 20, 12} 
Output :           -1, 10, -1, 11, -1, 20 
 */
public class NearestGreatertoLeft {

	public static void main(String[] args) {

		int[] arr = {10, 5, 11, 6, 20, 12} ;
		List<Integer> res = findNearestGreaterToLeft(arr);
		System.out.println("Nearest greatest to left is " + res);
	}

	private static List<Integer> findNearestGreaterToLeft(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i =0; i <= arr.length-1 ; i++) {
			if( stack.size() == 0) {
				list.add(-1);
			}
			else if( stack.size() > 0 && stack.peek() > arr [i] ){
				list.add(stack.peek());
			}
			else if ( stack.size() > 0 && stack.peek() < arr [i]) {
				while( stack.size() > 0 && stack.peek() < arr [i]) {
					stack.pop();
				}
				if(stack.size() == 0) {
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
