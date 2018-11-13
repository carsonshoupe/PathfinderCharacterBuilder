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
}
