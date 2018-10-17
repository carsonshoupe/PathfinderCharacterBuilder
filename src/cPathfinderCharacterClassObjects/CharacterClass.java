package cPathfinderCharacterClassObjects;

import java.util.ArrayList;

import cPathfinderCharacterObjects.CharacterModifierObject;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;

public abstract class CharacterClass {
	//Instance Variables:
	protected int level;
	protected String role;
	protected String alignmentRestriction;
	protected int hitDie;
	protected Skill[] classSkills;
	protected int skillRanksPerLevel;
	protected String weaponAndArmorProficiencies; 
	protected ArrayList<ClassFeature> classFeatures;
	protected ArrayList<Spell> spells;
	protected CharacterModifierObject modifierObject = new CharacterModifierObject();
	
	//Methods:
	public int getLevel( ) {return this.level;}
	public String getRole() {return this.role;}
	public String getAlignmentRestriction() {return this.alignmentRestriction;}
	public int getHitDie() {return this.hitDie;}
	public Skill[] getClassSkills() {return this.classSkills;}
	public int getSkillRanksPerLevel() {return this.skillRanksPerLevel;}
	public String getWeaponAndArmorProficiencies() {return this.weaponAndArmorProficiencies;}
	public ArrayList<ClassFeature> getClassFeatures() {return this.classFeatures;}
	public ArrayList<Spell> getSpells() {return this.spells;}

}
