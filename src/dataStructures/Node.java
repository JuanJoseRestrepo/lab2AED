package dataStructures;

public class Node<E> {

	private Node<E> next;
	private Node<E> prior;
	private E info;
	
		
	public Node(E info) {
		super();
		this.next = null;
		this.prior = null;
		this.info = info;
	}
	
	
	public E getInfo() {
		return info;
	}


	public void setInfo(E info) {
		this.info = info;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> newElement) {
		this.next = newElement;
	}
	public Node<E> getPrior() {
		return prior;
	}
	public void setPrior(Node<E> prior) {
		this.prior = prior;
	}
	
	
} //end of class
