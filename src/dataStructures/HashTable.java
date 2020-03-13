package dataStructures;

public class HashTable<K,V> implements HashTableMethods<K, V> {
	
	public final static int ARRAY_SIZE = 233;
	
	private NodeH<K, V>[] nodes;
	
	public HashTable() {
		nodes = (NodeH<K,V>[])new NodeH[ARRAY_SIZE];
	}
	
	public int index(K key) {
		int index = key.hashCode() % ARRAY_SIZE;
		return index;
	}
	
	@Override
	public V getValue(K key) {
		
		NodeH<K, V> newKey = nodes[index(key)];
		V value = null;
		if(newKey != null) {
			
			while(newKey != null) {
				
				if(newKey.getKey().equals(key)) {
					value = newKey.getValue();
				}
				newKey = newKey.getNextNodeH();
			}
			
		}
		return value;
	}

	@Override
	public V search(K key) {
		V newValue = getValue(key);
		
		return newValue;
	}

	@Override
	public void insert(K key, V value) {
		
		NodeH<K,V> newNodeH = nodes[index(key)];
		
		if(newNodeH == null) {
			
			newNodeH = new NodeH<>(key,value);
			
			nodes[index(key)] = newNodeH;
			
		}else {
			
			while(newNodeH != null) {
				
				if(newNodeH.getKey().equals(key)) {
					newNodeH.setValue(value);
				}
				newNodeH = newNodeH.getNextNodeH();
			}
			
			newNodeH = nodes[index(key)];
			NodeH<K, V> newNodeH2 = new NodeH<K,V>(key, value);
			newNodeH2.setNextNodeH(newNodeH);
			newNodeH.setPriorNodeH(newNodeH2);
			nodes[index(key)] = newNodeH2;
		}
		
	}

	@Override
	public void delete(K key) {
		
		NodeH<K,V> nodeActual = nodes[index(key)];
		
		if(nodeActual != null){
			
			while(nodeActual != null) {
				
				if(nodeActual.getKey().equals(key)) {
					
					
					
				}
				nodeActual = nodeActual.getNextNodeH();
			}
			
			
		}
		
	}

	
	
} //end of class
