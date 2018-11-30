package cPathfinderCharacterObjects;

import java.util.ArrayList;
import java.util.Set;

import cPathfinderCharacterRaceObjects.Dwarf;
import cPathfinderCharacterRaceObjects.Human;
import cPathfinderCharacterClassObjects.CharacterClass;
import cPathfinderCharacterClassObjects.ClassFeature;

import java.lang.Math;

import cPathfinderCharacterFeatObjects.CharacterFeats;
import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterItems.CharacterArmor;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;
import javafx.beans.property.SimpleIntegerProperty;

public class PathfinderCharacter {
	//Instance Variables: 
	
	 //Player Variables
	protected String playerName;
	protected int characterId;
	
	 //Aesthetic Character Variables
	protected String characterName;
	protected String gender; 
	protected String age = "Young Adult";
	protected String height = "Medium";
	protected String weight = "Medium"; 
	protected String hairColor; 
	protected String eyeColor; 
	protected String deity; 
	protected String homeland;
	protected Alignment alignment;
	
	 //Ability Points
	protected int[] abilityScores = {10, 10, 10, 10, 10, 10};
	
	 //Armor Class Properties:
	protected CharacterArmor armorClassItems; 
	protected int miscArmorClassModifier = 0;

	 //Race
	protected Race race;
	protected int miscSpeedBonus = 0;
	
	 //Character Class
	protected CharacterClass characterClass;
	
	 //Skill Properties
	protected CharacterSkills characterSkills = new CharacterSkills();
	
	 //Feats
	protected CharacterFeats characterFeats = new CharacterFeats();
	
	 //Text Descriptions of Feats and Class Features:
	protected ArrayList<String> featDescriptions = new ArrayList<String>();
	protected ArrayList<String> specialAbilitiesDescriptions = new ArrayList<String>();
	
	
	//Constructors:
	
	
	//Methods: 
	
	 //Player Methods
	public String getPlayerName() {return this.playerName;}
	public int getCharacterId() {return this.characterId;}
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	public void setCharacterId(int characterId) {this.characterId = characterId;}
	
	 //Aesthetic Character Methods
	public String getCharacterName() {return this.characterName;}
	public void setCharacterName(String name) {this.characterName = name;}
	
	public String getGender() {return this.gender;}
	public void setGender(String gender) {this.gender = gender;}
	
	public String getAge() {return this.age;}
	public void setAge(String age) {this.age = age;}
	
	public String getHeight() {return this.height;}
	public void setHeight(String height) {this.height = height;} //in inches
	
	public String getWeight() {return this.weight;}
	public void setWeight(String weight) {this.weight = weight;} 
	
	public String getHairColor() {return this.hairColor;}
	public void setHairColor(String hairColor) {this.hairColor = hairColor;}
	
	public String getEyeColor() {return this.eyeColor;}
	public void setEyeColor(String eyeColor) {this.eyeColor = eyeColor;}
	
	public String getDeity() {return this.deity;}
	public void setDeity(String deity) {this.deity = deity;}
	
	public String getHomeland() {return this.homeland;}
	public void setHomeland(String homeland) {this.homeland = homeland;}
	
	public Alignment getAlignment() {return this.alignment;}
	public void setAlignment(Alignment alignment) {this.alignment = alignment;}
	
	public String getAllignmentRestriction() {return this.characterClass.getAlignmentRestriction();}
	
	 //Ability Score Methods
	public void setAbilityScores(int[] abilityScores) {this.abilityScores = abilityScores;}
	
	public void setStrength(int strength) {this.abilityScores[0] = strength;}
	public void setDexterity(int dexterity) {this.abilityScores[1] = dexterity;}
	public void setConstitution(int constitution) {this.abilityScores[2] = constitution;}
	public void setIntelligence(int intelligence) {this.abilityScores[3] = intelligence;}
	public void setWisdom(int wisdom) {abilityScores[4] = wisdom;}
	public void setCharisma(int charisma) {abilityScores[5] = charisma;}
	
