package cPathfinderCharacterObjects;

public enum Alignment {
	CHAOTICGOOD("Chaotic", "Good"), 
	NEUTRALGOOD("Neutral", "Good"), 
	LAWFULGOOD("Lawful", "Good"), 
	CHAOTICNEUTRAL("Chaotic", "Neutral"), 
	TRUENEUTRAL("Neutral", "Neutral"), 
	LAWFULNEUTRAL("Lawful", "Neutral"), 
	CHAOTICEVIL("Chaotic", "Evil"), 
	NEUTRALEVIL("Neutral", "Evil"), 
	LAWFULEVIL("Lawful", "Evil");
	
	//Instance Variables: 
	private String chaoticToLawful;
	private String evilToGood;
	
	//Constructors:
	Alignment(String chaoticToLawful, String evilToGood) {
		this.chaoticToLawful = chaoticToLawful;
		this.evilToGood = evilToGood;
	}
	
	public String getChaoticToLawful() {return this.chaoticToLawful;}
	public String getevilToGood() {return this.evilToGood;}

}
