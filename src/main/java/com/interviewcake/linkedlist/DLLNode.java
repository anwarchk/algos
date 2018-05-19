package com.interviewcake.linkedlist;

public class DLLNode<T> extends Node<T> {

	private DLLNode<T> prev;

	public DLLNode(final T value) {
		super(value);
		prev = null;
	}

	public DLLNode<T> getPrev() {
		return prev;
	}

	public void setPrev(final DLLNode<T> prev) {
		this.prev = prev;
	}

}
