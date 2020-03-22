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
		Node q4 =  new Node(4);
		Node q5 = new Node(5);
		Node q6 = new Node(6);
		Node q7 =  new Node(7);
		Node q8 = new Node(8);
		Node q9 = new Node(9);
		
		queue.offer(q1);
		queue.offer(q2);
		queue.offer(q3);
		queue.offer(q4);
		queue.offer(q5);
		queue.offer(q6);
		queue.offer(q7);
		queue.offer(q8);
		queue.offer(q9);
	}
	
	private void setupEscenario1() {
		queue = new Queue<Integer>();
	}
	
	private void setupEscenario2() {
		queue = new Queue<Integer>();
		Node q1 =  new Node(1);
		queue.offer(q1);
	}
	
//-------------------------------------------------------------------------------------------------------	
	@Test
	void test() {
		setupEscenario();
		assertEquals(queue.peek().getInfo(),1);
	}
	
	@Test
	void testPeek() {
		setupEscenario1();
		assertTrue(queue.peek() == null, "Esta malo");
	}
	
	@Test
	void testPeek1() {
		setupEscenario2();
		assertEquals(queue.peek().getInfo(),1);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	void testPollQueue() {
		setupEscenario();
		queue.poll();
		queue.poll();
		assertEquals(queue.peek().getInfo(),3);
	}
	
	@Test
	void testPollQueue1(){
		setupEscenario1();
		queue.poll();
		assertEquals(queue.peek(),null);
	}
	
	@Test
	void testPollQueu2() {
		setupEscenario2();
		queue.poll();
		assertTrue(queue.peek() == null, "Esta mal");
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	void testPollOffer() {
		setupEscenario();
		Node q2 = new Node(4);
		queue.offer(q2);
		assertEquals(queue.getBack().getInfo(),4);
	}
	
	@Test
	void testPollOffer1() {
		setupEscenario1();
		Node q2 = new Node(1);
		queue.offer(q2);
		assertTrue(queue.peek().getInfo() == 1, "ta malo");
	}
	
	@Test
	void testPollOffer2() {
		setupEscenario2();
		Node q2 = new Node(2);
		queue.offer(q2);
		assertEquals(queue.getBack().getInfo(),2);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Test
	void testIsEmpty() {
		setupEscenario1();
		assertTrue(queue.isEmpty(),"Esta vacio");
	}
	
	@Test
	void testIsEmpty1() {
		setupEscenario();
		assertTrue(queue.isEmpty() == false,"No esta vacio");
	}
	
	@Test
	void testIsEmpty2() {
		setupEscenario2();
		assertTrue(queue.isEmpty() == false, "Esta vacio");
	}
	
//-------------------------------------------------------------------------------------------------------	

	
}