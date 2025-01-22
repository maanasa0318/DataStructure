package tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {

	public static void main(String[] args) {
		int V = 4, E = 2;
		List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2));

		/*
		 * Function call to find the number of connected components in the given graph
		 */
		int ans = findNumberOfComponent(E, V, edges);

		System.out.println("The number of components in the given graph is: " + ans);

	}

	public static int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {

		List<List<Integer>> adj = new ArrayList<>();
		boolean[] vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		int count=0; 
		for(int i = 0;i<V;i++)
		{
			count++;
			if (!vis[i]) {
				dfs(i, adj, vis);
			}
		}
		return count;
	}

	private static void dfs(int node, List<List<Integer>> adj , 
                     boolean[] vis) {
       vis[node] = true;
       for(int nei : adj.get(node)){
          if(!vis[node]){
            dfs(nei, adj, vis);
         }
       }
    }

}
