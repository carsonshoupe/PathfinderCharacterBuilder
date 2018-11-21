package cPathfinderCharacterSkillObjects;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CharacterSkillProperties {
	//Static Constants:
	private static int CLASS_SKILL_BONUS = 3;
	
	//Instance Variables:
	private SimpleIntegerProperty skillRanks = new SimpleIntegerProperty(0);
	private SimpleIntegerProperty miscSkillMod = new SimpleIntegerProperty(0);
	private SimpleBooleanProperty classSkill = new SimpleBooleanProperty(false);
	
	//Constructor
	CharacterSkillProperties() {
		this.skillRanks.set(0);
		this.miscSkillMod.set(0);
		this.classSkill.set(false);
	}
	
	//Methods:
	public IntegerProperty skillRanksProperty() {
		if (this.skillRanks == null) this.skillRanks = new SimpleIntegerProperty(this, "skillRanks");
		return this.skillRanks;
	}
	public IntegerProperty miscSkillModProperty() {
		if (this.miscSkillMod == null) this.miscSkillMod = new SimpleIntegerProperty(this, "miscSkillMod");
		return this.miscSkillMod;
	}
	public BooleanProperty classSkillProperty() {
		if (this.classSkill == null) this.classSkill = new SimpleBooleanProperty(this, "classSkill");
		return this.classSkill;
	}
	
	public SimpleIntegerProperty getSkillRanks() {return this.skillRanks;}
	public void incrementSkillRanks(int value) {this.skillRanks.set(skillRanks.intValue() + value);}
	public void setSkillRanks(int value) {this.skillRanks.set(value);}
	
	public SimpleIntegerProperty getMiscSkillMod() {
		if (this.classSkill.getValue() && this.skillRanks.getValue() > 0) {
			return new SimpleIntegerProperty(this.miscSkillMod.getValue() + CLASS_SKILL_BONUS);
		}
		else {
			return this.miscSkillMod;
		}
	}
	public void incrementMiscSkillMod(int value) {this.miscSkillMod.set(miscSkillMod.intValue() + value);}
	
	public SimpleBooleanProperty getClassSkill() {return this.classSkill;}
	public void setClassSkill(Boolean bool) {this.classSkill.set(bool);}
	

}
