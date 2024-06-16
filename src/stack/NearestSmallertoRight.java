package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*Given an array of integers, find the closest (not considering distance, but value) smaller on rightof every element. If an element has no smaller on the right side, print -1. . 
*/
public class NearestSmallertoRight {

	public static void main(String[] args) {

		int[] arr = {4,5,2,10,8};
		//o/p     = {2,2,-1,8,-1}
		List<Integer> res = findNearestSmallestToRight(arr);
		System.out.println("Nearest smallest to right is " + res);
	}

	private static List<Integer> findNearestSmallestToRight(int[] arr) {
		Stack<Integer> st = new Stack<>();
		List<Integer> ls = new ArrayList<Integer>();
		
		for(int i = arr.length -1 ; i >= 0; i --) {
			if(st.size() == 0) {
				ls.add(-1);
			}
			else if ( st.size() > 0 && st.peek() < arr [i]) {
				ls.add(st.peek());
			}
			else if ( st .size() > 0 && st.peek() > arr[i]) {
				while(st.size() > 0 && st.peek() > arr[i]) {
					st.pop();
				}
				if(st.size() == 0) {
					ls.add(-1);
				}
				else {
					ls.add(st.peek());
				}
			}
			st.add(arr[i]);
		}
		Collections.reverse(ls);
		return ls;
	}

}
