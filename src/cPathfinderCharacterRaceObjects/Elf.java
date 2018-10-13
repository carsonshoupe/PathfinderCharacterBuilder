package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Elf extends Race{
	//InstanceVariables: 
	
	
	//Constructors:
	Elf(){
		this.raceType = "Elf";
		
		this.strengthModifier = 0;
		this.dexterityModifier = 2;
		this.constitutionModifier = -2;
		this.intelligenceModifier = 2;
		this.wisdomModifier = 0;
		this.charismaModifier = 0;
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Low-Light";
		
		this.racialBonuses = new RacialTraits[] {RacialTraits.ELVEN_IMMUNITIES, RacialTraits.ELVEN_MAGIC, RacialTraits.KEEN_SENSES};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.KEEN_SENSES};
		this.combatBonuses = new RacialTraits[] {};
		this.magicBonuses = new RacialTraits[] {RacialTraits.ELVEN_MAGIC};
		this.savingThrowBonuses = new RacialTraits[] {RacialTraits.ELVEN_IMMUNITIES};
		this.featBonuses = new RacialTraits[] {};
		this.miscBonuses = new RacialTraits[] {};
		
		this.familiarWeapons = new String[] {"longbows", "composite longbows", "longswords", "rapiers", "shortbows", "composite shortbows"};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"Celestial", "Draconic", "Gnoll", "Gnome", "Goblin", "Orc", "Sylvan"};			
	}
	
	//Methods:

}
