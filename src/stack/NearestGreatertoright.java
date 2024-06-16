package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*Given an array, print the Next Greater Element (NGE) for every element or Next Largest Element

The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1. 

Examples: 

Input: arr[] = [ 1,3,2,4 ]
Output:        [3,4,4,-1]
*/
public class NearestGreatertoright {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		List<Integer> res = findNearestGreaterToRight(arr);
		System.out.println("Nearest greatest to right is " + res);
	}

	private static List<Integer> findNearestGreaterToRight(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		List<Integer> ls = new ArrayList<>();
		
		for(int i = arr.length -1; i >= 0; i--) {
			if(st.size() == 0) {
				ls.add(-1);
			}
			else if (st.size() > 0 && st.peek() > arr[i]) {
				ls.add(st.peek());
				
			}
			else if(st.size() > 0 && st.peek() < arr[i]) {
				while(st.size() > 0 && st.peek() < arr[i]) {
					st.pop();
				}
				if(st.size() == 0) {
					ls.add(-1);
				}
				else {
					ls.add(st.peek());
				}
			}
			st.push(arr[i]);
		}
		Collections.reverse(ls);
		return ls;
	}

}
