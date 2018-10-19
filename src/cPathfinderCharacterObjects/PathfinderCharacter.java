package cPathfinderCharacterObjects;

import java.util.ArrayList;
import java.util.Set;

import cPathfinderCharacterClassObjects.CharacterClass;
import cPathfinderCharacterClassObjects.ClassFeature;

import java.lang.Math;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;

public class PathfinderCharacter {
	//Instance Variables: 
	protected String playerName;
	protected int characterId;
	
	protected String characterName;
	protected String gender; 
	protected int age;
	protected int height; //in inches
	protected int weight; 
	protected String hairColor; 
	protected String eyeColor; 
	protected String deity; 
	protected String homeland;
	protected Alignment alignment;
	
	//Ability Points
	protected int[] abilityScores = {10, 10, 10, 10, 10, 10};
	
	//Saving Throw Bonuses: 
	protected int[] savingThrowBonuses = {0, 0, 0};
	
	//AC Bonus:
	protected int AcBonus = 0;
	
	//Initiative bonus
	protected int initiativeBonus;

	//Properties affected by Race
	protected Race race;
	protected Sizes size;
	protected int baseSpeed; //in feet
	protected int speedBonus = 0;
	protected String[] knownLanguages;
	
	//Properties affected by Class
	protected CharacterClass characterClass;
	protected String allignmentRestriction;
	protected int hitDie;
	protected Set<Skill> classSkills;
	protected int skillRanksPerLevel;
	protected String weaponAndArmorProficiencies;
	protected ArrayList<ClassFeature> classFeatures;
	protected ArrayList<Spell> spells;
	
	//Skill Properties
	protected CharacterSkills characterSkills = new CharacterSkills();
	
	//Feats
	protected ArrayList<Feat> characterFeats = new ArrayList<Feat>();
	
	//Text Descriptions of Feats and Class Features:
	protected ArrayList<String> featDescriptions = new ArrayList<String>();
	protected ArrayList<String> specialAbilitiesDescriptions = new ArrayList<String>();
	
	
	//Constructors:
	
	
	//Methods: 
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	public void setCharacterId(int characterId) {this.characterId = characterId;}
	
	public void setCharacterName(String playerName) {this.characterName = playerName;}
	public String getCharacterName() {return this.characterName;}
	public void SetGender(String gender) {this.gender = gender;}
	public void setAge(int age) {this.age = age;}
	public void setHeight(int height) {this.height = height;} //in inches
	public void setWeight(int weight) {this.weight = weight;} 
	public void setHairColor(String hairColor) {this.hairColor = hairColor;}
	public void setEyeColor(String eyeColor) {this.eyeColor = eyeColor;}
	public void setDeity(String deity) {this.deity = deity;}
	public void setHomeland(String homeland) {this.homeland = homeland;}
	public void setAlignment(Alignment alignment) {this.alignment = alignment;}
	
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
	public int getIntelligence() {return this.abilityScores[3] ;}
	public int getWisdom() {return this.abilityScores[4];}
	public int getCharisma() {return this.abilityScores[5];}
	
	public int getStrenghModifier() {return (int) Math.floor((getStrength()-10)/2.0);}
	public int getDexterityModifier() {return (int) Math.floor((getDexterity()-10)/2.0);}
	public int getConstitutionModifier() {return (int) Math.floor((getConstitution()-10)/2.0);}
	public int getIntelligenceModifier() {return (int) Math.floor((getIntelligence()-10)/2.0);}
	public int getWisdomModifier() {return (int) Math.floor((getWisdom()-10)/2.0);}
	public int getCharismaModifier() {return (int) Math.floor((getCharisma()-10)/2.0);}
	
	public int[] getSavingThrowBonuses() {return this.savingThrowBonuses;}
	public int getFortitudeSaveBonus() {return this.savingThrowBonuses[0];}
	public int getReflexSaveBonus() {return this.savingThrowBonuses[1];}
	public int getWillSaveBonus() {return this.savingThrowBonuses[2];}
	public void incrementFortitudeSaveBonus(int value) {this.savingThrowBonuses[0] += value;}
	public void incrementReflexSaveBonus(int value) {this.savingThrowBonuses[1] += value;}
	public void incrementWillSaveBonus(int value) {this.savingThrowBonuses[2] += value;}
	
