package cPathfinderCharacterRaceObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterObjects.CharacterModifier;
import cPathfinderCharacterObjects.CharacterModifierObject;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterObjects.Sizes;
import cPathfinderCharacterSkillObjects.Skill;

public abstract class Race implements CharacterModifier{
	//Instance Variables: 
	protected String raceType;
	
	protected int[] abilityModifiers = {0, 0, 0, 0, 0, 0}; 
	protected Sizes size; 
	protected int baseSpeed;
	protected String vision;
	protected RacialTrait[] racialTraits;
	protected String[] familiarWeapons;
	protected String[] knownLanguages;
	protected String[] potentialLanguages;	
	
	//Racial Trait Modifications
	protected Map<Skill, Integer> skillRanksToAdd = new HashMap<Skill, Integer>();
	protected int bonusSkillRanks = 0;
	protected ArrayList<Feat> featsToAdd = new ArrayList<Feat>();
	protected int bonusFeats = 0;
	protected int[] savingThrowModifiers = {0, 0, 0};
	protected ArrayList<String> specialAbilityDescriptions = new ArrayList<String>();
	
	
	
	//Methods: 
	
	public int getStrengthModifier() {return this.abilityModifiers[0];}
	public int getDexterityModifier() {return this.abilityModifiers[1];}
	public int getConstitutionModifier() {return this.abilityModifiers[2];}
	public int getIntelligenceModifier() {return this.abilityModifiers[3];}
	public int getWisdomModifier() {return this.abilityModifiers[4];}
	public int getCharismaModifier() {return this.abilityModifiers[5];}
	public int[] getAbilityModifiers() {return this.abilityModifiers;}
	
	public void setAbilityModifiers(int[] abilityModifiers) {this.abilityModifiers = abilityModifiers;}
	public void setStrengthModifier(int value) {this.abilityModifiers[0] = value;}
	public void setDexterityModifier(int value) {this.abilityModifiers[1] = value;}
	public void setConstitutionModifier(int value) {this.abilityModifiers[2] = value;}
	public void setIntelligenceModifier(int value) {this.abilityModifiers[3] = value;}
	public void setWisdomModifier(int value) {this.abilityModifiers[4] = value;}
	public void setCharismaModifier(int value) {this.abilityModifiers[5] = value;}
	
	public Sizes getSize() {return this.size;}
	public int getBaseSpeed() {return this.baseSpeed;}
	public String getVision() {return this.vision;}
	
	public int getFortSaveModifier() {return this.savingThrowModifiers[0];}
	public int getReflexSaveModifier() {return this.savingThrowModifiers[1];}
	public int getWillSaveModifier() {return this.savingThrowModifiers[2];}
	
	public RacialTrait[] getRacialTraits() {return this.racialTraits;}
	
	public String[] getFamiliarWeapons() {return this.familiarWeapons;}
	public String[] getKnownLanguages() {return this.knownLanguages;}
	public String[] getPotentialLanguages() {return this.potentialLanguages;}
	public void setFamiliarWeapons(String[] familiarWeapons) {this.familiarWeapons = familiarWeapons;}
	public void setKnownLanguages(String[] knownLanguages) {this.knownLanguages = knownLanguages;}
	public void setPotentialLanguages(String[] potentialLanguages) {this.potentialLanguages = potentialLanguages;}
	
	public ArrayList<String> getSpecialAbilityDescriptions() {return this.specialAbilityDescriptions;}
	
	public void incrementAbilityModifier(int abilityChoice) {
		setStrengthModifier(0);
		setDexterityModifier(0);
		setConstitutionModifier(0);
		setIntelligenceModifier(0);
		setWisdomModifier(0);
		setCharismaModifier(0);
		
		if (abilityChoice == 0) {setStrengthModifier(2);}
		if (abilityChoice == 1) {setDexterityModifier(2);}
		if (abilityChoice == 2) {setConstitutionModifier(2);}
		if (abilityChoice == 3) {setIntelligenceModifier(2);}
		if (abilityChoice == 4) {setWisdomModifier(2);}
		if (abilityChoice == 5) {setCharismaModifier(2);}
	}
	
	@Override
	public String toString() {
		String outputString = this.raceType + ": " + Arrays.deepToString(this.racialTraits) + "\n"
				+ "Ability Modifiers: " + Arrays.toString(this.abilityModifiers) + "\n"
				+ "Size: " + this.size.toString() + "\n"
				+ "Vision: " + this.vision + "\n"
				+ "Familiar Weapons: " + Arrays.toString(this.familiarWeapons) + "\n"
				+ "Known Languages: " + Arrays.toString(this.knownLanguages) + "\n"
				+ "Potential Languages: " + Arrays.toString(this.potentialLanguages) + "\n";
		return outputString;
	}
	
