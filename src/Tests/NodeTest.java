package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.*;

class NodeTest{

	private Queue<Integer> queue;
	
	private void setupEscenario() {
		queue = new Queue<Integer>();
		
		Node q1 =  new Node(1);
		Node q2 = new Node(2);
		Node q3 = new Node(3);
		
		queue.offer(q1);
		queue.offer(q2);
		queue.offer(q3);
	}
	@Test
	void test() {
		setupEscenario();
		assertEquals(queue.peek().getInfo(),1);
	}

	@Test
	void testPollQueue() {
		setupEscenario();
		queue.poll();
		queue.poll();
		assertEquals(queue.peek().getInfo(),3);
	}
	
	@Test
	void testPollOffer() {
		setupEscenario();
		Node q2 = new Node(4);
		queue.offer(q2);
		assertEquals(queue.getBack().getInfo(),4);
	}
	
	@Test
	void testIsEmpty() {
		setupEscenario();
		assertFalse(queue.isEmpty(),"Esta vacio");
	}
	
	@Test
	void testIsEmpty1() {
		setupEscenario();
		queue.poll();
		queue.poll();
		queue.poll();
		assertTrue(queue.isEmpty(),"No esta vacio");
	}
	
}