package cPathfinderCharacterObjects;

import java.util.ArrayList;

import cPathfinderCharacterClassObjects.CharacterClass;
import cPathfinderCharacterClassObjects.ClassFeature;

import java.lang.Math;

import cPathfinderCharacterFeatObjects.CharacterFeats;
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
	
	protected int strengthModifier = (int) Math.floor((getStrength()-10)/2.0);
	protected int dexterityModifier = (int) Math.floor((getDexterity()-10)/2.0);
	protected int constitutionModifier = (int) Math.floor((getConstitution()-10)/2.0);
	protected int intelligenceModifier = (int) Math.floor((getIntelligence()-10)/2.0);
	protected int wisdomModifier = (int) Math.floor((getWisdom()-10)/2.0);
	protected int charismaModifier = (int) Math.floor((getCharisma()-10)/2.0);

	//Properties affected by Race
	protected Race race;
	protected Sizes size;
	protected int speed; //in feet
	protected String[] knownLanguages;
	
	//Properties affected by Class
	protected CharacterClass characterClass;
	protected String role;
	protected String allignmentRestriction;
	protected int hitDie;
	protected Skill[] classSkills;
	protected int skillRanksPerLevel;
	protected String weaponAndArmorProficiencies;
	protected ArrayList<ClassFeature> classFeatures;
	protected ArrayList<Spell> spells;
	
	//Skill Properties
	protected CharacterSkills characterSkills = new CharacterSkills();
	
	//Feat Properties
	protected CharacterFeats characterFeats = new CharacterFeats();
	
	//Text Descriptions of Feats and Class Features:
	protected ArrayList<String> featDescriptions = new ArrayList<String>();
	protected ArrayList<String> specialAbilitiesDescriptions = new ArrayList<String>();
	
	
	//Constructors:
	
	
	
	
	//Methods: 
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
	
	public int getStrenghModifier() {return this.strengthModifier;}
	public int getDexterityModifier() {return this.dexterityModifier;}
	public int getConstitutionModifier() {return this.constitutionModifier;}
	public int getIntelligenceModifier() {return this.intelligenceModifier;}
	public int getWisdomModifier() {return this.wisdomModifier;}
	public int getCharismaModifier() {return this.charismaModifier;}
	
	public CharacterClass getCharacterClass() {return this.characterClass;}
	public String getRole() {return this.role;}
	public String getAllignmentRestriction() {return this.allignmentRestriction;}
	public int getHitDie() {return this.hitDie;};
	public Skill[] getClassSkills() {return this.classSkills;}
	public int getSkillRanksPerLevel() {return this.skillRanksPerLevel;}
	public String getWeaponAndArmorProficiencies() {return this.weaponAndArmorProficiencies;}
	public ArrayList<ClassFeature> getClassFeatures() {return this.classFeatures;}
	public ArrayList<Spell> getSpells() {return this.spells;}
	
	public CharacterSkills getCharacterSkills() {return this.characterSkills;}
	public CharacterFeats getCharacterFeats() {return this.characterFeats;}
	
	public ArrayList<String> getFeatDescriptions() {return this.featDescriptions;}
	public ArrayList<String> getSpecialAbilitiesDescriptions() {return this.specialAbilitiesDescriptions;}
	
	
	public void setRace(Race raceChoice) {
		this.race = raceChoice; 
		this.size = raceChoice.getSize();
		this.speed = raceChoice.getSpeed();
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
		this.role = classChoice.getRole();
		this.allignmentRestriction = classChoice.getAlignmentRestriction();
		this.hitDie = classChoice.getHitDie();
		this.classSkills = classChoice.getClassSkills();
		this.skillRanksPerLevel = classChoice.getSkillRanksPerLevel() + this.getIntelligenceModifier();
		this.weaponAndArmorProficiencies = classChoice.getWeaponAndArmorProficiencies();
		this.classFeatures = classChoice.getClassFeatures();
		this.spells = classChoice.getSpells();
		
	}
	
	@Override
	public PathfinderCharacter clone() {
		PathfinderCharacter outputCharacter = new PathfinderCharacter();
		
		/*
		 * TODO: 
		 * In OutputCharacter
		 * 1. Update all base properties
		 * 2. Update all skill ranks
		 * 3. Update all feats
		 * 4. update all class features
		 */
		
		return outputCharacter;
	}
}
