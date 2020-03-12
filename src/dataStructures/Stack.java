package dataStructures;

public class Stack<E> implements StackMethods<E> {

	
	public Node<E> firstNodeS;
	
	

	public Stack(Node<E> firstNodeS) {
		this.firstNodeS = firstNodeS;
	}


	public void setFirstNodeS(Node<E> firstNodeS) {
		this.firstNodeS = firstNodeS;
	}
	

	public Node<E> getFirstNodeS() {
		return firstNodeS;
	}
	
	@Override
	public void push(Node<E> event) {
		Node<E> first = getLastElement();
		
		if(first != null) {
			first.setNext(event);
			event.setPrior(first);
		}else {
			setFirstNodeS(event);
		}
		
		
	}

	@Override
	public boolean isEmpty() {
		 Node<E> first = firstNodeS;
		 boolean empty = false;
		 
		 if(first == null) {
			 empty = true;
		 }
		 
		 return empty;
		 
	}

	@Override
	public Node<E> peek() {
		// TODO Auto-generated method stub
		Node<E> element = getLastElement();
		
		return element;
	}

	@Override
	public Node<E> pop() {
		 Node<E> first = firstNodeS;
		
		 if(first != null) {
			 //Obtiene el ultimo por ejemplo tenemos [1,2,3,4| y 4 es el ultimo
			 Node<E> last = getLastElement();
			 //de aqui obtenemos el 3
			 Node<E> aux = last.getPrior();
			 //Aqui eliminamos el 4 
			 aux.setNext(last.getNext());
			 
			 first = last;
			 
		 }
		 
		return first;
	}

	@Override
	public int size() {
		int number = 0;
		Node<E> first = firstNodeS;
		
		while(first != null) {
			
			first = first.getNext();
			number++;
		}
		
		
		return number;
	}
	
	public Node<E> getLastElement() {
		Node<E>  last = getFirstNodeS();
		
		if (last != null) {
			
			while (last.getNext() != null) {
				last = (Node<E>) last.getNext(); 	
			}
			
		}
		
		return last;
		
	}

} //end of class
