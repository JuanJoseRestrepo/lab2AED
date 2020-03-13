package dataStructures;

public class NodeH<K, V> {

	private K key;
	private V value;
	
	private NodeH<K, V> nextNodeH;
	private NodeH<K, V> priorNodeH;
	
	public NodeH(K key,V value) {
		this.key = key;
		this.value = value;
		this.nextNodeH = null;
		this.priorNodeH = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public NodeH<K, V> getNextNodeH() {
		return nextNodeH;
	}

	public void setNextNodeH(NodeH<K, V> newElement) {
		this.nextNodeH = newElement;
	}
	public NodeH<K, V> getPriorNodeH() {
		return priorNodeH;
	}
	public void setPriorNodeH(NodeH<K, V> prior) {
		this.priorNodeH = prior;
	}
	
	
	
	
} //end of class
