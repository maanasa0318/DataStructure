package neetcodealgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {


		int[][] intervals = { { 1, 3 }, { 1, 5 }, {6, 7} };
		int[][] res = merge(intervals);
		System.out.println(Arrays.toString(res));
	}

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
		List<int[]> list = new ArrayList<>();
		list.add(intervals[0]);
		for(int[] i : intervals) {
			int start = i[0];
			int end = i[1];
			int lastIndex = list.get(list.size()-1)[1];
			
			if(start <= lastIndex) {
				list.get(list.size()-1)[1] = Math.max(lastIndex, end);
			}
			else {
				list.add(new int[] {start, end});
			}
		}
		return list.toArray(new int[list.size()][]);
		
	}

}
