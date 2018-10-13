package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class HalfElf extends Race{
	//InstanceVariables: 
	
	
	//Constructors:
	HalfElf(){
		this.raceType = "Half-Elf";
		
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 0;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 0;
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Low-Light";
		
		this.racialBonuses = new RacialTraits[] {RacialTraits.ELF_BLOOD, RacialTraits.ELVEN_IMMUNITIES, RacialTraits.ADAPTABILIY, 
				RacialTraits.KEEN_SENSES, RacialTraits.MULTITALENTED};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.ADAPTABILIY, RacialTraits.KEEN_SENSES};
		this.combatBonuses = new RacialTraits[] {};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {RacialTraits.ELVEN_IMMUNITIES};
		this.featBonuses = new RacialTraits[] {};
		this.miscBonuses = new RacialTraits[] {RacialTraits.ELF_BLOOD, RacialTraits.MULTITALENTED};
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common", "Elven"};
		this.potentialLanguages = new String[] {"any"};	
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
