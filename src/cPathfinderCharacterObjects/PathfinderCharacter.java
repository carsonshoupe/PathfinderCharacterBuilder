package cPathfinderCharacterObjects;

import java.util.ArrayList;
import java.lang.Math;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;

public abstract class PathfinderCharacter {
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
	protected int strength; 
	protected int dexterity;
	protected int constitution;
	protected int intelligence;
	protected int wisdom;
	protected int charisma;
	
	protected int strengthModifier = (int) Math.floor((this.strength-10)/2.0);
	protected int dexterityModifier = (int) Math.floor((this.dexterity-10)/2.0);
	protected int constitutionModifier = (int) Math.floor((this.constitution-10)/2.0);
	protected int intelligenceModifier = (int) Math.floor((this.intelligence-10)/2.0);
	protected int wisdomModifier = (int) Math.floor((this.wisdom-10)/2.0);
	protected int charismaModifier = (int) Math.floor((this.charisma-10)/2.0);
	
	protected int[] abilityScores = {this.strength, this.dexterity, this.constitution, this.intelligence, this.wisdom, this.charisma};

	//Properties affected by Race
	protected Race race;
	protected Sizes size;
	protected int speed; //in feet
	protected String[] knownLanguages;
	
	//Properties affected by Class
	protected String role;
	protected String allignmentRestriction;
	protected int hitDie;
	protected Skill[] classSkills;
	protected int skillRanksPerLevel;
	protected String weaponAndArmorProficiencies;
	protected ArrayList<ClassFeature> classFeatures;
	protected ArrayList<Spell> spells;
	
	//Skill Properties
	protected CharacterSkills characterSkills;
	
	//Feat Properties
	protected ArrayList<Feat> characterFeats;
	
	
	
	
	
	
	
	//Methods: 
	public void setStrength(int strength) {this.strength = strength;}
	public void setDexterity(int dexterity) {this.dexterity = dexterity;}
	public void setConstitution(int constitution) {this.constitution = constitution;}
	public void setIntelligence(int intelligence) {this.intelligence = intelligence;}
	public void setWisdom(int wisdom) {this.wisdom = wisdom;}
	public void setCharisma(int charisma) {this.strength = charisma;}
	
	public int getStrength() {return this.strength;}
	public int getDexterity() {return this.dexterity;}
	public int getConstitution() {return this.constitution;}
	public int getIntelligence() {return this.intelligence ;}
	public int getWisdom() {return this.wisdom;}
	public int getCharisma() {return this.strength;}
	
	public int getStrenghModifier() {return this.strengthModifier;}
	public int getDexterityModifier() {return this.dexterityModifier;}
	public int getConstitutionModifier() {return this.constitutionModifier;}
	public int getIntelligenceModifier() {return this.intelligenceModifier;}
	public int getWisdomModifier() {return this.wisdomModifier;}
	public int getCharismaModifier() {return this.charismaModifier;}
	
	public CharacterSkills getCharacterSkills() {return this.characterSkills;}
	
	
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
	
	public Skill[] getClassSkills() {return this.classSkills;}
}
