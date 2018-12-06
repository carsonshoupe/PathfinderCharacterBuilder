package cPathfinderCharacterClassObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cPathfinderCharacterObjects.CharacterModifier;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.CharacterSpells;
import cPathfinderCharacterSpellObjects.Spell;

public abstract class CharacterClass implements CharacterModifier {
	//Static Methods:
	public static CharacterClass stringToClass(String classAsString, int level) {
		if (classAsString.equals("Barbarian")) {return new Barbarian(level);}
		else if (classAsString.equals("Bard")) {return new Bard(level);}
		else if (classAsString.equals("Cleric")) {return new Cleric(level);}
		else if (classAsString.equals("Druid")) {return new Druid(level);}
		else if (classAsString.equals("Fighter")) {return new Fighter(level);}
		else if (classAsString.equals("Monk")) {return new Monk(level);}
		else if (classAsString.equals("Paladin")) {return new Paladin(level);}
		else if (classAsString.equals("Ranger")) {return new Ranger(level);}
		else if (classAsString.equals("Rogue")) {return new Rogue(level);}
		else if (classAsString.equals("Sorcerer")) {return new Sorcerer(level);}
		else if (classAsString.equals("Wizard")) {return new Wizard(level);}
		else {return null;}
	}
	
	//Instance Variables:
	protected String name;
	protected int level;
	protected String alignmentRestriction;
	protected int hitDie;
	protected Set<Skill> classSkills;
	protected int skillRanksPerLevel;
	protected String weaponAndArmorProficiencies; 
	protected int[] baseSavingThrows = {0, 0, 0};
	protected Set<ClassFeature> classFeatures = new HashSet<ClassFeature>();
	protected CharacterSpells characterSpellsObject = new CharacterSpells();
	protected Set<Spell> spells = new HashSet<Spell>();
	
	protected String description;
	protected String role;
	
		//Modifications:
	protected ArrayList<String> specialAbilityDescriptions = new ArrayList<String>();
	
	//Methods:
	public String getName() {return this.name;}
	public int getLevel() {return this.level;}
	public String getAlignmentRestriction() {return this.alignmentRestriction;}
	public int getHitDie() {return this.hitDie;}
	public Set<Skill> getClassSkills() {return this.classSkills;}
	public int getSkillRanksPerLevel() {return this.skillRanksPerLevel;}
	public String getWeaponAndArmorProficiencies() {return this.weaponAndArmorProficiencies;}
	public int getBaseFortSave() {return this.baseSavingThrows[0];}
	public int getBaseReflexSave() {return this.baseSavingThrows[1];}
	public int getBaseWillSave() {return this.baseSavingThrows[2];}
	public Set<ClassFeature> getClassFeatures() {return this.classFeatures;}
	public Set<Spell> getSpells() {return this.spells;}
	public ArrayList<String> getSpecialAbilityDescriptions() {return this.specialAbilityDescriptions;}
	
	public String getDescription() {return this.description;}
	public String getRole() {return this.role;}
	
	public PathfinderCharacter updateCharacter(PathfinderCharacter pathfinderCharacter) {
		PathfinderCharacter outputCharacter = pathfinderCharacter.clone();
		try {
			if (pathfinderCharacter.getCharacterClass() instanceof CharacterClass) {
				outputCharacter.setCharacterClass(pathfinderCharacter.getCharacterClass().clone());
			}
		}
		catch (CloneNotSupportedException ex) {
			System.out.println("Failed to clone Character Class");
		}
		
		return outputCharacter;
	}
	
	public String modificationsToString() {
		String outputString = "Level: " + this.level + "\n"
				+ "Alignment Restriction: " + this.alignmentRestriction.toString() + "\n"
				+ "Hit Die: " + this.getHitDie() + "\n"
				+ "Class Skills: " + this.getClassSkills().toString() + "\n"
				+ "Weapon and Armor Proficiencies: " + this.getWeaponAndArmorProficiencies() + "\n"; 
		
		String classFeaturesString = "Class Features: "; 
		for (ClassFeature classFeature : this.getClassFeatures()) {
			classFeaturesString += classFeature.toString() + "  "; 
		}
		outputString += classFeaturesString + "\n" 
				+ "Spells: " + this.getSpells().toString() + "\n";
		
		String specialAbilityDescriptions = ""; 
		for (ClassFeature classFeature : this.getClassFeatures()) {
			specialAbilityDescriptions += classFeature.getName() + ": " + classFeature.getFullDescription() + "\n";
		}
		outputString += specialAbilityDescriptions;
		return outputString;
	}
	
	@Override
	public CharacterClass clone() throws CloneNotSupportedException {
		return (CharacterClass) super.clone();
	}
}