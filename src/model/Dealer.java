package model;

import java.util.ArrayList;
import java.util.Arrays;

import dataStructures.*;

public class Dealer {
	
	private Queue<Horse> horses;
	private Stack<Horse> horsesRematch;
	private HashTable<Integer, User> gamblers;
	private int numberOfHorses;
	private ArrayList<String> horsesNames;
	private ArrayList<String> horsesNamesRematch;
	 
	public Dealer() {
		super();
		horsesNames = new ArrayList<String>();
		horsesNamesRematch = new ArrayList<String>();
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



	public boolean addHorseQueue(Horse newHorse) {
		boolean possible = false;
		if (getNumberOfHorses()<10) {
			setNumberOfHorses(getNumberOfHorses()+1);
			newHorse.setRow(getNumberOfHorses());
			
			Node<Horse> newOne= new Node<Horse>(newHorse);
			getHorses().offer(newOne);
			possible = true;
		}
		
		return possible;
	
	}
	
	//WHEN THE PARAMETER IS TRUE, IT WILL SET THE WINNERS FOR THE STACK, OTHERWISE IT WILL BE FOR THE QUEUE
	
	public void setWinners(boolean rematch) {
		Node<Horse> firstHorse = getHorses().peek();
		
		if (rematch) {
			firstHorse = getHorsesRematch().peek();
			setNumberOfHorses(getHorsesRematch().size());
		}
		
		ArrayList<Horse> positionsGiven = new ArrayList<Horse>();
		positionsGiven.add(null);
		
		while (firstHorse != null) {
			positionsGiven.add(firstHorse.getInfo());
			firstHorse = firstHorse.getNext();
		}
		
		int pos = 1;
		while (pos <= getNumberOfHorses()) {
			double posD = Math.random()* (positionsGiven.size());
			int posI = (int) posD;
			
			if (posI != 0 && positionsGiven.get(posI).getPosition() == -1) {
				positionsGiven.get(posI).setPosition(pos);
				positionsGiven.remove(posI);
				++pos;
			}
			
		}
		
	}
	
	//THE ONLY WAY TO INVOCATE THIS METHOD, IS IF THERE IS ALREADY A QUEUE AND THE RACE IS OVER
	//, OTHERWISE IT WONT WORK
	
	public void fillStack4Rematch() {
		
		Node<Horse>[] sortedByPosition = new Node[getNumberOfHorses()+1];
		while (horses.isEmpty() == false) {
			Node<Horse> nodeInMatter = horses.poll();
			int pos = nodeInMatter.getInfo().getPosition();
			sortedByPosition[pos] = nodeInMatter;
			
		}
		
		int rowNumber =1; 
		int i = sortedByPosition.length;
		--i;
		
		while (i>0) {
			Node<Horse> best = sortedByPosition[i];
			horsesNamesRematch.add(best.getInfo().getHorseName());
			horsesRematch.push(best);
			best.getInfo().setPosition(-1);
			best.getInfo().setRow(rowNumber);
			
			--i;
			++rowNumber;
			
		}
		
		
	}
	
	public ArrayList<String> getHorsesNamesRematch() {
		return horsesNamesRematch;
	}



	public void setHorsesNamesRematch(ArrayList<String> horsesNamesRematch) {
		this.horsesNamesRematch = horsesNamesRematch;
	}



	public void addGambler(User newGambler) {
		
		Integer theKey = newGambler.getId();
		gamblers.insert(theKey, newGambler);
		
	}
	
	public void startRace() {
		generateHorses();
		//start counting time
		//add gambler able
		//3'after gambles are closed;
	}
	
	public void rematch() {
		fillStack4Rematch();
	
		
	}
	
	
	public void generateHorses() {
		int numberH = 0;
		while (numberH < 7) {
			double numberD = Math.random()*11;	
			numberH = (int) numberD;
		}
		 
		String[] names4Horses = {"Junior", "King", "Meliodas", "Alfonso", "Roberto", "Neegan", "Rick", "Tony", "Jairo", "Freddy","Berthe","Reynard","Fredelia","Anthony","Emmye","Wandis","Tiphani","Robin","Anica","Egor","Sigfried","Anya","Ardin","Loni","Lexine","Tye","Maria","Gwendolen","Tyler","Cyndi","Glenine","Raymond","Bill","Tonia","Deeanne","Gabriel","Yun","Santiago","Gord","Lilo","Stitch","Cesar","Rubius","Mangel","Alex","Ruben","Ramiro","Karlos","Selena","Helena","Daisy","Yom","Stephani","Winston","Zac","Zachary","Kino","Diego","Torr","Juano","Buga"};		String[] names4People = {"Alfonso", "Esteban", "Kevin", "Charles", "Pedro", "Donald", "Ricardo", "Valerio", "Samuel", "Troy"};
		String[] lastName4People = {"Cartman", "Sanchez", "Rincon", "McGill", "Trump", "Da Vinci", "Uzumaki", "Uchiha", "Liones", "Santana"};
		
		while (numberH>0) {
			double nameH = Math.random()*35;	
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
	
	public Horse[] sortByPosition(boolean valueRematch) {
		Node<Horse> first = null;
		
		if (valueRematch) {
			first = getHorsesRematch().peek();
		} else {
			first = getHorses().peek();
		} 
		
		Horse[] horsesSorted = new Horse[getNumberOfHorses()+1];
		
		while (first != null) {
			horsesSorted[first.getInfo().getPosition()] = first.getInfo();		
			first = first.getNext();
		}
		
		return horsesSorted;
		
	}
	
	public User search4Gambler(String key) {
		int keyI = Integer.parseInt(key);
		User found = getGamblers().search(keyI);
		
		return found;
	}
	
} //end of class
