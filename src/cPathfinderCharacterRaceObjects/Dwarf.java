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

}
