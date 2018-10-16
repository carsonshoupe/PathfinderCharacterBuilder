package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public class Human extends Race {
	//InstanceVariables: 
	
	
	//Constructors:
	Human(){
		this.raceType = "Human";
		
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 0;
		this.intelligenceModifier = 0;
		this.wisdomModifier = 0;
		this.charismaModifier = 0;
		
		this.size = Sizes.MEDIUM;
		this.speed = 30;
		this.vision = "Normal";
		
		this.racialTraits = new RacialTrait[] {new RacialTrait("SKILLED"), new RacialTrait("BONUS_FEAT")};
		
		/*
		this.racialBonuses = new RacialTraits[] {RacialTraits.SKILLED, RacialTraits.BONUS_FEAT};
		
		this.skillBonuses = new RacialTraits[] {RacialTraits.SKILLED};
		this.combatBonuses = new RacialTraits[] {};
		this.magicBonuses = new RacialTraits[] {};
		this.savingThrowBonuses = new RacialTraits[] {};
		this.featBonuses = new RacialTraits[] {RacialTraits.BONUS_FEAT};
		this.miscBonuses = new RacialTraits[] {};
		*/
		
		this.familiarWeapons = new String[] {};
		this.knownLanguages = new String[] {"Common"};
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
