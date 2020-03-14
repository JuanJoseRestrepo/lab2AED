package dataStructures;

public class Stack<E> implements StackMethods<E> {

	
	public Node<E> firstNodeS;
	
	

	public Stack(Node<E> firstNodeS) {
		this.firstNodeS = firstNodeS;
	}


	public void setFirstNodeS(Node<E> firstNodeS) {
		this.firstNodeS = firstNodeS;
	}
	
	@Override
	public Node<E> peek() {
		return firstNodeS;
	}
	
	@Override
	public void push(Node<E> event) {
		Node<E> first = peek();
		
		if(first != null) {
			event.setNext(first);
			first.setPrior(event);
		}
		setFirstNodeS(event);
		
	}

	@Override
	public boolean isEmpty() {
		 Node<E> first = peek();
		 boolean empty = false;
		 
		 if(first == null) {
			 empty = true;
		 }
		 
		 return empty;
		 
	}


	@Override
	public Node<E> pop() {
		 Node<E> first = peek();
		 
		 if(first != null) {
			
			 Node<E> aux = first.getNext();
			 
			 if(aux != null) {
				 aux.setPrior(null);
			 }else {
				setFirstNodeS(aux);
				
			 }
		 }
		 
		return first;
	}

	@Override
	public int size() {
		int number = 0;
		Node<E> first = peek();
		
		while(first != null) {
			++number;
			first = first.getNext();
			
		}
		
		
		return number;
	}
	

} //end of class
