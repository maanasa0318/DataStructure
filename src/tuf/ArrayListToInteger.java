package tuf;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToInteger {

	public static void main(String[] args) {

		  // Example 2D array
        int[][] arr = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println(arr.length);
        List<List<Integer>> adj1 = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
        	adj1.add(new ArrayList<>());
        	
        }
       
		for(int[] it : arr) {
			adj1.get(it[1]).add(it[0]);
        }
        
        System.out.println(adj1);

        List<List<Integer>> adj = new ArrayList<>();

        // Add elements from the 2D array to the adjacency list
        for (int[] row : arr) {
            List<Integer> list = new ArrayList<>();
            for (int val : row) {
                list.add(val);
            }
            adj.add(list);
        }

        // Print the adjacency list
        System.out.println(adj);
	}

}
