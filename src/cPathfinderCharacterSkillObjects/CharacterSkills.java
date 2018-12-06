package cPathfinderCharacterSkillObjects;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;


public class CharacterSkills {	
	//Instance Variables: 	
	private SortedList<Skill> characterSkillsList;
	private Map<String, Skill> characterSkillsMap = new HashMap<String, Skill>();
	
	private Map<Skill, CharacterSkillProperties> characterSkillPropertiesMap = new HashMap<Skill, CharacterSkillProperties>();
	
	//Constructors: 
	public CharacterSkills() {
		try {
			String fileName = "src/cPathfinderCharacterSkillObjects/Skills.json";
			byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
			ObjectMapper mapper = new ObjectMapper();
			
			//Set up characterSkillsList
			this.characterSkillsList = new SortedList<Skill>(FXCollections.observableArrayList(Arrays.asList(mapper.readValue(jsonData, Skill[].class))));
			
			//Set up CharacterSkillsMap
			for (Skill skill : characterSkillsList) {
				characterSkillsMap.put(skill.getName(), skill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Skill skill : this.characterSkillsList) {
			characterSkillPropertiesMap.put(skill, new CharacterSkillProperties());
		}
	}
	
	//Methods: 
	public Skill getSkill(String skillName) {return characterSkillsMap.get(skillName);}
	
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
		for (Skill characterSkill : this.characterSkillsList) {
			if (classSkills.contains(characterSkill)) {setClassSkill(characterSkill, true);}
			else {setClassSkill(characterSkill, false);}
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
		for (Skill skill : this.characterSkillsList) {
			outputString = outputString + skill.toString() + ": " + getSkillRanks(skill) + "\n";
		}
		return outputString;
	}
	
	@Override
	public Object clone() {
		CharacterSkills outputCharacterSkills = new CharacterSkills(); 
		for (Skill skill : outputCharacterSkills.getCharacterSkillsList()) {
			outputCharacterSkills.incrementSkillRanks(skill, getSkillRanks(skill).intValue());
			outputCharacterSkills.setClassSkill(skill, isClassSkill(skill).getValue());
		}
		return outputCharacterSkills;
	}
}
