package dataStructures;

public interface HashTableMethods<K, V> {

	public V getValue(K key);
	
	public V search(K key);
	
	public void insert(K key, V value);
	
	public void delate(K key);
}
