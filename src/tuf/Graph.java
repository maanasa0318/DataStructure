package tuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	public static void main(String[] args) {
		int V = 5;
		List<Integer>[] adj = new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		adj[0].addAll(Arrays.asList(2, 3, 1));
		adj[1].add(0);
		adj[2].addAll(Arrays.asList(0, 4));
		adj[3].add(0);
		adj[4].add(2);

		// Creating instance of Solution class
		Graph sol = new Graph();

		// Function call to get the BFS traversal of graph
		List<Integer> bfs = sol.bfsOfGraph(V, adj);

		// Function call to get the DFS traversal of graph
		List<Integer> dfs = sol.dfsOfGraph(V, adj);

		// Output
		System.out.println("The BFS traversal of the given graph is: " + bfs);
		System.out.println("The DFS traversal of the given graph is: " + dfs);
	}

	public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
		boolean[] visited = new boolean[V];
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, adj, visited, ans);
			}
		}
		return ans;
	}

	private void dfs(int node, List<Integer>[] adj, boolean[] vis, List<Integer> ans) {
		vis[node] = true;
		ans.add(node);
		for (int nei : adj[node]) {
			if (!vis[nei]) {
				dfs(nei, adj, vis, ans);
			}
		}
	}

	public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
		boolean[] visited = new boolean[V];
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				bfs(i, adj, visited, ans);
			}
		}
		return ans;
	}

	private void bfs(int node, List<Integer>[] adj, boolean[] vis, List<Integer> ans) {

		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			int current = q.poll();
			ans.add(current);
			for (int neig : adj[current]) {
				if (!vis[neig]) {
					vis[neig] = true;
					q.add(neig);
				}

			}
		}
	}
}
