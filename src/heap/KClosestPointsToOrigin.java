package heap;
/*Given a list of points on the 2-D plane and an integer K. The task is to find K closest points to the origin and print them.

Note: The distance between two points on a plane is the Euclidean distance.

Example:
Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2 . 
we will use max heap*/

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] arr = {{3, 3}, {5, -1}, {-2, 4}};
		int k = 2;
		int[][] res = kClosest(arr, k);
		for(int i =0; i <= res.length-1; i++) {
			for(int j =0 ; j <= res[i].length-1; j++) {
	            System.out.println("Values at arr["+i+"]["+j+"] is "+res[i][j]);
			}
		}
		
	}

    private static int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]),(p1[0] * p1[0] + p1[1] * p1[1])));
        
        for(int i=0; i<points.length; i++){
            q.add(points[i]);
            if(q.size() > k){
                q.poll();
            }
        }
        int[][] arr = new int[k][];
       
        while(k>0){
            arr[--k] = q.poll();
        }
        return arr;
    }
}
	
