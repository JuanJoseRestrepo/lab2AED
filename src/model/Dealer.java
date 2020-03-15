package model;

import java.util.ArrayList;

import dataStructures.*;

public class Dealer {
	
	private Queue<Horse> horses;
	private Stack<Horse> horsesRematch;
	private HashTable<Integer, User> gamblers;
	private int numberOfHorses;
	private ArrayList<String> horsesNames;
	
	public Dealer() {
		super();
		horsesNames = new ArrayList<String>();
		this.horses = new Queue<Horse>();
		this.horsesRematch = new Stack<Horse>();
		this.gamblers = new HashTable<Integer, User>();
		this.numberOfHorses = 0;
	} 
	
	
	
	public ArrayList<String> getHorsesNames() {
		return horsesNames;
	}



	public void setHorsesNames(ArrayList<String> horsesNames) {
		this.horsesNames = horsesNames;
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
		//TODO
		fillStack4Rematch();
		
	}
	
	public void fillStack4Rematch() {
		Node<Horse>[] sortedByPosition = new Node[getNumberOfHorses()];
		
		while (horses.isEmpty() == false) {
			Node<Horse> nodeInMatter = horses.poll();
			int pos = nodeInMatter.getInfo().getPosition();
			--pos;
			sortedByPosition[pos] = nodeInMatter;
			
		}
		int rowNumber =1;
		int i = sortedByPosition.length;
		--i;
		while (i>=0) {
			Node<Horse> best = sortedByPosition[i];
			horsesRematch.push(best);
			best.getInfo().setPosition(-1);
			best.getInfo().setRow(rowNumber);
			
			--i;
			++rowNumber;
			
		}
		
	}
	
	public void addGambler(User newGambler) {
		
		Integer theKey = newGambler.getId();
		gamblers.insert(theKey, newGambler);
		
	}
	
	public void generateHorses() {
		int numberH = 0;
		while (numberH < 7) {
			double numberD = Math.random()*11;	
			numberH = (int) numberD;
		}
		
		String[] names4Horses = {"Junior", "King", "Meliodas", "Alfonso", "Roberto", "Neegan", "Rick", "Tony", "Jairo", "Freddy"};
		String[] names4People = {"Alfonso", "Esteban", "Kevin", "Charles", "Pedro", "Donald", "Ricardo", "Valerio", "Samuel", "Troy"};
		String[] lastName4People = {"Cartman", "Sanchez", "Rincon", "McGill", "Trump", "Da Vinci", "Uzumaki", "Uchiha", "Liones", "Santana"};
		
		while (numberH>0) {
			double nameH = Math.random()*10;	
			double nameP = Math.random()*10;	
			double lastNameP = Math.random()*10;	
			
			int nameh = (int)nameH;
			int namep = (int)nameP;
			int lastNamep = (int)lastNameP;
			
			Horse newHorse = new Horse(names4People[namep]+" "+lastName4People[lastNamep], names4Horses[nameh]);
			horsesNames.add(newHorse.getHorseName());
			addHorseQueue(newHorse);
			--numberH;
		}
		
	}
	
	
	
} //end of class
