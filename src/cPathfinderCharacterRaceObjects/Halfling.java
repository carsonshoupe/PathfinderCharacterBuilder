package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Halfling extends Race{
	//Instance Variables:
	
	//Constructor:
	Halfling(){
		this.raceType = "Halfling";
		
		this.strengthModifier = -2;
		this.dexterityModifier = 2;
		this.constitutionModifier = 0;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 2;
		
		this.size = Sizes.SMALL;
		this.speed = 20;
		this.vision = "Normal";
		
		this.racialBonuses = new RacialTraits[] {RacialTraits.FEARLESS, RacialTraits.HALFLING_LUCK, RacialTraits.KEEN_SENSES, RacialTraits.SURE_FOOTED};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.KEEN_SENSES, RacialTraits.SURE_FOOTED};
		this.combatBonuses = new RacialTraits[] {};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {RacialTraits.FEARLESS, RacialTraits.HALFLING_LUCK};
		this.featBonuses = new RacialTraits[] {};
		this.miscBonuses = new RacialTraits[] {};
		
		this.familiarWeapons = new String[] {"slings"};
		this.knownLanguages = new String[] {"Common", "Halfling"};
		this.potentialLanguages = new String[] {"Dwarven", "Elven", "Gnome", "Goblin"};		
	}
		
		//Methods:
	

}
