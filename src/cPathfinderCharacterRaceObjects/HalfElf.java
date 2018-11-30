package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class HalfElf extends Race{
	//Static Variables: 
	protected static RacialTrait[] halfElfRacialTraits = {new RacialTrait("ELF_BLOOD"), new RacialTrait("ELVEN_IMMUNITIES"), new RacialTrait("ADAPTABILITY"), 
			new RacialTrait("KEEN_SENSES"), new RacialTrait("MULTITALENTED")};
	
	//InstanceVariables: 
	
	
	//Constructors:
	public HalfElf(){
		this.raceType = "Half-Elf";
		
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		this.abilityModifierText = "Half-elf characters get a +2 bonus to one ability score of their choice at creation to represent their varied nature.";
		
		this.size = Sizes.MEDIUM;
		this.baseSpeed = 30;
		this.vision = "Low-Light";
		
		this.racialTraits = halfElfRacialTraits;
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"any"};	
		
		applyRacialTraitModifications();
	}
		
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*42 + 20));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*31 + 62));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*32 + 93));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 62;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*12 + 64));}
		else if (heightRange.equals("Tall")) {return 78;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 110;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*50 + 120));}
		else if (weightRange.equals("Heavy")) {return 190;}
		else {return null;}
	}


}
