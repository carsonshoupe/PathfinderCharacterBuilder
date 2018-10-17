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
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Low-Light";
		
		this.racialTraits = halfElfRacialTraits;
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"any"};	
		
		setCharacterModifierObject(createCharacterModifierObject());
	}
		
	//Methods:

}
