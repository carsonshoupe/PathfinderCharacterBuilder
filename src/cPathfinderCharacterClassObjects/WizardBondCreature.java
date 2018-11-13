package cPathfinderCharacterClassObjects;

public class WizardBondCreature extends Wizard {
	//Instance Variables:
	private Familiar familiar; 
	
	//Constructors:
	WizardBondCreature(int level) {
		super(level);
	}
	
	//Methods:
	public Familiar getFamiliar() {return this.familiar;}
	public void setFamiliar(Familiar familiar) {this.familiar = familiar;}
}
