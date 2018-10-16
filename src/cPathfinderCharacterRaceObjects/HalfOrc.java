package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class HalfOrc extends Race {
	//Instance Variables:
	
	//Constructor:
	HalfOrc(){
		this.raceType = "Half-Orc";
		
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 0;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 0;
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Dark";
		
		this.racialTraits = new RacialTrait[] {new RacialTrait("ORC_BLOOD"), new RacialTrait("INTIMIDATING"), new RacialTrait("ORC_FEROCITY")};
		
		/*
		this.racialBonuses = new RacialTraits[] {RacialTraits.ORC_BLOOD, RacialTraits.INTIMIDATING, RacialTraits.ORC_FEROCITY};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.INTIMIDATING};
		this.combatBonuses = new RacialTraits[] {};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {};
		this.featBonuses = new RacialTraits[] {RacialTraits.ORC_FEROCITY};
		this.miscBonuses = new RacialTraits[] {RacialTraits.ORC_BLOOD};
		*/
		
		this.familiarWeapons = new String[] {"great axes", "falchions"};
		this.knownLanguages = new String[] {"Common", "Orc"};
		this.potentialLanguages = new String[] {"Abyssal", "Draconic", "Giant", "Gnoll", "Goblin"};	
	}
	
	//Methods:
	
	public void incrementAbilityModifier(int abilityModifier) {
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 0;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 0;
		
		if (abilityModifier == 0) {
			this.strengthModifier = 2;
		}
		if (abilityModifier == 1) {
			this.dexterityModifier = 2;
		}
		if (abilityModifier == 2) {
			this.constitutionModifier = 2;
		}
		if (abilityModifier == 3) {
			this.intelligenceModifier = 2;
		}
		if (abilityModifier == 4) {
			this.wisdomModifier = 2;
		}
		if (abilityModifier == 5) {
			this.charismaModifier = 2;
		}
	}
}
