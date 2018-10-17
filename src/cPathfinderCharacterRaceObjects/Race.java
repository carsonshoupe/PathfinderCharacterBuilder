package cPathfinderCharacterRaceObjects;

import java.util.Arrays;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterObjects.CharacterModifierObject;
import cPathfinderCharacterObjects.Sizes;
import cPathfinderCharacterSkillObjects.Skill;

public abstract class Race {
	//Instance Variables: 
	protected String raceType;
	
	protected int[] abilityModifiers = {0, 0, 0, 0, 0, 0}; 
	protected Sizes size; 
	protected int speed;
	protected String vision;
	protected RacialTrait[] racialTraits;
	protected String[] familiarWeapons;
	protected String[] knownLanguages;
	protected String[] potentialLanguages;	
	
	protected CharacterModifierObject modifierObject;
	
	//Methods: 
	
	public int getStrengthModifier() {return this.abilityModifiers[0];}
	public int getDexterityModifier() {return this.abilityModifiers[1];}
	public int getConstitutionModifier() {return this.abilityModifiers[2];}
	public int getIntelligenceModifier() {return this.abilityModifiers[3];}
	public int getWisdomModifier() {return this.abilityModifiers[4];}
	public int getCharismaModifier() {return this.abilityModifiers[5];}
	public int[] getAbilityModifiers() {return this.abilityModifiers;}
	public CharacterModifierObject getCharacterModifierObject() {return this.modifierObject;}
	
	
	public void setStrengthModifier(int value) {this.abilityModifiers[0] = value;}
	public void setDexterityModifier(int value) {this.abilityModifiers[1] = value;}
	public void setConstitutionModifier(int value) {this.abilityModifiers[2] = value;}
	public void setIntelligenceModifier(int value) {this.abilityModifiers[3] = value;}
	public void setWisdomModifier(int value) {this.abilityModifiers[4] = value;}
	public void setCharismaModifier(int value) {this.abilityModifiers[5] = value;}
	public void setCharacterModifierObject(CharacterModifierObject modifierObject) {this.modifierObject = modifierObject;}
	
	public Sizes getSize() {return this.size;}
	public int getSpeed() {return this.speed;}
	public String getVision() {return this.vision;}
	
	public RacialTrait[] getRacialTraits() {return this.racialTraits;}
	
	public String[] getFamiliarWeapons() {return this.familiarWeapons;}
	public String[] getKnownLanguages() {return this.knownLanguages;}
	public String[] getPotentialLanguages() {return this.potentialLanguages;}
	
	public void incrementAbilityModifier(int abilityModifier) {
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		if (abilityModifier == 0) {
			setStrengthModifier(0);
		}
		if (abilityModifier == 1) {
			setDexterityModifier(0);
		}
		if (abilityModifier == 2) {
			setConstitutionModifier(0);
		}
		if (abilityModifier == 3) {
			setIntelligenceModifier(0);
		}
		if (abilityModifier == 4) {
			setWisdomModifier(0);
		}
		if (abilityModifier == 5) {
			setCharismaModifier(0);
		}
	}
	
	@Override
	public String toString() {
		String outputString = this.raceType + ": " + Arrays.deepToString(this.racialTraits) + "\n"
				+ "Ability Modifiers: " + Arrays.toString(this.abilityModifiers) + "\n"
				+ "Size: " + this.size.toString() + "\n"
				+ "Vision: " + this.vision + "\n"
				+ "Familiar Weapons: " + Arrays.toString(this.familiarWeapons) + "\n"
				+ "Known Languages: " + Arrays.toString(this.knownLanguages) + "\n"
				+ "Potential Languages: " + Arrays.toString(this.potentialLanguages) + "\n"
				+ "CharacterModiferObject: \n" + this.getCharacterModifierObject().toString();
		return outputString;
	}
	
	protected CharacterModifierObject createCharacterModifierObject() {
		CharacterModifierObject characterModifier = new CharacterModifierObject();
		
		characterModifier.setAbilityScoreModifier(this.getAbilityModifiers());
		
		for (RacialTrait trait : this.getRacialTraits()) {
			if (trait.shouldUpdateCharacterSheet()) {
				if (trait.getName().equals("ADAPTABILITY")) {
					characterModifier.addFeat(new Feat("SKILL_FOCUS"));
				}
				if (trait.getName().equals("BONUS_FEAT")) {
					characterModifier.incrementBonusFeats(); 
				}
				if (trait.getName().equals("HALFLING_LUCK")) {
					characterModifier.incrementFortitudeSaveBonus();
					characterModifier.incrementReflexSaveBonus();
					characterModifier.incrementWillSaveBonus();
				}
				if (trait.getName().equals("INTIMIDATING")) {
					characterModifier.addSkillRanks(new Skill("INTIMIDATE"), 2);
				}
				if (trait.getName().equals("KEEN_SENSES")) {
					characterModifier.addSkillRanks(new Skill("PERCEPTION"), 2);
				}
				if (trait.getName().equals("OBSESSIVE")) {
					characterModifier.addSkillRanks(new Skill("CRAFT1"), 2);
					characterModifier.addSkillRanks(new Skill("CRAFT2"), 2);
					characterModifier.addSkillRanks(new Skill("CRAFT3"), 2);
					characterModifier.addSkillRanks(new Skill("PROFESSION1"), 2);
					characterModifier.addSkillRanks(new Skill("PROFESSION2"), 2);
				}
				if (trait.getName().equals("SKILLED")) {
					characterModifier.incrementBonusSkillRanks(); 
				}
				if (trait.getName().equals("SURE_FOOTED")) {
					characterModifier.addSkillRanks(new Skill("ACROBATICS"), 2);
					characterModifier.addSkillRanks(new Skill("CLIMB"), 2);
				}
			}
		}
		return characterModifier;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
