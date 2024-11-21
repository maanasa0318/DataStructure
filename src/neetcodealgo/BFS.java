package neetcodealgo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

public class BFS {

	public static void main(String[] args) {
		
		
		Deque<String> deque = new ArrayDeque<>();

        deque.add("element 1");
        deque.add("element 2");
        deque.add("element 3");

        System.out.println("Deque before removal: " + deque);

        String removedElement = deque.removeFirst();

        System.out.println("Removed element: " + removedElement);
        
        System.out.println("Deque after removal: " + deque);

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		bfs(root);
	    List<List<Integer>> res = levelOrder(root);
	    System.out.println("--------res------" + res);
	    
	    //Binary Tree Right Side View
	    List<Integer> rt = rightSideView(root);
	    System.out.println("--------Right side tree------" + rt);

		
	}

	private static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode rightSide = null;
			int len = q.size();
			
			for(int i=0; i<len; i++) {
				TreeNode node = q.poll();
				if(node != null) {
					rightSide = node;
					q.offer(node.left);
					q.offer(node.right);
				}
			}
			
			if(rightSide != null) {
				list.add(rightSide.val);
			}
		}
		return list;
		
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		if(root != null) {
			queue.add(root);
		}
		
		int level =0;
		while(!queue.isEmpty()) {
			List<Integer> innerList = new ArrayList<Integer>();
			int levelLength = queue.size();
			for(int i=0; i< levelLength; i++) {
				TreeNode curr = queue.removeFirst();
				innerList.add(curr.val);
				if(curr.left != null) {
					queue.add(curr.left);
				}
				if(curr.right != null) {
					queue.add(curr.right);
				}
			}
			level++;
			res.add(innerList);
		}
		
		
		return res;
	}

	private static void bfs(TreeNode root) {

		Deque<TreeNode> queue = new ArrayDeque<>();
		if( root != null) {
			queue.add(root);
		}
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.println("level " + level);
			int levelLength = queue.size();
			for(int i=0; i<levelLength; i++) {
				TreeNode curr = queue.removeFirst();
				System.out.println("curr val "+ curr.val);
				if(curr.left != null) {
					queue.add(curr.left);
				}
				if(curr.right != null) {
					queue.add(curr.right);
				}
			}
			level++;
			System.out.println();
		}
		
	}

}


