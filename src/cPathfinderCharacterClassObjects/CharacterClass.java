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
	public static CharacterClass stringToClass(String classAsString) {
		//TODO: Implement Method
		return null;
	}
	
	//Instance Variables:
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
	
		//Modifications:
	protected ArrayList<String> specialAbilityDescriptions = new ArrayList<String>();
	
	//Methods:
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