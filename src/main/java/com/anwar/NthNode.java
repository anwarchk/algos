package com.anwar;

public class NthNode {
	Node head; // head of the list

	/* Linked List node */
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to get the nth node from end of list */
	private static Node removeNthNode(Node head, int n) {

		Node first = head;
		Node second = head;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 0; i <= n; i++) {
			if (first == null) {
				return head;
			}
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			second = second.next;
			first = first.next;
		}
		second.next = second.next.next;

		// Node curr = head, temp;
		//
		// for (int i = 0; i < n; i++) {
		// curr = curr.next;
		// }
		// temp = head;
		//
		// if (curr == null) {
		// head = head.next;
		// } else {
		// while (curr.next != null) {
		// curr = curr.next;
		// temp = temp.next;
		// }
		// temp.next = temp.next.next;
		// }
		 return head;
	}

	/* Drier program to test above methods */
	public static void main(String[] args) {
		Node node = new Node(20);
		Node head = node, temp = node;

		node = new Node(4);
		temp.next = node;
		temp = temp.next;

		node = new Node(15);
		temp.next = node;
		temp = temp.next;

		node = new Node(35);
		temp.next = node;
		temp = temp.next;

		node = new Node(50);
		temp.next = node;

		temp = head;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

		head = removeNthNode(head, 5);

		temp = head;

		System.out.println("\n");

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
