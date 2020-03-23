package dataStructures;

public class HashTable<K,V> implements HashTableMethods<K, V> {
	
	public final static int ARRAY_SIZE = 233;
	
	private NodeH<K, V>[] nodes;
	
	public HashTable() {
		nodes = (NodeH<K,V>[])new NodeH[ARRAY_SIZE];
	}
	
	public void clearNodes() {
		nodes = (NodeH<K,V>[])new NodeH[ARRAY_SIZE];
	}
	
	public int index(K key) {
		int index = key.hashCode() % ARRAY_SIZE;
		return index;
	}
	
	public NodeH<K, V>[] getNodes() {
		return nodes;
	}

	public void setNodes(NodeH<K, V>[] nodes) {
		this.nodes = nodes;
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
		
		NodeH<K,V> checkNode = nodes[index(key)];
		
		if(checkNode == null) {
			
			checkNode = new NodeH<>(key,value);
			
			nodes[index(key)] = checkNode;
			
		}else {
			
			while(checkNode != null) {
				
				if(checkNode.getKey().equals(key)) {
					checkNode.setValue(value);
					return;
				}
				checkNode = checkNode.getNextNodeH();
			}
			
			checkNode = nodes[index(key)];
			NodeH<K, V> newNodeH2 = new NodeH<K,V>(key, value);
			newNodeH2.setNextNodeH(checkNode);
			checkNode.setPriorNodeH(newNodeH2);
			nodes[index(key)] = newNodeH2;
		}
		
	}

	@Override
	public void delate(K key) {
		//TODO
		NodeH<K,V> nodeActual = nodes[index(key)];
		
		if(nodeActual == null){
			return;
			
		}else {

			while(nodeActual != null ) {
				
				if(nodeActual.getKey().equals(key)) {
					if(nodeActual.getPriorNodeH() != null) {
						nodeActual.getPriorNodeH().setNextNodeH(nodeActual.getNextNodeH());
					}
				 	if(nodeActual.getNextNodeH() != null) {
				 		nodeActual.getNextNodeH().setPriorNodeH(nodeActual.getPriorNodeH());
				 	}
					nodeActual = nodeActual.getNextNodeH();
					nodes[index(key)] = nodeActual;
					return;
				}
					nodeActual = nodeActual.getNextNodeH();

			}
		
		}
	
	}

	
	
} //end of class
