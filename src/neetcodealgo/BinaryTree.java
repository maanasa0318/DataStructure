package neetcodealgo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(50);
		node.left = new TreeNode(30);
		node.right = new TreeNode(70);
		node.left.left = new TreeNode(20);
		node.left.right = new TreeNode(40);
		node.right.right = new TreeNode(80);
		node.right.left = new TreeNode(60);
		
		TreeNode res = searchBST(node, 60);
		System.out.println(res.val);
		
		TreeNode res1 = insertIntoBST(node, 10);
		System.out.println(res1);
		
		TreeNode minVal = minValueNode(node);
		System.out.println(minVal.val);
		
		TreeNode remv = remove(node, 50);
		System.out.println("new root node taken from right is:" + remv.val);
		
		//DFS
		inorder(node);
		System.out.println();
		preorderTraversal(node);
		System.out.println();
		postOrderTraversal(node);
		
		System.out.println("------------");
		int kthelem = kthSmallest(node, 1);
		System.out.println(kthelem);
		
		System.out.println("Max depth");
		System.out.println(maxDepth(node));
		
		System.out.println("diameter of Binary tree");
		
		int result = diameterOfBinaryTree(node);
		System.out.println(result);
		
	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
        
    }

    public static int dfs(TreeNode root, int[] res ){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }

	
	private static int maxDepth(TreeNode root) {
        if( root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
	
	private static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		inorder1(root, list);
		return list.get(k -1);
	}
	
	private static void inorder1(TreeNode node, List<Integer> list) {
		if(node == null) {
			return;
		}
		inorder1(node.left, list);
		list.add(node.val);
		inorder1(node.right, list);
	}
	
	private static void postOrderTraversal(TreeNode root) {
		if(root != null){
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            System.out.println(root.val);
        }		
	}

	private static void preorderTraversal(TreeNode root) {
        if(root != null){
            System.out.println(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
	}

	private static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}

	private static TreeNode remove(TreeNode root, int val) {

		if(root == null) {
			return null;
		}
		if(val > root.val ) {
			root.right = remove(root.right, val);
		}
		else if ( val < root.val) {
			root.left = remove(root.left, val);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			else {
				TreeNode minNode = minValueNode(root.right);
				root.val = minNode.val;
				root.right = remove(root.right, minNode.val);
			}
		}
		return root;
	}

	private static TreeNode minValueNode(TreeNode node) {
		TreeNode curr = node;
		while(curr != null && curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	private static TreeNode insertIntoBST(TreeNode node, int val) {

		if(node == null) {
			return new TreeNode(val);
		}
		if( val > node.val) {
			insertIntoBST(node.right, val);
		}
		else if( val < node.val) {
			insertIntoBST(node.left, val);
		}
		return node;
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		
		if(root == null || root.val == val) {
			return root;
		}
		if(val > root.val) {
			return searchBST(root.right, val);
		}
		if(val < root.val) {
			return searchBST(root.left, val);

		}
		return root;
	
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
		left = right = null;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

