package neetcodealgo;

import java.util.Arrays;

public class ConstructBinary {

	public static void main(String[] args) {

		int[] preorder = {1,2,3,4};
		int[] inorder = {2,1,3,4};
		
		int[] res = constructBSTree(preorder, inorder);
		System.out.println(Arrays.toString(res));
	}

	private static int[] constructBSTree(int[] preorder, int[] inorder) {

		if(preorder == null || inorder == null) {
			return null;
		}
		
		TreeNode node = new TreeNode(preorder[0]);
		int mid = -1;
		for(int i=0; i<inorder.length; i++) {
			if(preorder[0] == inorder[i]) {
				mid = i;
				break;
			}
		}
		
		int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);
		int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);
		//node.left = constructBSTree(leftPreOrder, leftInOrder);
		
		int[] rightPreOrder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
		int[] rightInOrder = Arrays.copyOfRange(inorder, mid +1, inorder.length);
		//node.left = constructBSTree(rightPreOrder, rightInOrder);
		//return node;
		return null;
	}

}
