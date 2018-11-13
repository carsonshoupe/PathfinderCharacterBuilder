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

public class Paladin extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> paladinClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("CRAFT1"), new Skill("CRAFT2"), new Skill("CRAFT3"), 
			new Skill("DIPLOMACY"), new Skill("HANDLE_ANIMAL"), new Skill("HEAL"), new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_RELIGION"), 
			new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("RIDE"), new Skill("SENSE_MOTIVE"), new Skill("SPELLCRAFT")));
	
	protected static final Map<String, ClassFeature> paladinClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setPaladinClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/PaladinClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setPaladinClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature paladinClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				paladinClassFeatures.put(parts[0], paladinClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Paladin");
		}
	}

	
	//Instance Variables:
	
	//Constructors:
	public Paladin(int level) {
		this.level = level;
		this.alignmentRestriction = "Lawful Good";
		this.hitDie = 10;
		this.classSkills = paladinClassSkills;
		this.skillRanksPerLevel = 2;
		this.weaponAndArmorProficiencies = "Paladins are proficient with all simple and martial weapons, with all types of"
				+ "armor (heavy, medium, and light), and with shields (excepttower shields).";
		
		Set<String> fighterClassFeaturesKeys = paladinClassFeatures.keySet();
		for (String key : fighterClassFeaturesKeys) {
			if (paladinClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(paladinClassFeatures.get(key));
				this.specialAbilityDescriptions.add(paladinClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + paladinClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:

	

}