	public String modificationsToString() {
		String outputString = this.raceType + ": " + Arrays.deepToString(this.racialTraits) + "\n"
				+ "Ability Modifiers: " + Arrays.toString(this.abilityModifiers) + "\n"
				+ "Size: " + this.size.toString() + "\n"
				+ "Vision: " + this.vision + "\n"
				+ "Familiar Weapons: " + Arrays.toString(this.familiarWeapons) + "\n"
				+ "Known Languages: " + Arrays.toString(this.knownLanguages) + "\n"
				+ "Potential Languages: " + Arrays.toString(this.potentialLanguages) + "\n"
				+ "Skill to Add: " + this.skillRanksToAdd.toString() + "\n"
				+ "Feat to Add: " + this.featsToAdd.toString() + " NumBonusFeats: " + this.bonusFeats + "\n"
				+ "Saving Throws Bonus: " + Arrays.toString(this.savingThrowModifiers) + "\n"
				+ "Bonus Skill Ranks: " + this.bonusSkillRanks + "\n";
		String specialAbilitiesDescriptions = "Special Ability Descriptons: \n";
		for (String specialAbilityDescription : this.specialAbilityDescriptions) {
			specialAbilitiesDescriptions += (specialAbilityDescription + "\n");
		}
		outputString += specialAbilitiesDescriptions;
		return outputString;
	}
	
	public PathfinderCharacter updateCharacter(PathfinderCharacter pathfinderCharacter) {
		PathfinderCharacter outputPathfinderCharacter = pathfinderCharacter.clone();
		//TODO
		
		return outputPathfinderCharacter;
	}
	
	@Override
	public Race clone() throws CloneNotSupportedException {
		Race outputRace = (Race) super.clone();
		outputRace.setAbilityModifiers(this.abilityModifiers.clone());
		
		int counter = 0;
		for (RacialTrait racialTrait : this.getRacialTraits()) {
			outputRace.getRacialTraits()[counter] = racialTrait.clone();
		}
		
		outputRace.setFamiliarWeapons(this.familiarWeapons.clone());
		outputRace.setKnownLanguages(this.knownLanguages.clone());
		outputRace.setPotentialLanguages(this.potentialLanguages.clone());
		
		outputRace.skillRanksToAdd = new HashMap<Skill, Integer>();
		outputRace.bonusSkillRanks = 0;
		outputRace.featsToAdd = new ArrayList<Feat>();
		outputRace.bonusFeats = 0;
		outputRace.savingThrowModifiers[0] = 0;
		outputRace.savingThrowModifiers[1] = 0;
		outputRace.savingThrowModifiers[2] = 0;
		outputRace.specialAbilityDescriptions = new ArrayList<String>();
		
		outputRace.applyRacialTraitModifications();
		
		return outputRace;
	}
	
	protected void applyRacialTraitModifications() {
		for (RacialTrait trait : this.getRacialTraits()) {
			if (trait.shouldUpdateCharacterSheet()) {
				if (trait.getName().equals("ADAPTABILITY")) {this.featsToAdd.add(new Feat("SKILL_FOCUS"));}
				if (trait.getName().equals("BONUS_FEAT")) {this.bonusFeats++;}
				if (trait.getName().equals("HALFLING_LUCK")) {
					this.savingThrowModifiers[0]++;
					this.savingThrowModifiers[1]++;
					this.savingThrowModifiers[2]++;
				}
				if (trait.getName().equals("INTIMIDATING")) {this.skillRanksToAdd.put(new Skill("INTIMIDATE"), 2);}
				if (trait.getName().equals("KEEN_SENSES")) {this.skillRanksToAdd.put(new Skill("PERCEPTION"), 2);}
				if (trait.getName().equals("OBSESSIVE")) {
					this.skillRanksToAdd.put(new Skill("CRAFT1"), 2);
					this.skillRanksToAdd.put(new Skill("CRAFT2"), 2);
					this.skillRanksToAdd.put(new Skill("CRAFT3"), 2);
					this.skillRanksToAdd.put(new Skill("PROFESSION1"), 2);
					this.skillRanksToAdd.put(new Skill("PROFESSION2"), 2);
				}
				if (trait.getName().equals("SKILLED")) {this.bonusSkillRanks++;}
				if (trait.getName().equals("SURE_FOOTED")) {
					this.skillRanksToAdd.put(new Skill("ACROBATICS"), 2);
					this.skillRanksToAdd.put(new Skill("CLIMB"), 2);
				}
			}
			else {
				this.specialAbilityDescriptions.add(trait.toString());
			}
		}
	}	
}
