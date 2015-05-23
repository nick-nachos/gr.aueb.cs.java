package gr.aueb.cs.java.collections.impl;

public class MyLinkedList<E> {

	private Node<E> head;
	private int size;
	
	public MyLinkedList() {
		this.head = new Node<E>();
		this.head.next = this.head;
		this.head.previous = this.head;
	}
	
	public int size() {
		return this.size;
	}
	
	public E get(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		
		Node<E> n = head;
		
		for (int i = 0; i <= index; i++) {
			n = n.next;
		}
		
		return n.data;
	}
	
	public void add(E o) {
		Node<E> n = new Node<E>(o);
		Node<E> last = this.head.previous;
		n.previous = last;
		n.next = this.head;
		last.next = n;
		this.head.previous = n;
		size++;
	}
	
	public boolean remove(Object o) {
		Node<E> toRemove = null;
		
		for (Node<E> n = this.head.next; n != this.head; n = n.next) {
			if (safeEquals(n.data, o)) {
				toRemove = n;
				break;
			}
		}
		
		if (toRemove == null) {
			return false;
		}
		
		Node<E> previous = toRemove.previous;
		Node<E> next = toRemove.next;
		previous.next = next;
		next.previous = previous;
		toRemove.unlink();
		size--;
		
		return true;
	}
	
	public void clear() {
		this.head.previous = this.head;
		this.head.next = this.head;
		this.size = 0;
	}
	
	private static boolean safeEquals(Object o1, Object o2) {
		if (o1 == null) {
			return o2 == null;
		}
		
		return o1.equals(o2);
	}
}
