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
		
		this.abilityModifierText = "Halflings are nimble and strong-willed, but their small stature makes them weaker than other races.";
		
		this.size = Sizes.SMALL;
		this.baseSpeed = 20;
		this.vision = "Normal";
		
		this.racialTraits = halflingRacialTraits;
		
		this.familiarWeapons = new String[] {"Slings"};
		this.knownLanguages = new String[] {"Common", "Halfling"};
		this.potentialLanguages = new String[] {"Dwarven", "Elven", "Gnome", "Goblin"};	
		
		applyRacialTraitModifications();
	}
		
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*30 + 20));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*25 + 50));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*25 + 75));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 32;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*4 + 34));}
		else if (heightRange.equals("Tall")) {return 40;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 30;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*4 + 32));}
		else if (weightRange.equals("Heavy")) {return 38;}
		else {return null;}
	}

	

}
