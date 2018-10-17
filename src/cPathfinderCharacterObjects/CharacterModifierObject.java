package cPathfinderCharacterObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterSkillObjects.Skill;

public class CharacterModifierObject {
	//Instance Variables:
	protected int[] abilityScoreModifier = {0, 0, 0, 0, 0, 0};
	protected Map<Skill, Integer> skillsToAdd = new HashMap<Skill, Integer>();
	protected ArrayList<Feat> featsToAdd = new ArrayList<Feat>();
	protected int bonusFeats = 0;
	protected int fortitudeSaveBonus = 0;
	protected int reflexSaveBonus = 0;
	protected int willSaveBonus = 0;
	protected int bonusSkillRanks = 0;
	protected int acBonus = 0;
	protected int speedBonus = 0;
	protected int initiativeBonus = 0;
	protected ArrayList<String> featDescriptionsToAdd = new ArrayList<String>();
	protected ArrayList<String> specialAbilitiesDescriptionsToAdd = new ArrayList<String>();
	
	//Constructors:
	
	//Methods:
	public int[] getAbilityScoreModifier() {return this.abilityScoreModifier;}
	public Map<Skill, Integer> getSkillsToAdd() {return this.skillsToAdd;}
	public ArrayList<Feat> getFeatsToAdd() {return this.featsToAdd;}
	public int getBonusFeats() {return this.bonusFeats;}
	public int getFortitudeSaveBonus() {return this.fortitudeSaveBonus;}
	public int getReflexSaveBonus() {return this.reflexSaveBonus;}
	public int getWillSaveBonus() {return this.willSaveBonus;}
	public int bonusSkillRanks() {return this.bonusSkillRanks;}
	public int getAcBonus() {return this.acBonus;}
	public int getSpeedBonus() {return this.speedBonus;}
	public int getInitiativeBonus() {return this.initiativeBonus;}
	public ArrayList<String> getFeatDescriptionsToAdd() {return this.featDescriptionsToAdd;}
	public ArrayList<String> getSpecialAbilitiesDescriptionsToAdd() {return this.specialAbilitiesDescriptionsToAdd;}
	
	public void setAbilityScoreModifier(int[] abilityScoreModifier) {this.abilityScoreModifier = abilityScoreModifier;}
	public void addSkillRanks(Skill skill, int ranks) {this.skillsToAdd.put(skill,  ranks);}
	public void addFeat(Feat feat) {this.featsToAdd.add(feat);}
	public void incrementBonusFeats() {this.bonusFeats++;}
	public void decrementBonusFeats() {this.bonusFeats--;}
	public void incrementFortitudeSaveBonus() {this.fortitudeSaveBonus++;}
	public void decrementFortitudeSaveBonus() {this.fortitudeSaveBonus--;}
	public void incrementReflexSaveBonus() {this.reflexSaveBonus++;}
	public void decrementReflexSaveBonus() {this.reflexSaveBonus--;}
	public void incrementWillSaveBonus() {this.willSaveBonus++;}
	public void decrementWillSaveBonus() {this.willSaveBonus--;}
	public void incrementBonusSkillRanks() {this.bonusSkillRanks++;}
	public void decrementBonusSkillRanks() {this.bonusSkillRanks--;}
	public void incrementAcBonus() {this.acBonus++;}
	public void decrementAcBonus() {this.acBonus--;}
	public void incrementSpeedBonus(int value) {this.speedBonus += value;}
	public void decrementSpeedBonus(int value) {this.speedBonus -= value;}
	public void incrementInitiativeBonus(int value) {this.initiativeBonus += value;}
	public void decrementInitiativeBonus(int value) {this.initiativeBonus -= value;}
	public void addFeatDescription(String featDescription) {this.featDescriptionsToAdd.add(featDescription);}
	public void addSpecialAbilitiesDescription(String specialAbilityDescription) {this.specialAbilitiesDescriptionsToAdd.add(specialAbilityDescription);}
	
	@Override
	public String toString() {
		String outputString = "Skill to Add: " + this.skillsToAdd.toString() + "\n"
				+ "Feat to Add: " + this.featsToAdd.toString() + " NumBonusFeats: " + this.featsToAdd.size() + "\n"
				+ "Bonus Feat: " + this.bonusFeats + "\n"
				+ "Saving Throws Bonus: " + this.fortitudeSaveBonus + ":" + this.reflexSaveBonus + ":" + this.willSaveBonus + "\n"
				+ "Bonus Skill Ranks: " + this.bonusSkillRanks + "\n"
				+ "AC Bonus: " + this.acBonus + "\n"
				+ "Speed Bonus: " + this.speedBonus + "\n"
				+ "Initiative Bonus: " + this.initiativeBonus + "\n";
		String featDescriptions = "Feat Descriptions: \n";
		for (String featDescription : this.getFeatDescriptionsToAdd()) {
			featDescriptions += (featDescription + "\n");
		}
		String specialAbilitiesDescriptions = "Special Ability Descriptons: \n";
		for (String specialAbilityDescription : this.getSpecialAbilitiesDescriptionsToAdd()) {
			specialAbilitiesDescriptions += (specialAbilityDescription + "\n");
		}
		outputString += featDescriptions + specialAbilitiesDescriptions;
		return outputString;
	}

}
