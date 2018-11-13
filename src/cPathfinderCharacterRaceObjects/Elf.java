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

}
