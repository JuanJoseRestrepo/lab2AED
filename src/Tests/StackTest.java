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
	
	
	@Test
	void test() {
		setupEscenario();
		assertEquals(stack.peek().getInfo(),3);
	}
	
	@Test
	void testPopStack() {
		setupEscenario();
		stack.pop();
		assertEquals(stack.peek().getInfo(),2);
	}

	@Test
	void testIsEmpty(){
		setupEscenario();
		assertFalse(stack.isEmpty(),"Esta vacio");
	}
	
	@Test
	void testIsEmpty1() {
		setupEscenario();
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty(),"Esta lleno");
	}
	
}
