package dataStructures;

public interface StackMethods<E> {

	public void push(Node<E> event);
	
	public boolean isEmpty();
	
	public Node<E> peek();
	
	public Node<E> pop();
	
	public int size();
	
}
