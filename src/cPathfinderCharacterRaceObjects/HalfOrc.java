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
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Dark";
		
		this.racialTraits = halfOrcRacialTraits;
				
		this.familiarWeapons = new String[] {"great axes", "falchions"};
		this.knownLanguages = new String[] {"Common", "Orc"};
		this.potentialLanguages = new String[] {"Abyssal", "Draconic", "Giant", "Gnoll", "Goblin"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
}
