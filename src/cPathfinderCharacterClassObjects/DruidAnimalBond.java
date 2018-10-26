package cPathfinderCharacterClassObjects;

public class DruidAnimalBond extends Druid {
	//Instance Variable:
	private AnimalCompanion animal;
	
	//Constructor:
	DruidAnimalBond(int level, AnimalCompanion animal) {
		super(level);
		this.animal = animal;
		for (ClassFeature feature : animal.getAnimalCompanionFeatures()) { //Adds animal features to druid features
			this.classFeatures.add(feature);
		}
	}
	
	//Methods:
	public AnimalCompanion getAnimalCompanion() {return this.animal;}
	public void setAnimalCompanion(AnimalCompanion animal) {this.animal = animal;}

}
