package model;

public class Horse {
	
	private String horsemanName;
	private String horseName;
	private int row;
	private int position;
	
	public Horse(String horsemanName, String horseName) {
		super();
		this.horsemanName = horsemanName;
		this.horseName = horseName;
		this.row = -1;
		this.position = -1;
	}

	public String getHorsemanName() {
		return horsemanName;
	}

	public void setHorsemanName(String horsemanName) {
		this.horsemanName = horsemanName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
	

} //end of class
