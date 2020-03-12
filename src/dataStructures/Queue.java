package dataStructures;

public class Queue<E> implements QueueMethods<E>{
	
	private Node<E> firstNodeQ;
	
	

	public Node<E> getFirstNodeQ() {
		return firstNodeQ;
	}

	public void setFirstNodeQ(Node<E> firstNodeQ) {
		this.firstNodeQ = firstNodeQ;
	}

	@Override
	public void push(Node<E> event) {
		Node<E>  last = firstNodeQ;
		
		if(firstNodeQ != null) {
			
			firstNodeQ = firstNodeQ.getNext();
			last.setPrior(null);
			last = firstNodeQ;
		}
		
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		Node<E>  last = firstNodeQ;
		
		if(last == null) {
			empty = true;
		}
	
		return empty;
		
	}

	@Override
	public Node<E> poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void offer(Node<E> newElement) {
		Node<E> lastNode = getLastElement() ;
		if (lastNode != null) {
			lastNode.setNext(newElement);
			newElement.setPrior(lastNode);
		} else {
			setFirstNodeQ(newElement);
		}
		
	}

	@Override
	public int size() {
		int number = 0;
		Node<E>  last = firstNodeQ;
		
		while(last != null) {
			last = last.getNext();
			number++;
		}
		
		return number;
		
	}
	
	public Node<E> getLastElement() {
		Node<E>  last = getFirstNodeQ();
		
		if (last != null) {
			
			while (last.getNext() != null) {
				last = (Node<E>) last.getNext(); 	
			}
			
		}
		
		return last;
		
	}
	

} //end of class
