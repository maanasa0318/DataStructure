package heap;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*Given an unsorted array and two numbers x and k, find k closest values to x.
Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3 . 
Max heap*/
public class KClosestNumbers {

	public static void main(String[] args) {

		int[] arr = {10, 2, 14, 4, 7, 6};
		int x = 7;
		int k = 3; 
		List<Integer> res = findClosestElemnts(arr, x, k);
		System.out.println("Closet element are "+ res);
	}

	private static List<Integer> findClosestElemnts(int[] arr, int x, int k) {
	   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length,(o1,o2)->
        {
        	if(Math.abs(o1 -x) == Math.abs(o2-x)) {
        		if(o1>o2) {
             	   return -1;
                }
                else {
                    return 1;
                }
        	}
        	else if(Math.abs(o1 -x) > Math.abs(o2-x)) {
        		return -1;
        	}
        	else 
        	return 1;
        });
	
		for(int i =0; i <= arr.length-1; i++) {
			pq.add(arr[i]);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		while(pq.size() >0) {
			res.add(pq.poll());
		}
		return res;
	}

}
