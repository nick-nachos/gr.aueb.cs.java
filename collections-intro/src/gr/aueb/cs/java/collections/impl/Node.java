package gr.aueb.cs.java.collections.impl;

class Node<T> {

	public Node<T> next;
	public Node<T> previous;
	
	public T data;
	
	public Node() { 
		this(null);
	}
	
	public Node(T data) {
		this.data = data;
	}
	
	public void unlink() {
		this.next = null;
		this.previous = null;
		this.data = null;
	}
}
