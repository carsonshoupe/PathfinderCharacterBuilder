package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Dwarf extends Race {
	//Static Variables: 
	protected static RacialTrait[] dwarfRacialTraits = {new RacialTrait("DEFENSIVE_TRAINING"), new RacialTrait("GREED"), new RacialTrait("HATRED_ORC_GOBLINOID"), 
			new RacialTrait("HARDY"), new RacialTrait("SLOW_AND_STEADY"), new RacialTrait("STABILITY"), new RacialTrait("STONECUNNING")};
	
	//InstanceVariables: 
	
	
	//Constructors:
	public Dwarf(){
		this.raceType = "Dwarf";
		
		//String value = null;
		//value.getBytes();
		
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(2);
		setIntelligenceModifier(0);
		setWisdomModifier(2);
		setCharismaModifier(-2);
		
		this.abilityModifierText = "Dwarves are both tough and wise, but also a bit gruff.";
		
		this.size = Sizes.MEDIUM;
		this.baseSpeed = 20;
		this.vision = "Dark";
		
		this.racialTraits = dwarfRacialTraits;
		
		this.familiarWeapons = new String[] {"Battleaxes", "Heavy Picks", "Warhammers"};
		this.knownLanguages = new String[] {"Common", "Dwarven"};
		this.potentialLanguages = new String[] {"Giant", "Gnome", "Goblin", "Orc", "Terran", "Undercommon"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
	
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*85 + 40));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*63 + 125));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*62 + 188));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 45;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*4 + 47));}
		else if (heightRange.equals("Tall")) {return 53;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 150;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*20 + 160));}
		else if (weightRange.equals("Heavy")) {return 206;}
		else {return null;}
	}

}
