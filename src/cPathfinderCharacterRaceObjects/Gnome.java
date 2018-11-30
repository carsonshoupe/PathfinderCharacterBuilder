package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Gnome extends Race {
	//Static Variables: 
	protected static RacialTrait[] gnomeRacialTraits = {new RacialTrait("DEFENSIVE_TRAINING"), new RacialTrait("GNOME_MAGIC"), 
			new RacialTrait("HATRED_REPTILIAN_GOBLINOID"), new RacialTrait("ILLUSION_RESISTANCE"), new RacialTrait("KEEN_SENSES"), 
			new RacialTrait("OBSESSIVE")};
	
	//Instance Variables:
	
	//Constructor:
	public Gnome(){
		this.raceType = "Gnome";
		
		setStrengthModifier(-2);
		setDexterityModifier(0);
		setConstitutionModifier(2);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(2);
		
		this.abilityModifierText = "Gnomes are physically weak but surprisingly hardy, and their attitude makes them naturally agreeable.";
		
		this.size = Sizes.SMALL;
		this.baseSpeed = 20;
		this.vision = "Low-Light";
		
		this.racialTraits = gnomeRacialTraits;
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Gnome", "Sylvan"};
		this.potentialLanguages = new String[] {"Draconic", "Dwarven", "Elven", "Giant", "Goblin", "Orc"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*60 + 40));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*50 + 100));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*50 + 150));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 36;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*4 + 38));}
		else if (heightRange.equals("Tall")) {return 44;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 35;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*4 + 37));}
		else if (weightRange.equals("Heavy")) {return 43;}
		else {return null;}
	}


}
