package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given an array of integers, find the closest (not considering distance, but value) smaller on left of every element. If an element has no smaller on the left side, print -1 . 
*/
public class NearestSmallesttoLeft {

	public static void main(String[] args) {

		int[] arr = {4,5,2,10,8};
		//o/p     = {-1,4,-1,2,2}
		List<Integer> res = findNearestSmallestToLeft(arr);
		System.out.println("Nearest smallest to left is " + res);
	}

	private static List<Integer> findNearestSmallestToLeft(int[] arr) {
		Stack<Integer> st = new Stack<>();
		List<Integer> ls = new ArrayList<Integer>();
		
		for(int i =0; i <= arr.length-1 ; i++) {
			if(st.size() ==0) {
				ls.add(-1);
			}
			else if ( st.size() > 0 && st.peek() < arr[i]){
				ls.add(st.peek());
			}
			else if(st.size() >0 && st.peek() > arr[i]) {
				while( st.size() > 0 && st.peek() > arr[i]) {
					st.pop();
				}
				if(st.size() ==0) {
					ls.add(-1);
				}
				else if ( st.peek() < arr[i]) {
					ls.add(st.peek());
				}
			}
			st.add(arr[i]);
		}
		
		return ls;
	}

}
