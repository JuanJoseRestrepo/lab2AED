package model;

import dataStructures.*;

public class Dealer {
	
	private Queue<Horse> horses;
	private Stack<Horse> horsesRematch;
	private HashTable<Integer, User> gamblers;
	private int numberOfHorses;
	
	public Dealer() {
		super();
		this.horses = new Queue<Horse>();
		this.horsesRematch = new Stack<Horse>();
		this.gamblers = new HashTable<Integer, User>();
		this.numberOfHorses = 0;
	}
	
	
	
	public Queue<Horse> getHorses() {
		return horses;
	}

	public void setHorses(Queue<Horse> horses) {
		this.horses = horses;
	}

	public Stack<Horse> getHorsesRematch() {
		return horsesRematch;
	}

	public void setHorsesRematch(Stack<Horse> horsesRematch) {
		this.horsesRematch = horsesRematch;
	}

	public HashTable<Integer, User> getGamblers() {
		return gamblers;
	}

	public void setGamblers(HashTable<Integer, User> gamblers) {
		this.gamblers = gamblers;
	}
	
	public int getNumberOfHorses() {
		return numberOfHorses;
	}

	public void setNumberOfHorses(int numberOfHorses) {
		this.numberOfHorses = numberOfHorses;
	}



	public void addHorseQueue(Horse newHorse) {
		
		setNumberOfHorses(getNumberOfHorses()+1);
		newHorse.setRow(getNumberOfHorses());
		
		Node<Horse> newOne= new Node<Horse>(newHorse);
		getHorses().offer(newOne);
	
	}
	
	public void rematch() {
		
	}
	
	public void addGambler(User newGambler) {
		
		Integer theKey = newGambler.getId();
		gamblers.insert(theKey, newGambler);
		
	}
	
	
	
} //end of class
