package dataStructures;

public interface QueueMethods<E> {

	public void push(Node<E> event);
	
	public boolean isEmpty();
	
	public Node<E> poll();
	
	public void offer(Node<E> input);
	
	public int size();
	
}
