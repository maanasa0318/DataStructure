package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

	public static void main(String[] args) {
		Integer[] arr = { 1,3,5,6,7,10,12};
		
		List<Integer> ls = Arrays.asList(arr);
		Arrays.stream(arr).map( i -> i * 5).forEach(System.out:: println);
		
		ls.stream().filter(i  -> i % 5 == 0).forEach(System.out :: println);
		List<Integer> res = getMultiple(arr);
		//System.out.println(res);

	}

	private static List<Integer> getMultiple(Integer[] arr) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i =0; i <= arr.length-1; i++) {
			if(arr[i] % 5 == 0) {
				res.add(arr[i]);
			}
		}
		return res;
	}

}
