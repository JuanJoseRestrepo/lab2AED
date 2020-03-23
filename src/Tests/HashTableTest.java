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
	
		table.insert(233, 140);
		table.insert(0, 160);
		table.insert(0, 140);
	}
	
	private void setUpEscenario1() {
		table = new HashTable<Integer,Integer>();
	}
	
	private void setupEscenario2() {
		table = new HashTable<Integer,Integer>();
		table.insert(15, 140);
	}
//-------------------------------------------------------------------------------------------------------	
	@Test
	void test() {
		setupEscenario();
		assertEquals(table.getValue(0),140);
	}
	@Test
	void testGetValueHash() {
		setUpEscenario1();
		assertEquals(table.getValue(200),null);
	}
	@Test
	void testGetValueHash1() {
		setupEscenario2();
		assertEquals(table.getValue(15),140);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	void testSearchValue() {
		setupEscenario();
		assertEquals(table.search(233),140);
	}
	
	@Test
	void testSearchValue1() {
		setUpEscenario1();
		assertEquals(table.search(16),null);
	}
	
	@Test
	void testSearchTable2() {
		setupEscenario2();
		assertEquals(table.search(15),140);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	void testInsertHash() {
		setupEscenario();
		table.insert(16,3012);
		assertEquals(table.search(16),3012);
	}
	
	@Test
	void testInsertHash1() {
	setUpEscenario1();
	table.insert(15, 16000);
	assertEquals(table.search(15),16000);
	}
	
	@Test
	void testInsertHash2() {
		setupEscenario2();
		table.insert(0, 33);
		assertEquals(table.search(0),33);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	void testDelateHash(){
		setupEscenario();
		table.delate(15);
		assertEquals(table.search(0),140);
	}
	
	
	@Test
	void testDelateHash1(){
		setUpEscenario1();
		table.delate(16);
		assertEquals(table.search(16),null);
	}
	
	@Test
	void testDelateHash2(){
		setupEscenario2();
		table.delate(15);
		assertEquals(table.search(15),null);
	}
	
	
//-------------------------------------------------------------------------------------------------------	

}
