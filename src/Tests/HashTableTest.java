package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.HashTable;
import dataStructures.NodeH;

class HashTableTest {

	private NodeH<Integer,Integer>[] hashTable;
	private HashTable<Integer,Integer> table;
	
	private void setupEscenario() {
		table = new HashTable<Integer,Integer>();
		hashTable = table.getNodes();
	
		table.insert(15, 140);
		table.insert(15, 160);
		table.insert(0, 140);
	}
	
	@Test
	void test() {
		setupEscenario();
		assertEquals(table.getValue(15),140);
	}

}
