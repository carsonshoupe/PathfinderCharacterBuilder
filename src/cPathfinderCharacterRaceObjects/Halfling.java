package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Halfling extends Race{
	//Static Variables: 
	protected static RacialTrait[] halflingRacialTraits = {new RacialTrait("FEARLESS"), new RacialTrait("HALFLING_LUCK"), new RacialTrait("KEEN_SENSES"), 
			new RacialTrait("SURE_FOOTED")};
	
	//Instance Variables:
	
	//Constructor:
	public Halfling(){
		this.raceType = "Halfling";
		
		setStrengthModifier(-2);
		setDexterityModifier(2);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(2);
		
		this.size = Sizes.SMALL;
		this.baseSpeed = 20;
		this.vision = "Normal";
		
		this.racialTraits = halflingRacialTraits;
		
		this.familiarWeapons = new String[] {"slings"};
		this.knownLanguages = new String[] {"Common", "Halfling"};
		this.potentialLanguages = new String[] {"Dwarven", "Elven", "Gnome", "Goblin"};	
		
		applyRacialTraitModifications();
	}
		
		//Methods:
	

}
