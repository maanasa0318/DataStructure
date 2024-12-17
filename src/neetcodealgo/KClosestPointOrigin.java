package neetcodealgo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointOrigin {

	public static void main(String[] args) {

		int[][] points = {{0,2},{2,2}};
		int k = 1;
		
		int[][] res = findKpoint(points, k);
	}

	private static int[][] findKpoint(int[][] points, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
		for(int[] point : points) {
			int dist = point[0] * point[0] + point[1] * point[1];
			minHeap.offer(new int[] {dist,point[0], point[1]});
		}
		
		int[][] res = new int[k][2];
		int i =0;
		while(k > 0) {
			int[] cords = minHeap.poll();
			System.out.println(cords[0]+":"+cords[1]+ ":"+cords[2]);
			res[i] = new int[] {cords[1], cords[2]};
			k = k -1;
			i++;
		}
		return res;
	}

	

}