	public int getAcBonus() {return this.AcBonus;}
	public void incrementAcBonus(int value) {this.AcBonus += value;}
	
	public void setBaseSpeed(int value) {this.baseSpeed = value;}
	public void incrementSpeedBonus(int value) {this.speedBonus = value;}
	public int getSpeed() {return (this.baseSpeed + this.speedBonus);}
	
	public void setInitiativeBonus(int value) {this.initiativeBonus = value;}
	public int getInitiative() {return (this.getDexterityModifier() + this.initiativeBonus);}
	
	public CharacterClass getCharacterClass() {return this.characterClass;}
	public String getAllignmentRestriction() {return this.allignmentRestriction;}
	public int getHitDie() {return this.hitDie;};
	public Set<Skill> getClassSkills() {return this.classSkills;}
	public int getSkillRanksPerLevel() {return this.skillRanksPerLevel;}
	public String getWeaponAndArmorProficiencies() {return this.weaponAndArmorProficiencies;}
	public ArrayList<ClassFeature> getClassFeatures() {return this.classFeatures;}
	public ArrayList<Spell> getSpells() {return this.spells;}
	
	public CharacterSkills getCharacterSkills() {return this.characterSkills;}
	public void setCharacterSkills(CharacterSkills characterSkills) {this.characterSkills = characterSkills;}
	public ArrayList<Feat> getCharacterFeats() {return this.characterFeats;}
	public void setCharacterFeats(ArrayList<Feat> feats) {this.characterFeats = feats;}
	
	public ArrayList<String> getFeatDescriptions() {return this.featDescriptions;}
	public void addFeatDescription(String featDescription) {this.featDescriptions.add(featDescription);}
	public void setFeatDescriptions(ArrayList<String> featDescriptions) {this.featDescriptions = featDescriptions;}
	public ArrayList<String> getSpecialAbilityDescriptions() {return this.specialAbilitiesDescriptions;}
	public void addSpecialAbilityDescription(String specialAbilityDescription) {this.specialAbilitiesDescriptions.add(specialAbilityDescription);}
	public void setSpecialAbilityDescriptions(ArrayList<String> specialAbilityDescriptions) {this.specialAbilitiesDescriptions = specialAbilityDescriptions;}
	
	
	public void setRace(Race raceChoice) {
		this.race = raceChoice; 
		this.size = raceChoice.getSize();
		this.baseSpeed = raceChoice.getSpeed();
		this.knownLanguages = raceChoice.getKnownLanguages();
		/*
		** TODO: 
		** 1. race will update ability score with modifier 
		** 2. race will affect stats based on shouldUpdateCharacterSheet property of RacialTrait
		** 3. Even after selecting race, user still has to decide ability modifiers for some races 
		**    and extra languages if intelligence is high enough. -- need to find some way to queue to do list 
		**    in builder, but not in any particular order
		*/
	}
	public Race getRace() {return this.race;}
	
	public void setCharacterClass(CharacterClass classChoice) {
		this.characterClass = classChoice;
		this.allignmentRestriction = classChoice.getAlignmentRestriction();
		this.hitDie = classChoice.getHitDie();
		this.classSkills = classChoice.getClassSkills();
		this.skillRanksPerLevel = classChoice.getSkillRanksPerLevel() + this.getIntelligenceModifier();
		this.weaponAndArmorProficiencies = classChoice.getWeaponAndArmorProficiencies();
		this.classFeatures = classChoice.getClassFeatures();
		this.spells = classChoice.getSpells();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PathfinderCharacter clone() {
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
		
		outputCharacter.setAbilityScores(this.abilityScores);
		
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
		
		ArrayList<Feat> characterFeatsArrForClone = new ArrayList<Feat>();
		for (Feat characterFeat : this.getCharacterFeats()) {
			characterFeatsArrForClone.add(characterFeat);
		}
		outputCharacter.setCharacterFeats(characterFeatsArrForClone);
		
		outputCharacter.setFeatDescriptions((ArrayList<String>) this.getFeatDescriptions().clone());
		
		outputCharacter.setSpecialAbilityDescriptions((ArrayList<String>) this.getSpecialAbilityDescriptions().clone());
				
		return outputCharacter;
	}
}
