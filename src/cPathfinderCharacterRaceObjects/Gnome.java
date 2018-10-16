package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Gnome extends Race {
	//Instance Variables:
	
	//Constructor:
	Gnome(){
		this.raceType = "Gnome";
		
		this.strengthModifier = -2;
		this.dexterityModifier = 0;
		this.constitutionModifier = 2;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 2;
		
		this.size = Sizes.SMALL;
		this.speed = 20;
		this.vision = "Low-Light";
		
		this.racialTraits = new RacialTrait[] {new RacialTrait("DEFENSIVE_TRAINING"), new RacialTrait("GNOME_MAGIC"), 
				new RacialTrait("HATRED_REPTILIAN_GOBLINOID"), new RacialTrait("ILLUSION_RESISTANCE"), new RacialTrait("KEEN_SENSES"), 
				new RacialTrait("OBSESSIVE")};
		
		/*
		this.racialBonuses = new RacialTraits[] {RacialTraits.DEFENSIVE_TRAINING, RacialTraits.GNOME_MAGIC, RacialTraits.HATRED_REPTILIAN_GOBLINOID,
				RacialTraits.ILLUSION_RESISTANCE, RacialTraits.KEEN_SENSES, RacialTraits.OBSESSIVE};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.KEEN_SENSES, RacialTraits.OBSESSIVE};
		this.combatBonuses = new RacialTraits[] {RacialTraits.DEFENSIVE_TRAINING, RacialTraits.HATRED_REPTILIAN_GOBLINOID};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {RacialTraits.GNOME_MAGIC, RacialTraits.ILLUSION_RESISTANCE};
		this.featBonuses = new RacialTraits[] {};
		this.miscBonuses = new RacialTraits[] {};
		*/
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Gnome", "Sylvan"};
		this.potentialLanguages = new String[] {"Draconic", "Dwarven", "Elven", "Giant", "Goblin", "Orc"};			
	}
	
	//Methods:
		

}
