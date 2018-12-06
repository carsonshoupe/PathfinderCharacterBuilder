package cPathfinderCharacterViewModelObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cPathfinderCharacterClassObjects.CharacterClass;
import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterObjects.Alignment;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.SortedList;


public class PathfinderCharacterViewModel {
	//Instance Variables:
	PathfinderCharacter pcModel;
	
	//Constructors:
	public PathfinderCharacterViewModel(PathfinderCharacter pc) {
		this.pcModel = pc;
		
	}
	
	//Methods: 
	
	 //PlayerMethods
	public String getPlayerName() {return pcModel.getPlayerName();}
	public void setPlayerName(String name) {pcModel.setPlayerName(name);}
	
	public int getCharacterId() {return pcModel.getCharacterId();}
	public void setCharacterId(int id) {pcModel.setCharacterId(id);}
	
	 //Aestetic Character Methods:
	public String getCharacterName() {return pcModel.getCharacterName();}
	public void setCharacterName(String name) {pcModel.setCharacterName(name);}
	
	public String getGender() {return pcModel.getGender();}
	public void setGender(String gender) {pcModel.setGender(gender);}
	
	public String getAge(Race race) {
		return Integer.toString(race.generateAge(this.pcModel.getAge()));
	}
	public void setAge(String age) {pcModel.setAge(age);}
	
	public String getHeight(Race race) {
		int heightInInches = race.generateHeight(this.pcModel.getHeight());
		int feet = heightInInches / 12;
		int inches = heightInInches % 12;
		return feet + "' " + inches + "''";		
	} 
	public void setHeight(String height) {pcModel.setHeight(height);} //in inches
	
	public String getWeight(Race race) {
		return Integer.toString(race.generateWeight(this.pcModel.getWeight()));
	}
	public void setWeight(String weight) {pcModel.setWeight(weight);} 
	
	public String getHairColor() {return pcModel.getHairColor();}
	public void setHairColor(String hairColor) {pcModel.setHairColor(hairColor);}
	
	public String getEyeColor() {return pcModel.getEyeColor();}
	public void setEyeColor(String eyeColor) {pcModel.setEyeColor(eyeColor);;}
	
	public String getDeity() {return pcModel.getDeity();}
	public void setDeity(String deity) {pcModel.setDeity(deity);}
	
	public String getHomeland() {return pcModel.getHomeland();}
	public void setHomeland(String homeland) {pcModel.setHomeland(homeland);;}
	
	public Alignment getAlignment() {return pcModel.getAlignment();}
	public void setAlignment(Alignment alignment) {pcModel.setAlignment(alignment);;}
	
	public String getAllignmentRestriction() {return pcModel.getAllignmentRestriction();}
	
	 //Ability Score Methods:
	public void setAbilityScores (int str, int dex, int con, int intel, int wis, int cha) {
		int[] abilityScore = {str, dex, con, intel, wis, cha};
		pcModel.setAbilityScores(abilityScore);
	}
	
	public void setStrength(int strength) {pcModel.setStrength(strength);}
	public void setDexterity(int dexterity) {pcModel.setDexterity(dexterity);}
	public void setConstitution(int constitution) {pcModel.setConstitution(constitution);}
	public void setIntelligence(int intelligence) {pcModel.setIntelligence(intelligence);;}
	public void setWisdom(int wisdom) {pcModel.setWisdom(wisdom);}
	public void setCharisma(int charisma) {pcModel.setCharisma(charisma);}
	
	public int getStrength() {return pcModel.getStrength();}
	public int getDexterity() {return pcModel.getDexterity();}
	public int getConstitution() {return pcModel.getConstitution();}
	public int getIntelligence() {return pcModel.getIntelligence();}
	public int getWisdom() {return pcModel.getWisdom();}
	public int getCharisma() {return pcModel.getCharisma();}
	
	public int getAbilityScoreModifier(int enumeratedAbilityScore) {return pcModel.getAbilityScoreModifier(enumeratedAbilityScore);}

	public int getStrenghModifier() {return pcModel.getStrengthModifier();}
	public int getDexterityModifier() {return pcModel.getDexterityModifier();}
	public int getConstitutionModifier() {return pcModel.getConstitutionModifier();}
	public int getIntelligenceModifier() {return pcModel.getIntelligenceModifier();}
	public int getWisdomModifier() {return pcModel.getWisdomModifier();}
	public int getCharismaModifier() {return pcModel.getCharismaModifier();}	
	
	public int abilityModifierToInt(String abilityModifier) {return pcModel.abilityModifierToInt(abilityModifier);}
	
	 //Hit Point Methods:
	public int getHitDie() {return pcModel.getHitDie();}
	
	 //Saving Throw Methods:
	public int getFortitudeSave() {return pcModel.getFortitudeSave();}
	public int getRefelxSave() {return pcModel.getRefelxSave();}
	public int getWillSave() {return pcModel.getWillSave();}
	
	 //Armor Class Methods:
	public int getArmorClass() {return pcModel.getArmorClass();}
	public int getTouchArmorClass() {return pcModel.getTouchArmorClass();}
	public int getFlatFootedArmorClass() {return pcModel.getFlatFootedArmorClass();}	
	public void incrementMiscArmorClassModifier(int value) {pcModel.incrementMiscArmorClassModifier(value);}
	
	 //Speed Methods:
	public int getSpeed() {return pcModel.getSpeed();}
	
	 //Initiative Methods:
	public int getInitiative() {return pcModel.getInitiative();}
	
	 //Race Methods:
	public Race getRace() {return pcModel.getRace();}
	public void setRace(String raceChoice) {pcModel.setRace(Race.stringToRace(raceChoice));}
	
	 //Class Methods:
	public CharacterClass getCharacterClass() {return pcModel.getCharacterClass();}
	public void setCharacterClass(String classChoice, int level) {pcModel.setCharacterClass(CharacterClass.stringToClass(classChoice, level));}
	public void setClassSkills(Set<Skill> classSkills) {pcModel.setClassSkills(classSkills);}
	public String getWeaponAndArmorProficiencies() {return pcModel.getWeaponAndArmorProficiencies();}
		//there will be more here
	
	 //Skill Methods:
	public CharacterSkills getCharacterSkillsObject() {return pcModel.getCharacterSkills();}
	
	public SortedList<Skill> getCharacterSkills() {return getCharacterSkillsObject().getCharacterSkillsList();}
	
	public Set<Skill> getClassSkills() {return pcModel.getClassSkills();}
	
	public int getSkillRanksPerLevel() {return pcModel.getSkillRanksPerLevel();}
	
	public SimpleIntegerProperty getSkillRanks(Skill skill) {return pcModel.getSkillRanks(skill);}
	public void incrementSkillRanks(Skill skill, int value) {pcModel.getCharacterSkills().incrementSkillRanks(skill, value);}
	public void setSkillRanks(Skill skill, int value) {pcModel.setSkillRanks(skill, value);}
	
	public SimpleIntegerProperty getMiscSkillMod(Skill skill) {return pcModel.getMiscSkillMod(skill);}
	
	public SimpleIntegerProperty getSkillBonus(Skill skill) {return new SimpleIntegerProperty(pcModel.getSkillBonus(skill));}
	
	 //Feat Methods:
	public void addFeat(Feat feat) {pcModel.getCharacterFeats().addFeat(feat);}
	public void removeFeat(Feat feat) {
		Set<Feat> feats = pcModel.getCharacterFeats().getFeats();
		if (feats.contains(feat)) {feats.remove(feat);}
		else {}
	}
	public Set<Feat> getFeats() {return pcModel.getCharacterFeats().getFeats();}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
