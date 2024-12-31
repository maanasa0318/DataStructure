package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

	public static void main(String[] args) {

		int[] nums = {4,2,1,3};
		List<List<Integer>> res = minimumAbsDifference(nums);
		System.out.println(res);
		
	}
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
    	int minDiff = Integer.MAX_VALUE;
    	Arrays.sort(arr); //(nlong n)
    	int i=0;
    	int j =1;
    	List<List<Integer>> res = new ArrayList<>();
    	while(j<arr.length) {
    		int diff = arr[j] - arr[i];
    		
    		if(diff < minDiff) {
    			minDiff = diff;
    			res.clear();
    			res.add(Arrays.asList(arr[i], arr[j]));
    		}
    		else if(diff  == minDiff) {
    			res.add(Arrays.asList(arr[i], arr[j]));
    		}
    		j++;
    		i++;
    	}
		return res;

    }

}
