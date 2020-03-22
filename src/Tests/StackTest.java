package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.*;

class StackTest {

	private Stack<Integer> stack;
	
	private void setupEscenario() {
		stack = new Stack<Integer>();
		Node q1 =  new Node(1);
		Node q2 = new Node(2);
		Node q3 = new Node(3);
		stack.push(q1);
		stack.push(q2);
		stack.push(q3);
	}
	
	private void setupEscenario1() {
		stack = new Stack<Integer>();
	}
	
	private void setupEscenario2() {
		stack = new Stack<Integer>();
		Node q1 =  new Node(1);
		stack.push(q1);
	}
//------------------------------------------------------------------------------------------------------------	
	@Test
	void test() {
		setupEscenario();
		assertEquals(stack.peek().getInfo(),3);
	}
	
	@Test
	void testPeek() {
		setupEscenario1();
		assertEquals(stack.peek(),null);
	}
	
	@Test
	void testPeek1() {
		setupEscenario2();
		assertEquals(stack.peek().getInfo(),1);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	void testPopStack() {
		setupEscenario();
		stack.pop();
		assertEquals(stack.peek().getInfo(),2);
	}
	
	@Test
	void testPopStack1() {
		setupEscenario1();
		stack.pop();
		assertEquals(stack.peek(),null);
	}
	
	@Test
	void testPopStack2() {
		setupEscenario2();
		stack.pop();
		assertEquals(stack.peek(),null);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void testIsEmpty(){
		setupEscenario1();
		
		assertTrue(stack.isEmpty(),"Esta lleno");
	}
	
	@Test
	void testIsEmpty1() {
		setupEscenario();
		assertFalse(stack.isEmpty(),"Esta vacio");
	}
	@Test
	void testIsEmpty2() {
		setupEscenario2();
		assertFalse(stack.isEmpty(),"Esta vacio");
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	@Test
	void testPushStack() {
		setupEscenario();
		Node q1 = new Node(5);
		stack.push(q1);
		
		assertEquals(stack.peek().getInfo(),5);
		
	}
	
	@Test
	void testPushStack1() {
		setupEscenario1();
		Node q1 = new Node(1);
		stack.push(q1);
		
		assertEquals(stack.peek().getInfo(),1);
	}
	
	@Test
	void testPushStack2() {
		setupEscenario2();
		Node q1 = new Node(2);
		stack.push(q1);
		
		assertEquals(stack.peek().getInfo(),2);
	}
	
//------------------------------------------------------------------------------------------------------------	

	
}