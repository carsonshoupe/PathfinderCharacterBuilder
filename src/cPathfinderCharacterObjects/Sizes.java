package cPathfinderCharacterObjects;

public enum Sizes {
	//Sizes:
	FINE(8, -16, 16, 0, 6, 0, (1/8), .5, 0, 0), 
	DIMINUTIVE(4, -12, 12, 6, 12, (1/8), 1, 1, 0, 0), 
	TINY(2, -8, 8, 1, 2, 1, 8, 2.5, 0, 0), 
	SMALL(1, -4, 4, 2, 4, 8, 60, 5, 5, 5), 
	MEDIUM(0, 0, 0, 4, 8, 60, 500, 5, 5, 5), 
	LARGE(-1, 4, -4, 8, 16, 500, 4000, 10, 10, 5), 
	HUGE(-2, 8, -8, 16, 32, 4000, 32000, 15, 15, 10), 
	GARGANTUAN(-4, 12, -12, 32, 64, 32000, 250000, 20, 20, 15), 
	COLOSSAL(-8, 16, -16, 64, 1000, 250000, 10000000, 30, 30, 20); 
	
	//Constructor:
	Sizes(int sizeModifier, int grapleModifier,int hideModifier, int heightOrlength_Min, int heightOrLength_Max, 
			double weight_Min, double weight_Max, double space, int naturalReach_Tall, int naturalReach_Long) {
		this.sizeModifier = sizeModifier;
		this.grapleModifier = grapleModifier;
		this.hideModifier = hideModifier;
		this.heightOrLength_Min = heightOrlength_Min;
		this.heightOrLength_Max = heightOrLength_Max;
		this.weight_Min = weight_Min;
		this.weight_Max = weight_Max;
		this.space = space;
		this.naturalReach_Tall = naturalReach_Tall;
		this.natrualReach_Long = naturalReach_Long;
	}
	
	//Instance Variables: 
	private int sizeModifier;
	private int grapleModifier;
	private int hideModifier; 
	private int heightOrLength_Min; //in inches
	private int heightOrLength_Max; //in inches
	private double weight_Min;
	private double weight_Max;
	private double space; //in feet
	private int naturalReach_Tall;
	private int natrualReach_Long;
	
	//Methods: 
	public int getSizeModifier() {return this.sizeModifier;}
	public int getGrapleModifier() {return this.grapleModifier;}
	public int getHideModifier() {return this.hideModifier;}
	public int getHeightOrLength_Min() {return this.heightOrLength_Min;}
	public int getHeightOrLenght_Max() {return this.heightOrLength_Max;}
	public double getWeight_Min() {return this.weight_Min;}
	public double getWeight_Max() {return this.weight_Max;}
	public double getSpace() {return this.space;}
	public int getNaturalReach_Tall() {return this.naturalReach_Tall;}
	public int getNatrualReach_Long() {return this.natrualReach_Long;}
}
