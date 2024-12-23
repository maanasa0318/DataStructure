package neetcodealgo;

import java.util.ArrayList;

public class GraphDFS {

	public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[adj.size()];
		ArrayList<Integer> ls = new ArrayList<>();
		vis[0] = true;
		dsf(adj, vis, ls, 0);
		return ls;
	}

	private static void dsf(ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ls, int node) {
		vis[node] = true;
		ls.add(node);
		for (Integer i : adj.get(node)) {
			if (!vis[i]) {
				dsf(adj, vis, ls, i);
			}
		}
	}

}
