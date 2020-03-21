package dataStructures;

public class Queue<E> implements QueueMethods<E>{
	
	private Node<E> back;
	private Node<E> front;

	public Queue() {
		this.back = null;
		this.front = null;
	}

	

	public Node<E> getBack() { //last element
		return back;
	}

	public void setBack(Node<E> back) {
		this.back = back;
	}
	
	
	public Node<E> peek() { //first element
		return front;
	}

	public void setFront(Node<E> front) {
		this.front = front;
	}


	@Override
	public boolean isEmpty() {
		boolean empty = false;
		
		if(peek() == null) {
			empty = true;
		}
	
		return empty;
		
	}

	@Override
	public Node<E> poll() {
		Node<E> theOne = peek();
		
		if (theOne != null) {
			
			Node<E> next2TheOne = theOne.getNext();
			if (next2TheOne != null) {
				next2TheOne.setPrior(null);
			}
			setFront(next2TheOne);
		}

		return theOne;
	}

	@Override
	public void offer(Node<E> newElement) {
		Node<E> lastNode = getBack() ;
		if (lastNode != null) {
			lastNode.setNext(newElement);
			newElement.setPrior(lastNode);
		} else {
			setFront(newElement);
		}
		
		setBack(newElement);
	}

	@Override
	public int size() {
		int number = 0;
		Node<E>  last = peek();
		
		while(last != null) {
			++number;
			last = last.getNext();
			
		}
		
		return number;
		
	}
	
	
	public void clearQueue() {
		setFront(null);
	}
	

	

} //end of class
