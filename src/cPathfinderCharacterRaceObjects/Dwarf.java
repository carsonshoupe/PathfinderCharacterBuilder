package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Dwarf extends Race {
	//InstanceVariables: 
	
	
	//Constructors:
	Dwarf(){
		this.raceType = "Dwarf";
		
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 2;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 2;
		this.charismaModifier = -2;
		
		this.size = Sizes.MEDIUM;
		this.speed = 20;
		this.vision = "Dark";
		
		this.racialTraits = new RacialTrait[] {new RacialTrait("DEFENSIVE_TRAINING"), new RacialTrait("GREED"), new RacialTrait("HATRED_ORC_GOBLINOID"), 
				new RacialTrait("HARDY"), new RacialTrait("SLOW_AND_STEADY"), new RacialTrait("STABILITY"), new RacialTrait("STONECUNNING")};
		
		/*
		this.racialBonuses = new RacialTraits[] {RacialTraits.DEFENSIVE_TRAINING, RacialTraits.GREED, RacialTraits.HATRED_ORC_GOBLINOID, 
				RacialTraits.HARDY, RacialTraits.SLOW_AND_STEADY, RacialTraits.STABILITY, RacialTraits.STONECUNNING};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.GREED, RacialTraits.STONECUNNING};
		this.combatBonuses = new RacialTraits[] {RacialTraits.DEFENSIVE_TRAINING, RacialTraits.HATRED_ORC_GOBLINOID, RacialTraits.STABILITY};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {RacialTraits.HARDY};
		this.featBonuses = new RacialTraits[] {};
		this.miscBonuses = new RacialTraits[] {RacialTraits.SLOW_AND_STEADY};
		*/
		
		this.familiarWeapons = new String[] {"battleaxes", "heavy picks", "warhammers"};
		this.knownLanguages = new String[] {"Common", "Dwarven"};
		this.potentialLanguages = new String[] {"Giant", "Gnome", "Goblin", "Orc", "Terran", "Undercommon"};	
	}
	
	//Methods:

}
