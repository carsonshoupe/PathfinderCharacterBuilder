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
		setRogueClassFeatures("src/cPathfinderCharacterClassObjects/RogueClassFeatures.txt");
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
		
		this.description = "Life is an endless adventure for those who live by their wits. Ever just one step ahead of danger, "
				+ "rogues bank on their cunning, skill, and charm to bend fate to their favor. Never knowing what to expect, "
				+ "they prepare for everything, becoming masters of a wide variety of skills, training themselves to be adept "
				+ "manipulators, agile acrobats, shadowy stalkers, or masters of any of dozens of other professions or talents. "
				+ "Thieves and gamblers, fast talkers and diplomats, bandits and bounty hunters, and explorers and investigators "
				+ "all might be considered rogues, as well as countless other professions that rely upon wits, prowess, or luck. "
				+ "Although many rogues favor cities and the innumerable opportunities of civilization, some embrace lives on the "
				+ "road, journeying far, meeting exotic people, and facing fantastic danger in pursuit of equally fantastic riches. "
				+ "In the end, any who desire to shape their fates and live life on their own terms might come to be called rogues.";
		
		this.role = "Rogues excel at moving about unseen and catching foes unaware, and tend to avoid head-to-head combat. Their "
				+ "varied skills and abilities allow them to be highly versatile, with great variations in expertise existing between "
				+ "different rogues. Most, however, excel in overcoming hindrances of all types, from unlocking doors and disarming "
				+ "traps to outwitting magical hazards and conning dull-witted opponents.";
	}
	
	//Methods:

	
}
