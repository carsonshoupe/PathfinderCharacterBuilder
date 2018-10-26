package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Gnome extends Race {
	//Static Variables: 
	protected static RacialTrait[] gnomeRacialTraits = {new RacialTrait("DEFENSIVE_TRAINING"), new RacialTrait("GNOME_MAGIC"), 
			new RacialTrait("HATRED_REPTILIAN_GOBLINOID"), new RacialTrait("ILLUSION_RESISTANCE"), new RacialTrait("KEEN_SENSES"), 
			new RacialTrait("OBSESSIVE")};
	
	//Instance Variables:
	
	//Constructor:
	public Gnome(){
		this.raceType = "Gnome";
		
		setStrengthModifier(-2);
		setDexterityModifier(0);
		setConstitutionModifier(2);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(2);
		
		this.size = Sizes.SMALL;
		this.baseSpeed = 20;
		this.vision = "Low-Light";
		
		this.racialTraits = gnomeRacialTraits;
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Gnome", "Sylvan"};
		this.potentialLanguages = new String[] {"Draconic", "Dwarven", "Elven", "Giant", "Goblin", "Orc"};	
		
		applyRacialTraitModifications();
	}
	
	//Methods:
		

}
