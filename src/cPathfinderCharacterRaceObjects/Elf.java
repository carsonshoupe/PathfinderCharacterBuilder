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
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Low-Light";
		
		this.racialTraits = elfRacialTraits;
		
		this.familiarWeapons = new String[] {"longbows", "composite longbows", "longswords", "rapiers", "shortbows", "composite shortbows"};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"Celestial", "Draconic", "Gnoll", "Gnome", "Goblin", "Orc", "Sylvan"};	
		
		setCharacterModifierObject(createCharacterModifierObject());
	}
	
	//Methods:

}