	public int getStrength() {return this.abilityScores[0];}
	public int getDexterity() {return this.abilityScores[1];}
	public int getConstitution() {return this.abilityScores[2];}
	public int getIntelligence() {return this.abilityScores[3];}
	public int getWisdom() {return this.abilityScores[4];}
	public int getCharisma() {return this.abilityScores[5];}
	
	public int getAbilityScoreModifier(int enumeratedAbilityScore) {return (int) Math.floor((this.abilityScores[enumeratedAbilityScore]-10)/2.0);}
	
	public int getStrengthModifier() {return (int) Math.floor((getStrength()-10)/2.0);}
	public int getDexterityModifier() {return (int) Math.floor((getDexterity()-10)/2.0);}
	public int getConstitutionModifier() {return (int) Math.floor((getConstitution()-10)/2.0);}
	public int getIntelligenceModifier() {return (int) Math.floor((getIntelligence()-10)/2.0);}
	public int getWisdomModifier() {return (int) Math.floor((getWisdom()-10)/2.0);}
	public int getCharismaModifier() {return (int) Math.floor((getCharisma()-10)/2.0);}
	
	 //Hit Point Methods
	public int getHitDie() {return this.characterClass.getHitDie();};
	
	 //Saving Throw Methods
	public int getFortitudeSave() {return this.characterClass.getBaseFortSave() + this.getConstitutionModifier() + this.race.getFortSaveModifier() + this.characterFeats.getFortSaveModifier();}
	public int getRefelxSave() {return this.characterClass.getBaseReflexSave() + this.getDexterityModifier() + this.race.getReflexSaveModifier() + this.characterFeats.getReflexSaveModifier();}
	public int getWillSave() {return this.characterClass.getBaseWillSave() + this.getWisdomModifier() + this.race.getWillSaveModifier() + this.characterFeats.getWillSaveModifier();}
	
	 //Armor Class Methods
	public int getArmorClass() {return 10 + this.armorClassItems.getArmorAcBonus() + this.getDexterityModifier() + this.race.getSize().getSizeModifier() + this.miscArmorClassModifier;} 
	public int getTouchArmorClass() {return 10 + this.getDexterityModifier() + this.race.getSize().getSizeModifier() + this.miscArmorClassModifier;} 
	public int getFlatFootedArmorClass() {return 10 + this.armorClassItems.getArmorAcBonus() + this.race.getSize().getSizeModifier() + this.miscArmorClassModifier;} 
	public void incrementMiscArmorClassModifier(int value) {this.miscArmorClassModifier += value;}
	
	 //Speed Methods
	public int getSpeed() {return this.race.getBaseSpeed() + this.miscSpeedBonus;}
	
	 //Initiative Methods
	public int getInitiative() {return this.getDexterityModifier() + this.characterFeats.getInitiativeModifier();}
	
	 //Race Methods
	public Race getRace() {return this.race;}
	public void setRace(Race raceChoice) {this.race = raceChoice;}
	
	 //Class Methods: 
	public CharacterClass getCharacterClass() {return this.characterClass;}
	public void setCharacterClass(CharacterClass classChoice) {this.characterClass = classChoice;}
	public void setClassSkills(Set<Skill> classSkills) {this.getCharacterSkills().setClassSkills(classSkills);}
	
	public String getWeaponAndArmorProficiencies() {return this.characterClass.getWeaponAndArmorProficiencies();}
	
	public Set<ClassFeature> getClassFeatures() {return this.characterClass.getClassFeatures();}
	
	 //Skill Methods:
	public CharacterSkills getCharacterSkills() {return this.characterSkills;}
	public void setCharacterSkills(CharacterSkills characterSkills) {this.characterSkills = characterSkills;}
	
	public Set<Skill> getClassSkills() {return this.characterClass.getClassSkills();}
	public int getSkillRanksPerLevel() {return this.characterClass.getSkillRanksPerLevel() + this.getIntelligenceModifier();}
	
