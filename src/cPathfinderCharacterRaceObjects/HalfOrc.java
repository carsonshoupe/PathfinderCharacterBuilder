package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class HalfOrc extends Race {
	//Static Variables: 
	protected static RacialTrait[] halfOrcRacialTraits = {new RacialTrait("ORC_BLOOD"), new RacialTrait("INTIMIDATING"), new RacialTrait("ORC_FEROCITY")};
	
	//Instance Variables:
	
	//Constructor:
	public HalfOrc(){
		this.raceType = "Half-Orc";
		
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		this.abilityModifierText = "Half-orc characters get a +2 bonus to one ability score of their choice at creation	to represent their varied nature.";
		
		this.size = Sizes.MEDIUM;
		this.baseSpeed = 30;
		this.vision = "Dark";
		
		this.racialTraits = halfOrcRacialTraits;
				
		this.familiarWeapons = new String[] {"Great Axes", "Falchions"};
		this.knownLanguages = new String[] {"Common", "Orc"};
		this.potentialLanguages = new String[] {"Abyssal", "Draconic", "Giant", "Gnoll", "Goblin"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
	public Integer generateAge(String ageRange) {
		if (ageRange.equals("Young Adult")) {return (int) Math.floor((Math.random()*16 + 14));}
		else if (ageRange.equals("Middle Age")) {return (int) Math.floor((Math.random()*15 + 30));}
		else if (ageRange.equals("Old")) {return (int) Math.floor((Math.random()*15 + 45));}
		else {return null;}
	}
	
	public Integer generateHeight(String heightRange) {
		if (heightRange.equals("Short")) {return 58;}
		else if (heightRange.equals("Medium")) {return (int) Math.floor((Math.random()*20 + 60));}
		else if (heightRange.equals("Tall")) {return 82;}
		else {return null;}
	}
	
	public Integer generateWeight(String weightRange) {
		if (weightRange.equals("Light")) {return 150;}
		else if (weightRange.equals("Medium")) {return (int) Math.floor((Math.random()*100 + 170));}
		else if (weightRange.equals("Heavy")) {return 318;}
		else {return null;}
	}

}
