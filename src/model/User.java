package model;

public class User {
	
	private int id;
	private String name;
	private double amount;
	
	private Horse myWinnerHorse;

	public User(int id, String name, double amount, Horse myWinnerHorse) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.myWinnerHorse = myWinnerHorse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Horse getMyWinnerHorse() {
		return myWinnerHorse;
	}

	public void setMyWinnerHorse(Horse myWinnerHorse) {
		this.myWinnerHorse = myWinnerHorse;
	}
	
	
	
} //end of class
