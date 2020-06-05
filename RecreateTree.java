package com.ldd;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RecreateTree {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		int length = preorder.length;
		for (int i = 0; i < length; i++) {
			indexMap.put(inorder[i], i);

		}
		TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
		return root;

	}

	public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
			int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {

		if (preorderStart > preorderEnd) {
			return null;
		}
		int rootVal = preorder[preorderStart];
		TreeNode root = new TreeNode(rootVal);
		if (preorderStart == preorderEnd) {
			return root;
		} else {
			int rootIndex = indexMap.get(rootVal);
			int leftNodes = rootIndex - inorderStart;
			int rightNodes = inorderEnd - rootIndex;
			TreeNode leftSubTree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder,
					inorderStart, rootIndex - 1, indexMap);
			TreeNode rightSubTree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder,
					rootIndex + 1, inorderEnd, indexMap);
			root.left = leftSubTree;
			root.right = rightSubTree;
			return root;
		}

	}

	public static TreeNode buildStackTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		int length = preorder.length;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int inorderIndex = 0;
		for (int i = 1; i < length; i++) {
			int preorderVal = preorder[i];
			TreeNode node = stack.peek();
			if (node.val != inorder[inorderIndex]) {
				node.left = new TreeNode(preorderVal);
				stack.push(node.left);
			} else {
				if (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
					stack.pop();
					inorderIndex++;
				}
				node.right = new TreeNode(preorderVal);
				stack.push(node.right);
			}
		}

		return root;

	}

	public static void main(String[] args) {

		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		// TreeNode root = buildTree(preorder, inorder);
		TreeNode root = buildStackTree(preorder, inorder);
		System.out.println(InOrderTraversal.preOrderTraversal(root));
		System.out.println(InOrderTraversal.inOrderTraversal(root));

	}

}
