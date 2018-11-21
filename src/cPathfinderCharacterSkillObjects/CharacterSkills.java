package cPathfinderCharacterSkillObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;


public class CharacterSkills {	
	//Instance Variables: 	
	private Skill[] characterSkills = {new Skill("ACROBATICS"), new Skill("APPRAISE"), new Skill("BLUFF"), new Skill("CLIMB"),
			new Skill("CRAFT1"), new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("DIPLOMACY"), new Skill("DISABLE_DEVICE"), 
			new Skill("ESCAPE_ARTIST"), new Skill("FLY"), new Skill("HANDLE_ANIMAL"), new Skill("HEAL"), new Skill("INTIMIDATE"), 
			new Skill("KNOWLEDGE_ARCANA"), new Skill("KNOWLEDGE_DUNGEONEERING"), new Skill("KNOWLEDGE_ENGINEERING"),
			new Skill("KNOWLEDGE_GEOGRAPHY"), new Skill("KNOWLEDGE_HISTORY"), new Skill("KNOWLEDGE_LOCAL"), new Skill("KNOWLEDGE_NATURE"), 
			new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_PLANES"), new Skill("KNOWLEDGE_RELIGION"), new Skill("LINGUISTICS"),
			new Skill("PERCEPTION"), new Skill("PERFORM1"), new Skill("PERFORM2"), new Skill("PROFESSION1"), new Skill("PROFESSION2"),
			new Skill("RIDE"), new Skill("SENSE_MOTIVE"), new Skill("SLIGHT_OF_HAND"), new Skill("SPELLCRAFT"), new Skill("STEALTH"),
			new Skill("SURVIVAL"), new Skill("SWIM"), new Skill("USE_MAGICAL_DEVICE")};
	
	private SortedList<Skill> characterSkillsList = new SortedList<Skill>(FXCollections.observableArrayList(Arrays.asList(this.characterSkills))); //TODO: Add Comparator
	
	private Map<Skill, CharacterSkillProperties> characterSkillPropertiesMap = new HashMap<Skill, CharacterSkillProperties>();
	
	//Constructors: 
	public CharacterSkills() {
		for (Skill skill : characterSkills) {
			characterSkillPropertiesMap.put(skill, new CharacterSkillProperties());
		}
	}
	
	
	//Methods: 
	public Skill getAcrobatics() {return this.characterSkills[0];}
	public Skill getAppraise() {return this.characterSkills[1];}
	public Skill getBluff() {return this.characterSkills[2];}
	public Skill getClimb() {return this.characterSkills[3];}
	public Skill getCraft1() {return this.characterSkills[4];}
	public Skill getCraft2() {return this.characterSkills[5];}
	public Skill getCraft3() {return this.characterSkills[6];}
	public Skill getDiplomacy() {return this.characterSkills[7];}
	public Skill getDisableDevice() {return this.characterSkills[8];}
	public Skill getDisguise() {return this.characterSkills[9];}
	public Skill getEscapeArtists() {return this.characterSkills[10];}
	public Skill getFly() {return this.characterSkills[11];}
	public Skill getHandleAnimal() {return this.characterSkills[12];}
	public Skill getHeal() {return this.characterSkills[13];}
	public Skill getIntimidate() {return this.characterSkills[14];}
	public Skill getKnowledgeArcana() {return this.characterSkills[15];}
	public Skill getKnowledgeDungeoneering() {return this.characterSkills[16];}
	public Skill getKnowledgeEngineering() {return this.characterSkills[17];}
	public Skill getKnowledgeGeography() {return this.characterSkills[18];}
	public Skill getKnowledgeHistory() {return this.characterSkills[19];}
	public Skill getKnowledgeLocal() {return this.characterSkills[20];}
	public Skill getKnowledgeNature() {return this.characterSkills[21];}
	public Skill getKnowledgeNobility() {return this.characterSkills[22];}
	public Skill getKnowledgePlanes() {return this.characterSkills[23];}
	public Skill getknowledgeReligion() {return this.characterSkills[24];}
	public Skill getLinguistics() {return this.characterSkills[25];}
	public Skill getPerception() {return this.characterSkills[26];}
	public Skill getPerform1() {return this.characterSkills[27];}
	public Skill getPerform2() {return this.characterSkills[28];}
	public Skill getProfession1() {return this.characterSkills[29];}
	public Skill getProfession2() {return this.characterSkills[30];}
	public Skill getRide() {return this.characterSkills[31];}
	public Skill getSenseMotive() {return this.characterSkills[32];}
	public Skill getSlightOfHand() {return this.characterSkills[33];}
	public Skill getSpellcraft() {return this.characterSkills[34];}
	public Skill getStealth() {return this.characterSkills[35];}
	public Skill getSurvival() {return this.characterSkills[36];}
	public Skill getSwim() {return this.characterSkills[37];}
	public Skill getUseMagicalDevice() {return this.characterSkills[38];}
	
