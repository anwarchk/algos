package com.interviewcake;

public class BinaryTreeToLL {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}

		@Override
		public String toString() {
			return "[data = " + data + " ]";
		}
	}

	static class BinaryTree {
		/*
		 * This is the core function to convert Tree to list. This function follows
		 * steps 1 and 2 of the above algorithm
		 */
		private static Node doTraverseTree(Node node) {
			// Base case
			if (node == null)
				return node;
			// Convert the left subtree and link to root
			if (node.left != null) {
				// Convert the left subtree
				Node left = doTraverseTree(node.left);
				// Find inorder predecessor. After this loop, left
				// will point to the inorder predecessor
				while (left.right != null) {
					left = left.right;
				}
				// Make root as next of the predecessor
				left.right = node;
				// Make predecssor as previous of root
				node.left = left;
			}
			// Convert the right subtree and link to root
			if (node.right != null) {
				// Convert the right subtree
				Node right = doTraverseTree(node.right);
				// Find inorder successor. After this loop, right
				// will point to the inorder successor
				while (right.left != null) {
					right = right.left;
				}
				// Make root as previous of successor
				right.left = node;
				// Make successor as next of root
				node.right = right;
			}
			return node;
		}
		// The main function that first calls bintree2listUtil(), then follows
		// step 3 of the above algorithm
		private Node bintree2list(Node rootNode) {
			// Base case
			if (rootNode == null)
				return rootNode;
			// Convert to DLL using bintree2listUtil()
			doTraverseTree(rootNode);
			while (rootNode.left != null)
				rootNode = rootNode.left;
			return rootNode;
		}

		/* Function to print nodes in a given doubly linked list */
		private void printList(Node node) {
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.right;
			}
		}

		/* Driver program to test above functions */
		public static void main(String[] args) {
			BinaryTree tree = new BinaryTree();
			// Let us create the tree shown in above diagram
			Node root = new Node(10);
			root.left = new Node(12);
			root.right = new Node(15);
			root.left.left = new Node(25);
			root.left.right = new Node(30);
			root.right.left = new Node(36);
			// Convert to DLL
			Node head = tree.bintree2list(root);
			// Print the converted list
			tree.printList(head);
		}
	}

	/*
	 * This is the simple Node class from which the tree and list are built. This
	 * does not have any methods -- it's just used as dumb storage by TreeList. The
	 * code below tries to be clear where it treats a Node pointer as a tree vs.
	 * where it is treated as a list.
	 */
	static class TreeNode {
		int data;
		Node left;
		Node right;

		public TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * TreeList main methods: -join() -- utility to connect two list nodes -append()
	 * -- utility to append two lists -treeToList() -- the core recursive function
	 * -treeInsert() -- used to build the tree
	 */
	static class TreeList {
		/*
		 * helper function -- given two list nodes, join them together so the second
		 * immediately follow the first. Sets the .next of the first and the .previous
		 * of the second.
		 */
		private static void join(Node a, Node b) {
			a.right = b;
			b.left = a;
		}

		/*
		 * helper function -- given two circular doubly linked lists, append them and
		 * return the new list.
		 */
		public static Node append(Node a, Node b) {
			// if either is null, return the other
			if (a == null)
				return (b);
			if (b == null)
				return (a);
			// find the last node in each using the .previous pointer
			Node aLast = a.left;
			Node bLast = b.left;
			// join the two together to make it connected and circular
			join(aLast, b);
			join(bLast, a);
			return a;
		}

		/*
		 * --Recursion-- Given an ordered binary tree, recursively change it into a
		 * circular doubly linked list which is returned.
		 */
		private static Node treeToList(Node root) {
			// base case: empty tree -> empty list
			if (root == null)
				return null;
			// Recursively do the subtrees (leap of faith!)
			Node aList = treeToList(root.left);
			Node bList = treeToList(root.right);
			// Make the single root node into a list length-1
			// in preparation for the appending
			root.left = root;
			root.right = root;
			// At this point we have three lists, and it's
			// just a matter of appending them together
			// in the right order (aList, root, bList)
			aList = append(aList, root);
			aList = append(aList, bList);
			return aList;
		}

		/*
		 * Given a non-empty tree, insert a new node in the proper place. The tree must
		 * be non-empty because Java's lack of reference variables makes that case and
		 * this method messier than they should be.
		 */
		public static void treeInsert(Node root, int newData) {
			if (newData <= root.data) {
				if (root.left != null)
					treeInsert(root.left, newData);
				else
					root.left = new Node(newData);
			} else {
				if (root.right != null)
					treeInsert(root.right, newData);
				else
					root.right = new Node(newData);
			}
		}

		// Do an inorder traversal to print a tree
		// Does not print the ending "\n"
		private static void printTree(Node root) {
			if (root == null)
				return;
			printTree(root.left);
			System.out.print(Integer.toString(root.data) + " ");
			printTree(root.right);
		}

		// Do a traversal of the list and print it out
		private static void printList(Node head) {
			Node current = head;
			while (current != null) {
				System.out.print(Integer.toString(current.data) + " ");
				current = current.right;
				if (current == head)
					break;
			}
		}

		// Demonstrate tree->list with the list 1..5
		public static void main(String[] args) {
			// first build the tree shown in the problem document
			// http://cslibrary.stanford.edu/109/
			Node root = new Node(10);
			root.left = new Node(12);
			root.right = new Node(15);
			root.left.left = new Node(25);
			root.left.right = new Node(30);
			root.right.left = new Node(36);

			System.out.println("tree:");
			printTree(root); // 1 2 3 4 5
			System.out.println();

			System.out.println("list:");
			Node head = treeToList(root);
			printList(head); // 1 2 3 4 5 yay!
		}
	}
}
