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

public class Rogue extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> rogueClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("ACROBATICS"), new Skill("APPRAISE"), new Skill("BLUFF"), 
			new Skill("CLIMB"), new Skill("CRAFT1"), new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("DIPLOMACY"), new Skill("DISABLE_DEVICE"), 
			new Skill("DISGUISE"), new Skill("ESCAPE_ARTIST"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_DUNGEONEERING"), new Skill("KNOWLEDGE_LOCAL"), 
			new Skill("LINGUISTICS"), new Skill("PERCEPTION"), new Skill("PERFORM1"), new Skill("PERFORM2"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), 
			new Skill("SENSE_MOTIVE"), new Skill("SLIGHT_OF_HAND"), new Skill("STEALTH"), new Skill("SWIM"), new Skill("USE_MAGICAL_DEVICE")));
	
	protected static final Map<String, ClassFeature> rogueClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setRogueClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/RogueClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setRogueClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 5);
				//System.out.println(parts[0] + ": " + parts[2]);
				if (parts[2].equals("Select")) {
					ClassFeature_Select rogueClassFeature = new ClassFeature_Select(parts[0], parts[1], Integer.parseInt(parts[2]), parts[4], "");
					rogueClassFeatures.put(parts[0], rogueClassFeature);
				}
				else if (parts[2].equals("Selection")) {
					ClassFeature_Selection rogueClassFeature = new ClassFeature_Selection(parts[0], parts[1], Integer.parseInt(parts[2]), parts[4], "");
					rogueClassFeatures.put(parts[0], rogueClassFeature);
				}
				else {
					ClassFeature rogueClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[4], "");
					rogueClassFeatures.put(parts[0], rogueClassFeature);
				}
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Rogue");
		}
	}

	
	//Instance Variables:
	
	//Constructors:
	public Rogue(int level) {
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 8;
		this.classSkills = rogueClassSkills;
		this.skillRanksPerLevel = 8;
		this.weaponAndArmorProficiencies = "Rogues are proficient with all simple weapons, plus the hand crossbow, rapier,"
				+ "sap, shortbow, and short sword. They are proficient with	light armor, but not with shields.";
		
		Set<String> rogueClassFeaturesKeys = rogueClassFeatures.keySet();
		for (String key : rogueClassFeaturesKeys) {
			if (!(rogueClassFeatures.get(key) instanceof ClassFeature_Selection) && rogueClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(rogueClassFeatures.get(key));
				this.specialAbilityDescriptions.add(rogueClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + rogueClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:

	
}
