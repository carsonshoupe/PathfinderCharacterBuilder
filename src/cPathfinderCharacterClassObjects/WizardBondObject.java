package cPathfinderCharacterClassObjects;

public class WizardBondObject extends Wizard {
	//Instance Variables: 
	private String bondedObject; 
	
	//Constructor:
	WizardBondObject(int level) {
		super(level); 
	}
	
	//Methods:
	public String getBondedObject() {return this.bondedObject;}
	public void setBondedObject(String bondedObject) {this.bondedObject = bondedObject;}
	
}