	public SimpleIntegerProperty getSkillRanks(Skill skill) {return getCharacterSkills().getSkillRanks(skill);}
	public void setSkillRanks(Skill skill, int value) {this.getCharacterSkills().setSkillRanks(skill, value);}
	
	public SimpleIntegerProperty getMiscSkillMod(Skill skill) {return getCharacterSkills().getMiscSkillMod(skill);}

	public int getSkillBonus(Skill skill) {
		if (skill.isTrainedOnly() && getCharacterSkills().getSkillRanks(skill).intValue() == 0) {
			return 0;
		}
		else {
			return this.characterSkills.getClassSkillBonus(skill).getValue() + this.getAbilityScoreModifier(this.abilityModifierToInt(skill.getAbilityModifier()));
		}
	}
	
	 //Language Methods
	public ArrayList<String> getKnownLanguages() {return null;} //TODO: Uses Race and class, and languages can be added based on the Linguistics Skill
	
	 //Feat Methods
	public CharacterFeats getCharacterFeats() {return this.characterFeats;}
	public void setCharacterFeats(CharacterFeats characterFeats) {this.characterFeats = characterFeats;}
	
	public ArrayList<Feat> getFeats() {return this.characterFeats.getFeats();}
	public ArrayList<String> getFeatDescriptions() {return this.characterFeats.getFeatDescriptions();}
	
	 //Special Ability Methods:
	public ArrayList<String> getSpecialAbilityDescriptions() {
		ArrayList<String> outputArrayList = new ArrayList<String>();
		outputArrayList.addAll(this.characterClass.getSpecialAbilityDescriptions());
		outputArrayList.addAll(this.race.getSpecialAbilityDescriptions());
		return outputArrayList;
	}
	
	 //Spell Methods:
	//TODO: Fix spells getter
	public Set<Spell> getSpells() {return this.characterClass.getSpells();}

	
	@SuppressWarnings("unchecked")
	@Override
	public PathfinderCharacter clone() { //TODO
		PathfinderCharacter outputCharacter = new PathfinderCharacter();
		
		outputCharacter.setPlayerName(this.playerName);
		outputCharacter.setCharacterId(this.characterId);
		
		outputCharacter.setCharacterName(this.characterName);
		outputCharacter.setAge(this.age);
		outputCharacter.setHeight(this.height);
		outputCharacter.setWeight(this.weight);
		outputCharacter.setHairColor(this.hairColor);
		outputCharacter.setEyeColor(this.eyeColor);
		outputCharacter.setDeity(this.deity);
		outputCharacter.setHomeland(this.homeland);
		outputCharacter.setAlignment(this.alignment);
		
		outputCharacter.setAbilityScores(this.abilityScores.clone());
		
		try {
			outputCharacter.setRace(this.race.clone());
		}
		catch (CloneNotSupportedException ex) {
			System.out.println("Failed to clone Race");
		}
		
		try {
			outputCharacter.setCharacterClass((CharacterClass) this.characterClass.clone());
		}
		catch (CloneNotSupportedException ex) {
			System.out.println("Failed to clone Character Class");
		}
		
		outputCharacter.setCharacterSkills((CharacterSkills) this.getCharacterSkills().clone());
		
		outputCharacter.setCharacterFeats((CharacterFeats) this.getCharacterFeats().clone());
				
		return outputCharacter;
	}
	
	public int abilityModifierToInt(String abilityModifier) {
		if (abilityModifier.equals("STR")) {
			return 0;
		}
		else if (abilityModifier.equals("DEX")) {
			return 1;
		}
		else if (abilityModifier.equals("CON")) {
			return 2;
		}
		else if (abilityModifier.equals("INT")) {
			return 3;
		}
		else if (abilityModifier.equals("WIS")) {
			return 4;
		}
		else {
			return 5;
		}
	}
}
