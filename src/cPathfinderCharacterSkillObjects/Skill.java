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
	protected static final Map<String, String[]> skillDescriptionsMap = new HashMap<String, String[]>();
	public static final String[] skillNames = new String[35];
	
	//Static Call
	static {
		setSkillDescriptionsMap();
		setSkillNames();
	}
	
	//Static Methods:
	private static void setSkillDescriptionsMap() {
		String filePath = "src/cPathfinderCharacterSkillObjects/SkillDescriptions.txt"; 
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
				
				Skill.skillDescriptionsMap.put(key, value);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load skillDescriptionsMap in Skill");
		} 
	}
	
	private static void setSkillNames() {
		String filePath = "src/cPathfinderCharacterSkillObjects/SkillNames.txt";
		String line;
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
	
	//Instance Variables: 
	private SimpleStringProperty name;
	private SimpleStringProperty description;
	private SimpleBooleanProperty trainedOnly;
	private SimpleStringProperty abilityModifier;
	private SimpleIntegerProperty pageInCoreRuleBook;
	
	public StringProperty nameProperty() { 
        if (this.name == null) this.name = new SimpleStringProperty(this, "name");
        return this.name; 
    }
	public StringProperty descriptionProperty() {
		if (this.description == null) this.description = new SimpleStringProperty(this, "description");
		return this.description;
	}
	public BooleanProperty trainedOnlyProperty() {
		if (this.trainedOnly == null) this.trainedOnly = new SimpleBooleanProperty(this, "trainedOnly");
		return this.trainedOnly;
	}
	public StringProperty abilityModifierProperty() {
		if (this.abilityModifier == null) this.abilityModifier = new SimpleStringProperty(this, "abilityModifier");
		return this.abilityModifier;
	}
	public IntegerProperty pageInCoreRuleBookProperty() {
		if (this.pageInCoreRuleBook == null) this.pageInCoreRuleBook = new SimpleIntegerProperty(this, "pageInCoreRuleBook");
		return this.pageInCoreRuleBook;
	}
		
	//Constructors:
	public Skill() {
		this.name = new SimpleStringProperty("Null Skill");
	}
	
	public Skill(String name) { //TODO: Eventually, I should remove this and replace all calls like this with references to the CharacterSkills object
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(skillDescriptionsMap.get(this.getName())[0]);
		this.trainedOnly = new SimpleBooleanProperty(Boolean.parseBoolean(skillDescriptionsMap.get(this.getName())[1]));
		this.abilityModifier = new SimpleStringProperty(skillDescriptionsMap.get(this.getName())[2]);
		this.pageInCoreRuleBook = new SimpleIntegerProperty(Integer.parseInt(skillDescriptionsMap.get(this.getName())[3]));
	}
	
	public Skill(String name, String description, Boolean trainedOnly, String abilityModifier, Integer pageInCoreRuleBook) {
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.trainedOnly = new SimpleBooleanProperty(trainedOnly);
		this.abilityModifier = new SimpleStringProperty(abilityModifier);
		this.pageInCoreRuleBook = new SimpleIntegerProperty(pageInCoreRuleBook);
	}
	
	//Methods: 
	public String getName() {return this.name.get();}
	public String getDescription() {return this.description.get();}
	public int getPageInCoreRuleBook() {return this.pageInCoreRuleBook.get();}
	public boolean isTrainedOnly() {return this.trainedOnly.get();}
	public String getAbilityModifier() {return this.abilityModifier.get();}
	
	private void setTrainedOnly(Boolean bool) {this.trainedOnly = new SimpleBooleanProperty(bool);} //No idea why I need this but don't need it for simpleStringProperties or IntegerProperties
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	
	@Override
	public boolean equals(Object skill) {
		if (!(skill instanceof Skill)) {return false;}
		else {
			Skill typeCastedSkill = (Skill) skill;
			if (this.getName().equals(typeCastedSkill.getName())) {return true;}
			else {return false;}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		String[] skillNameWords = this.getName().split("_");
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
