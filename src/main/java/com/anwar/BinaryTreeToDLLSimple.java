package com.anwar;

public class BinaryTreeToDLLSimple {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[Data = " + data + " ]";
		}
	}

	private static void fixPrevptr(Node root) {
		if (root == null)
			return;
		
		fixPrevptr(root.left);
		
//		root.left = prev;
//		prev = root;
		
		fixPrevptr(root.right);
	}

	// Changes right pointers to work
	// as next pointers in converted DLL
	private static Node fixNextptr(Node root) {
		// Find the right most node in
		// BT or last node in DLL
		while (root.right != null)
			root = root.right;
		// Start from the rightmost node, traverse
		// back using left pointers. While traversing,
		// change right pointer of nodes
		while (root != null && root.left != null) {
			Node left = root.left;
			left.right = root;
			root = root.left;
		}
		// The leftmost node is head of linked list, return it
		return root;
	}

	private static Node BTTtoDLL(Node root) {
		// Set the previous pointer
		fixPrevptr(root);
		// Set the next pointer and return head of DLL
		return fixNextptr(root);
	}

	// Traverses the DLL from left tor right
	private static void printlist(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

	// Standard Inorder traversal of tree
	private static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		// Let us create the tree shown in above diagram
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		System.out.println("Inorder Tree Traversal");
		inorder(root);

		Node head = BTTtoDLL(root);

		System.out.println("\nDLL Traversal");
		printlist(head);
	}
}
