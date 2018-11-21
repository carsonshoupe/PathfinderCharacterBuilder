package cPathfinderCharacterSkillObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Skill implements Comparable<Skill> {
	//Static Variables:
	protected static final Map<String, String[]> skillDescriptionsMap;
	public static final String[] skillNames;
	static {
		Map<String, String[]> outputMap = new HashMap<String, String[]>();
		String filePath = "C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterSkillObjects/SkillDescriptions.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 5);
				String key = parts[0];
				String[] value = new String[4];
				value[0] = parts[1];
				value[1] = parts[2];
				value[2] = parts[3];
				value[3] = parts[4];
				
				outputMap.put(key, value);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load skillDescriptionsMap in Skill");
		} 
		skillDescriptionsMap = outputMap;
		
		/***************************************************************/
		
		filePath = "C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterSkillObjects/SkillNames.txt";
		skillNames = new String[35];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int skillNameCounter = 0;
			while ((line = reader.readLine()) != null ) {
				skillNames[skillNameCounter] = line;
				skillNameCounter++;
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load skillNames");
		}
	}
	
	//Static Methods:
	
	//Instance Variables: 
	private String name;
	private String description;
	private int pageInCoreRuleBook;
	private boolean trainedOnly;
	private String abilityModifier;
	
	private SimpleStringProperty skillName = new SimpleStringProperty();
	private SimpleStringProperty skillDescription = new SimpleStringProperty();
	private SimpleBooleanProperty skillTrainedOnly = new SimpleBooleanProperty();
	private SimpleStringProperty skillAbilityModifier = new SimpleStringProperty();
	
	public StringProperty skillNameProperty() { 
        if (this.name == null) this.skillName = new SimpleStringProperty(this, "skillName");
        return this.skillName; 
    }
	public StringProperty skillDescriptionProperty() {
		if (this.skillDescription == null) this.skillDescription = new SimpleStringProperty(this, "skillDescription");
		return this.skillDescription;
	}
	public BooleanProperty skillTrainedOnlyProperty() {
		if (this.skillTrainedOnly == null) this.skillTrainedOnly = new SimpleBooleanProperty(this, "skillTrainedOnly");
		return this.skillTrainedOnly;
	}
	public StringProperty skillAbilityModifierProperty() {
		if (this.skillAbilityModifier == null) this.skillAbilityModifier = new SimpleStringProperty(this, "skillAbilityModifier");
		return this.skillAbilityModifier;
	}
		
	//Constructors:
	public Skill() {
		this.name = "Null Skill";
	}
	
	public Skill(String name) {
		this.name = name;
		//System.out.println(this.skillNameProperty.get());
		//System.out.println("Creating skill: " + this.name);
		this.description = skillDescriptionsMap.get(this.name)[0];
		this.trainedOnly = Boolean.parseBoolean(skillDescriptionsMap.get(this.name)[1]);
		this.abilityModifier = skillDescriptionsMap.get(this.name)[2];
		this.pageInCoreRuleBook = Integer.parseInt(skillDescriptionsMap.get(this.name)[3]);
		
		this.skillName.set(this.name);
		this.skillDescription.set(skillDescriptionsMap.get(this.name)[0]);
		this.skillTrainedOnly.set(Boolean.parseBoolean(skillDescriptionsMap.get(this.name)[1]));
		this.skillAbilityModifier.set(skillDescriptionsMap.get(this.name)[2]);
	}
	
	//Methods: 
	public String getName() {return this.name;}
	public String getSkillDescription() {return this.description;}
	public int getPageInCoreRuleBOok() {return this.pageInCoreRuleBook;}
	public boolean isTrainedOnly() {return this.trainedOnly;}
	public String getAbilityModifier() {return this.abilityModifier;}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	
	@Override
	public boolean equals(Object skill) { //Add 'instanceOf' if statement
		Skill typeCastedSkill = (Skill) skill;
		if (this.getName().equals(typeCastedSkill.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		String[] skillNameWords = this.name.split("_");
		for (String word : skillNameWords) {
			String wordToAppend = word.substring(0, 1) + word.substring(1).toLowerCase();
			outputString.append(wordToAppend + " ");
		}
		return outputString.toString().trim();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int compareTo(Skill skill) {
		return this.getName().compareTo(skill.getName());
	}
}
