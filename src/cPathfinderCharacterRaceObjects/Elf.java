package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Elf extends Race{
	//Static Variables: 
	protected static RacialTrait[] elfRacialTraits = {new RacialTrait("ELVEN_IMMUNITIES"), new RacialTrait("ELVEN_MAGIC"), new RacialTrait("KEEN_SENSES")};;
	
	//InstanceVariables: 
	
	
	//Constructors:
	public Elf(){
		this.raceType = "Elf";
		
		setStrengthModifier(0);
		setDexterityModifier(2);
		setConstitutionModifier(-2);
		setIntelligenceModifier(2);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		this.abilityModifierText = "Elves are nimble, both in body and mind, but their form is frail.";
		
		this.size = Sizes.MEDIUM;
		this.baseSpeed = 30;
		this.vision = "Low-Light";
		
		this.racialTraits = elfRacialTraits;
		
		this.familiarWeapons = new String[] {"Bows", "Longswords", "Rapiers"};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"Celestial", "Draconic", "Gnoll", "Gnome", "Goblin", "Orc", "Sylvan"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*65 + 110));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*88 + 175));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*87 + 263));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 64;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*12 + 66));}
		else if (heightRange.equals("Tall")) {return 80;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 100;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*20 + 110));}
		else if (weightRange.equals("Heavy")) {return 148;}
		else {return null;}
	}


}
