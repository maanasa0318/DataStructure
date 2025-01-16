package tuf;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

public class BinaryTreePaths {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		BinaryTreePaths solution = new BinaryTreePaths();
		System.out.println(solution.binaryTreePaths(root));
	}

	public List<List<String>> binaryTreePaths(TreeNode root) {

		List<List<String>> allPath = new ArrayList<>();
		List<String> path = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		dfs(root, allPath, path, sb);
		
		List<String> ans = new ArrayList<>();
		for(List<String> i : allPath) {
			
		}
		return allPath;

	}

	private static void dfs(TreeNode root, List<List<String>> allPath, List<String> path, StringBuilder sb) {
		if (root == null) {
			return;
		}
		path.add(String.valueOf(root.data)+"->");
		if (root.left == null & root.right == null) {
			allPath.add(new ArrayList<>(path));
		} else {
			dfs(root.left, allPath, path, sb);
			dfs(root.right, allPath, path, sb);
		}
		path.remove(path.size() - 1);

	}

}
