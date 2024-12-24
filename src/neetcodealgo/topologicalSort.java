package neetcodealgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class topologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();
		int[] visited = new int[size];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < size; i++) {
			if (visited[i] ==0) {
				dfs(i, visited, st,adj);
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		while (!st.isEmpty()) {
			Integer i = st.peek();
			ans.add(i);
			st.pop();
		}
		return ans;
	}

	public static void dfs(int node, int[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
		visited[node]=1;
		for (int i : adj.get(node)) {
			if (visited[i] ==0) {
				dfs(i, visited, st, adj);
			}
		}
		st.push(node);
	}

}
