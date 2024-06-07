package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Example:

Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0 . */
public class FirstNegativeNumber {

	
	public static void main(String[] args) {
		int[] array = {12 ,-1, -7, 8 ,-15, 30, 16, 28};
		int windows = 3;
		List res = firstNegativeNumberInWindows2(array, windows);
		System.out.println(res);		
	}

	private static List firstNegativeNumberInWindows2(int[] array, int windows) {
		int i =0;
		int j =0;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<Integer>();
		
		while(j <= array.length-1) {
			if(array[j] <0) {
				list.add(array[j]);
			}
			if(j -i +1 < windows) {
				j++;
			}
			else if( j -i + 1 == windows) {
				if(list.isEmpty()) {
					ans.add(0);	
				}else {
					//answer always get in index 0 [12, -1, -7], list contain[-1, -7] so -1 is first -ve number in window 3
					ans.add(list.get(0));
					if(array[i] == list.get(0)) {
						list.remove(0);
					}
				}
				i++;
				j++;
			}
		
		}
		
		return ans;
	}

}
