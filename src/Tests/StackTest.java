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
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
