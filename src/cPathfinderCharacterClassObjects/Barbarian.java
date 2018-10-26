package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import cPathfinderCharacterObjects.CharacterModifierObject;
import cPathfinderCharacterObjects.PathfinderCharacter;

import java.util.HashMap;

import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;

public class Barbarian extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> barbarianClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("ACROBATICS"), new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_NATURE"), 
			new Skill("PERCEPTION"), new Skill("RIDE"), new Skill("SURVIVAL"), new Skill("SWIM")));
	
	protected static final Map<String, ClassFeature> barbarianClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setBarbarianClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/BarbarianClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setBarbarianClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 5);
				//System.out.println(parts[0] + ": " + parts[2]);
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
	public Barbarian(int level) {
		this.level = level;
		this.alignmentRestriction = "Any Nonlawful";
		this.hitDie = 12;
		this.classSkills = barbarianClassSkills;
		this.skillRanksPerLevel = 4;
		this.weaponAndArmorProficiencies = "A barbarian is proficient with all simple and martial weapons, light armor, "
				+ "medium armor, and shields (except tower shields).";
		
		Set<String> barbarianClassFeaturesKeys = barbarianClassFeatures.keySet();
		for (String key : barbarianClassFeaturesKeys) {
			if (!(barbarianClassFeatures.get(key) instanceof ClassFeature_Selection) && barbarianClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(barbarianClassFeatures.get(key));
				this.specialAbilityDescriptions.add(barbarianClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + barbarianClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:

	
}
