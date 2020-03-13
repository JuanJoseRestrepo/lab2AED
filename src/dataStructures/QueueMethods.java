package dataStructures;

public interface QueueMethods<E> {

	public Node<E> peek();
	
	public boolean isEmpty();
	
	public Node<E> poll();
	
	public void offer(Node<E> input);
	
	public int size();
	
}
