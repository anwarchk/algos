package com.anwar;

public class ReverseALinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList.Node head = new LinkedList.Node(85);
		head.next = new LinkedList.Node(15);
		head.next.next = new LinkedList.Node(4);
		head.next.next.next = new LinkedList.Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}

	// Java program for reversing the linked list

	static class LinkedList {
		static class Node {
			int data;
			Node next;

			public Node(int d) {
				data = d;
				next = null;
			}
		}

		/* Function to reverse the linked list */
		Node reverse(Node node) {
			Node prev = null;
			Node current = node;
			Node next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			node = prev;
			return node;
		}

		// prints content of double linked list
		void printList(Node node) {
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}

	}
}
