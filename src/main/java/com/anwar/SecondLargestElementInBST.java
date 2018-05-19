package com.anwar;

import java.util.Stack;

public class SecondLargestElementInBST {

	static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}

		private static void doPrintPostorder(BinaryTreeNode node) {
			if (node == null)
				return;

			// first recur on left subtree
			printPostorder(node.left);

			// then recur on right subtree
			printPostorder(node.right);

			// now deal with the node
			System.out.print(node.value + " ");
		}

		/* Given a binary tree, print its nodes in inorder */
		private static void doPrintInorder(BinaryTreeNode node) {
			if (node == null)
				return;

			/* first recur on left child */
			printInorder(node.left);

			/* then print the data of node */
			System.out.print(node.value + " ");

			/* now recur on right child */
			printInorder(node.right);
		}

		/* Given a binary tree, print its nodes in preorder */
		private static void doPrintPreorder(BinaryTreeNode node) {
			if (node == null)
				return;

			/* first print data of node */
			System.out.print(node.value + " ");

			/* then recur on left sutree */
			printPreorder(node.left);

			/* now recur on right subtree */
			printPreorder(node.right);
		}

		// Wrappers over above recursive functions
		private static void printPostorder(BinaryTreeNode root) {
			doPrintPostorder(root);
		}

		private static void printInorder(BinaryTreeNode root) {
			doPrintInorder(root);
		}

		private static void printPreorder(BinaryTreeNode root) {
			doPrintPreorder(root);
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(1);
		BinaryTreeNode left = tree.insertLeft(2);
		tree.insertRight(3);
		left.insertLeft(4);
		left.insertRight(5);

		System.out.println("Preorder traversal of binary tree is ");
		BinaryTreeNode.printPreorder(tree);

		System.out.println("\nInorder traversal of binary tree is ");
		BinaryTreeNode.printInorder(tree);

		System.out.println("\nPostorder traversal of binary tree is ");
		BinaryTreeNode.printPostorder(tree);
		
	}
	
	private static boolean leafDepth(BinaryTreeNode node) {
		
		if(node.left != null) {
			if (node.left.value > node.value) {
				return false;
			}
			else {
				leafDepth(node.left);
			}
				
		}
		if(node.right != null && node.right.value < node.value) {
			return false;
		}
		return false;
	}
	
	
	
	

	static class MyStack< T extends Integer> extends Stack<T>{
		
	}
	
	
}