	public Skill[] getCharacterSkills() {return this.characterSkills;}
	public SortedList<Skill> getCharacterSkillsList() {return this.characterSkillsList;}
	
	public SimpleBooleanProperty isClassSkill(Skill skill) {
		return this.characterSkillPropertiesMap.get(skill).getClassSkill();
	}
	public void setClassSkill(Skill skill, Boolean bool) {
		this.characterSkillPropertiesMap.get(skill).setClassSkill(bool);
	}
	
	public SimpleIntegerProperty getSkillRanks(Skill skill) {
		return this.characterSkillPropertiesMap.get(skill).getSkillRanks();
	}
	public void incrementSkillRanks(Skill skill, int value) {
		this.characterSkillPropertiesMap.get(skill).incrementSkillRanks(value);
	}
	public void setSkillRanks(Skill skill, int value) {
		this.characterSkillPropertiesMap.get(skill).setSkillRanks(value);
	}
	
	public SimpleIntegerProperty getMiscSkillMod(Skill skill) {
		return this.characterSkillPropertiesMap.get(skill).getMiscSkillMod();
	}
	public void incrementMiscSkillMod(Skill skill, int value) {
		this.characterSkillPropertiesMap.get(skill).incrementMiscSkillMod(value);
	}
	
	public Set<Skill> getClassSkills() {
		Set<Skill> classSkills = new HashSet<Skill>();
		Set<Skill> classSkillKeys = this.characterSkillPropertiesMap.keySet();
		for (Skill key : classSkillKeys) {
			if (isClassSkill(key).getValue()) {
				classSkills.add(key);
			}
		}
		return classSkills;
	}
	
	public void setClassSkills(Set<Skill> classSkills) {
		for (Skill characterSkill : this.characterSkills) {
			if (classSkills.contains(characterSkill)) {
				setClassSkill(characterSkill, true);
			}
		}
	}
	
	public IntegerProperty getClassSkillBonus(Skill skill) {
		if (getSkillRanks(skill).intValue() == 0) {
			return new SimpleIntegerProperty(0);
		}
		else {
			int outputBonus = getSkillRanks(skill).intValue();
			if (isClassSkill(skill).getValue()) {
				outputBonus += 3;
			}
			return new SimpleIntegerProperty(outputBonus);
		}
	}
	
	@Override
	public String toString() {
		String outputString = "";
		for (Skill skill : characterSkills) {
			outputString = outputString + skill.toString() + ": " + getSkillRanks(skill) + "\n";
		}
		return outputString;
	}
	
	@Override
	public Object clone() {
		CharacterSkills outputCharacterSkills = new CharacterSkills(); 
		for (Skill skill : outputCharacterSkills.getCharacterSkills()) {
			outputCharacterSkills.incrementSkillRanks(skill, getSkillRanks(skill).intValue());
			outputCharacterSkills.setClassSkill(skill, isClassSkill(skill).getValue());
		}
		return outputCharacterSkills;
	}
}
