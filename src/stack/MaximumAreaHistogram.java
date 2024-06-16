package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*Find the largest rectangular area possible in a given histogram where the 
 * largest rectangle can be made of a number of contiguous bars. 
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * Maximum area is 12
*/
public class MaximumAreaHistogram {

	public static void main(String[] args) {

		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		List<Integer> leftIndex = findNearestSmallestToLeft(arr);
		System.out.println("Left index is "+leftIndex);
		List<Integer> rightIndex = findNearestSmallestToRight(arr);
		System.out.println("Right index is "+rightIndex);
		List<Integer> widthArray = new ArrayList<Integer>();
		for(int i =0; i <= arr.length-1; i++) {
			int width = Math.abs((rightIndex.get(i) - leftIndex.get(i)) -1);
			widthArray.add(width);
		}
		System.out.println("Width is" + widthArray);
		
		//Now calculate the area
		int max = Integer.MIN_VALUE;
		int res = 0;
		for(int i =0; i <= arr.length-1; i++) {
			res = arr[i] * widthArray.get(i);
			max = Math.max(max, res);
		}
		System.out.println("maximun ares is "+ max);

	}

	private static List<Integer> findNearestSmallestToRight(int[] arr) {
		Stack<Pair> st = new Stack<>();
		List<Integer> ls = new ArrayList<Integer>();
		int sudoIndex = arr.length +1 ;
		
		for(int i = arr.length -1 ; i >= 0; i --) {
			if(st.size() == 0) {
				ls.add(sudoIndex);
			}
			else if ( st.size() > 0 && st.peek().value < arr [i]) {
				ls.add(st.peek().index);
			}
			else if ( st .size() > 0 && st.peek().value  > arr[i]) {
				while(st.size() > 0 && st.peek().value  > arr[i]) {
					st.pop();
				}
				if(st.size() == 0) {
					ls.add(-1);
				}
				else {
					ls.add(st.peek().index);
				}
			}
			st.add(new Pair(arr[i], i));
		}
		Collections.reverse(ls);
		return ls;
	}

	

	private static List<Integer> findNearestSmallestToLeft(int[] arr) {
		Stack<Pair> st = new Stack<>();
		List<Integer> ls = new ArrayList<Integer>();
		int sudoIndex = -1;
		
		for(int i =0; i <= arr.length-1 ; i++) {
			if(st.size() ==0) {
				ls.add(sudoIndex);
			}
			else if ( st.size() > 0 && st.peek().value < arr[i]){
				ls.add(st.peek().index);
			}
			else if(st.size() >0 && st.peek().value > arr[i]) {
				while( st.size() > 0 && st.peek().value > arr[i]) {
					st.pop();
				}
				if(st.size() ==0) {
					ls.add(-1);
				}
				else if ( st.peek().value < arr[i]) {
					ls.add(st.peek().index);
				}
			}
			st.add(new Pair(arr[i], i));
		}
		
		return ls;
	}
}




