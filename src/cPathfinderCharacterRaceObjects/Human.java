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

}
