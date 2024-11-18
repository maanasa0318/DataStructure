package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDiffPair {

	public static void main(String[] args) {

		int[] arr = {4,2,1,3};
		List<List<Integer>>  res = minDiff(arr);
		System.out.println(res);
	}

	private static List<List<Integer>> minDiff(int[] arr) {
		int min= Integer.MAX_VALUE;
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList();
		
		for(int i=0; i<arr.length -1; i++) {
			int diff = arr[i+1] - arr[i];
			System.out.println(diff);
			
			if(diff < min) {
				min = diff;
                res.clear();
				res.add(Arrays.asList(arr[i], arr[i+1]));
			}else if(diff == min){
				res.add(Arrays.asList(arr[i], arr[i+1]));
			}
			
		}
		
		return res;
	}

	
	
}
