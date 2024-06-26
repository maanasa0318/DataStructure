package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:

Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0

Output :  1 1 1 1
          1 1 1 1 . i.e 8
          
TODO - coding is not yet done
----------------------------------*/
public class MaxAreaRectangleinbinarymatrix {

	public static void main(String[] args) {
		int[][] arr = {{0,1,1,0},
					   {1,1,1,1},
					   {1,1,1,1},
					   {1,1,0,0}};
		int m = 4;
		int n = 4;
		int[] subArr = new int[n];
		for(int j =0; j <m ; j++) {
			subArr[j]= arr[0][j];
		}
		int max= getResult(subArr);
		System.out.println("maximun ares is "+ max);

	}
	
	private static int getResult(int[] arr) {
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
		return max;
	}

	private static List<Integer> findNearestSmallestToRight(int[] arr) {
		Stack<Pair> st = new Stack<>();
		List<Integer> ls = new ArrayList<Integer>();
		int sudoIndex = arr.length +1 ;
		
		for(int i = arr.length -1 ; i >= 0; i --) {
			if(st.size() == 0) {
				ls.add(sudoIndex);
			}
			else if ( st.size() > 0 && st.peek().value <= arr [i]) {
				ls.add(st.peek().index);
			}
			else if ( st .size() > 0 && st.peek().value  >= arr[i]) {
				while(st.size() > 0 && st.peek().value  >= arr[i]) {
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
			else if ( st.size() > 0 && st.peek().value <= arr[i]){
				ls.add(st.peek().index);
			}
			else if(st.size() >0 && st.peek().value >= arr[i]) {
				while( st.size() > 0 && st.peek().value >= arr[i]) {
					st.pop();
				}
				if(st.size() ==0) {
					ls.add(-1);
				}
				else if ( st.peek().value <= arr[i]) {
					ls.add(st.peek().index);
				}
			}
			st.add(new Pair(arr[i], i));
		}
		
		return ls;
	}

}
