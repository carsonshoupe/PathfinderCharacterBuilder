package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Human extends Race {
	//Static Variables: 
	protected static RacialTrait[] humanRacialTraits = {new RacialTrait("SKILLED"), new RacialTrait("BONUS_FEAT")};
	
	//InstanceVariables: 
	
	
	//Constructors:
	public Human(){
		this.raceType = "Human";
		
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		this.abilityModifierText = "Human characters get a +2 bonus to one ability score of their choice at creation to represent their varied nature.";
		
		this.size = Sizes.MEDIUM;
		this.baseSpeed = 30;
		this.vision = "Normal";
		
		this.racialTraits = humanRacialTraits;
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common"};
		this.potentialLanguages = new String[] {"any"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*20 + 15));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*18 + 35));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*17 + 53));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 58;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*16 + 60));}
		else if (heightRange.equals("Tall")) {return 78;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 120;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*60 + 130));}
		else if (weightRange.equals("Heavy")) {return 220;}
		else {return null;}
	}


}
