package cPathfinderCharacterObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;

public class Barbarian extends PathfinderCharacter {
	//Static Variables: 
	protected static final Skill[] barbarianClassSkills = {new Skill("ACROBATICS"), new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_NATURE"), 
			new Skill("PERCEPTION"), new Skill("RIDE"), new Skill("SURVIVAL"), new Skill("SWIM")};
	protected static final Map<String, ClassFeature> barbarianClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setBarbarianClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterObjects/BarbarianClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setBarbarianClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 5);				
				if (parts[2].equals("Select")) {
					ClassFeature_Select barbarianClassFeature = new ClassFeature_Select(parts[0], parts[1], Integer.parseInt(parts[3]), parts[4], "");
					barbarianClassFeatures.put(parts[0], barbarianClassFeature);
				}
				else if (parts[2].equals("Selection")) {
					ClassFeature_Selection barbarianClassFeature = new ClassFeature_Selection(parts[0], parts[1], Integer.parseInt(parts[3]), parts[4], "");
					barbarianClassFeatures.put(parts[0], barbarianClassFeature);
				}
				else {
					ClassFeature barbarianClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[3]), parts[4], "");
					barbarianClassFeatures.put(parts[0], barbarianClassFeature);
				}
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Barbarian");
		}

		
	}
	
	//Instance Variables:
	
	//Constructors:
	public Barbarian() {
		this.role = "Barbarians excel in combat, possessing the martial prowess and "
				+ "fortitude to take on foes seemingly far superior to themselves. "
				+ "With rage granting them boldness and daring beyond that of most "
				+ "other warriors, barbarians charge furiously into battle and ruin "
				+ "all who would stand in their way.";
		this.allignmentRestriction = "Any Nonlawful";
		this.hitDie = 12;
		this.classSkills = barbarianClassSkills;
		this.skillRanksPerLevel = 4 + getIntelligenceModifier();
		this.weaponAndArmorProficiencies = "A barbarian is proficient with all simple and martial weapons, light armor, "
				+ "medium armor, and shields (except tower shields).";
		
		this.characterSkills = new CharacterSkills();
	}
	
	//Methods:

	
}
