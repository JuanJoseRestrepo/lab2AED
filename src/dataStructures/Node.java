package dataStructures;

public class Node<E> {

	public Node<E> next;
	public Node<E> prior;
		
	public Node(Node<E> next, Node<E> prior) {
		super();
		this.next = next;
		this.prior = prior;
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
