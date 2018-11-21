package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cPathfinderCharacterSkillObjects.Skill;

public class Ranger extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> rangerClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("HEAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_DUNGEONEERING"), 
			new Skill("KNOWLEDGE_GEOGRAPHY"), new Skill("KNOWLEDGE_NATURE"), new Skill("PERCEPTION"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("RIDE"),
			new Skill("SPELLCRAFT"), new Skill("STEALTH"), new Skill("SURVIVAL"), new Skill("SWIM")));
	
	protected static final Map<String, ClassFeature> rangerClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setRangerClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/RangerClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setRangerClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature rangerClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				rangerClassFeatures.put(parts[0], rangerClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Ranger");
		}
	}

	
	//Instance Variables:
	
	//Constructors:
	public Ranger(int level) {
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 10;
		this.classSkills = rangerClassSkills;
		this.skillRanksPerLevel = 6;
		this.weaponAndArmorProficiencies = "A ranger is proficient with all simple and martial weapons and with light"
				+ "armor, medium armor, and shields (except tower shields).";
		
		Set<String> rangerClassFeaturesKeys = rangerClassFeatures.keySet();
		for (String key : rangerClassFeaturesKeys) {
			if (rangerClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(rangerClassFeatures.get(key));
				this.specialAbilityDescriptions.add(rangerClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + rangerClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:

	

}