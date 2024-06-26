package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

//smallest element greater then search
public class CeilelementSortedArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,8,10,18,20,30};

		NavigableSet<Integer> ns =  new TreeSet<Integer>((a, b)->(b- a));
		 ns.add(0); 
	        ns.add(1); 
	        ns.add(2); 
	        ns.add(3); 
	        ns.add(4); 
	        ns.add(5); 
	        ns.add(6); 
	        System.out.println( ns.descendingSet());
	      
	    List ls = new ArrayList<>(Arrays.asList(1,2,3,45,9));
	    Collections.reverse(ls);
	    System.out.println(ls);
	  
		int floorSearch = 9;
		
		int res = findceilElement(arr, floorSearch);
		System.out.println("ceil element is " + res);
		
	}

	private static int findceilElement(int[] arr, int search) {
		int l = 0;
		int h = arr.length -1;
		int res = -1;

		while(l <= h) {
			int middle = l + (h-l)/2;

			if(arr[middle] == search) {
				System.out.println("found " + search + " at index " + middle);
				return middle;
			}
			else if (arr[middle] > search) {
				// shift high
				res = arr[middle];
				h = middle - 1;
			}
			else if(arr[middle] < search) {
				//shift low
				l = middle + 1;
			}
			System.out.println("loop done once");
		}
		return res;
	}
}