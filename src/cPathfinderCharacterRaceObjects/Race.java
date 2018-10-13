package cPathfinderCharacterRaceObjects;

import cPathfinderCharacterObjects.Sizes;

public abstract class Race {
	//Instance Variables: 
	protected String raceType;
	
	protected int strengthModifier;
	protected int dexterityModifier;
	protected int constitutionModifier;
	protected int intelligenceModifier;
	protected int wisdomModifier;
	protected int charismaModifier;
	protected int[] abilityModifiers = {this.strengthModifier, this.dexterityModifier, this.constitutionModifier, 
			this.intelligenceModifier, this.wisdomModifier, this.charismaModifier}; 
	
	protected Sizes size; 
	protected int speed;
	protected String vision;
	
	protected RacialTraits[] racialBonuses;
	
	protected RacialTraits[] skillBonuses;
	protected RacialTraits[] combatBonuses;
	protected RacialTraits[] magicBonuses;
	protected RacialTraits[] savingThrowBonuses;
	protected RacialTraits[] featBonuses;
	protected RacialTraits[] miscBonuses;
	
	protected String[] familiarWeapons;
	protected String[] knownLanguages;
	protected String[] potentialLanguages;	
	
	//Methods: 
	
	public int getStrengthModifier() {return this.strengthModifier;}
	public int getDexterityModifier() {return this.dexterityModifier;}
	public int getConstitutionModifier() {return this.constitutionModifier;}
	public int getIntelligenceModifier() {return this.intelligenceModifier;}
	public int getWisdomModifier() {return this.wisdomModifier;}
	public int getCharismaModifier() {return this.charismaModifier;}
	public int[] getAbilityModifiers() {return this.abilityModifiers;}
	
	public Sizes getSize() {return this.size;}
	public int getSpeed() {return this.speed;}
	public String getVision() {return this.vision;}
	
	public RacialTraits[] getRacialBonuses() {return this.racialBonuses;}
	
	public RacialTraits[] getSkillBonuses() {return this.skillBonuses;}
	public RacialTraits[] getCombatBonuses() {return this.combatBonuses;}
	public RacialTraits[] getMagicBonuses() {return this.magicBonuses;}
	public RacialTraits[] getSavingThrowBonuses() {return this.savingThrowBonuses;}
	public RacialTraits[] getFeatBonuses() {return this.featBonuses;}
	public RacialTraits[] getMiscBonuses() {return this.miscBonuses;}
	
	public String[] getFamiliarWeapons() {return this.familiarWeapons;}
	public String[] getKnownLanguages() {return this.knownLanguages;}
	public String[] getPotentialLanguages() {return this.potentialLanguages;}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
