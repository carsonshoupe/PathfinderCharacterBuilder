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

public class Druid extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> druidClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("FLY"), new Skill("HANDLE_ANIMAL"), new Skill("HEAL"), new Skill("KNOWLEDGE_GEOGRAPHY"),
			new Skill("KNOWLEDGE_NATURE"), new Skill("PERCEPTION"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("RIDE"),
			new Skill("SPELLCRAFT"), new Skill("SURVIVAL"), new Skill("SWIM")));

	
	protected static final Map<String, ClassFeature> druidClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setDruidClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/DruidClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setDruidClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				ClassFeature barbarianClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				druidClassFeatures.put(parts[0], barbarianClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Druid");
		}
	}
	
	//Instance Variables:
	
	//Constructors:
	public Druid(int level) {
		this.level = level;
		this.alignmentRestriction = "Any Neutral";
		this.hitDie = 8;
		this.classSkills = druidClassSkills;
		this.skillRanksPerLevel = 4;
		this.weaponAndArmorProficiencies = "Druids are proficient with the following weapons: club, dagger, dart, "
				+ "quarterstaff, scimitar, scythe, sickle, shortspear, sling, and spear. They are also proficient "
				+ "with all natural attacks (claw, bite, and so	forth) of any form they assume with wild shape "
				+ "(see below).	Druids are proficient with light and medium armor but are prohibited from wearing "
				+ "metal armor; thus, they may wear only padded, leather, or hide armor. A druid may also wear "
				+ "wooden armor that has been altered by the ironwood spell so that it functions as though it were "
				+ "steel. Druids are proficient with shields (except tower shields) but must use only those crafted "
				+ "from wood. A druid who wears prohibited armor or uses a prohibited shield is unable to cast "
				+ "druid spells or use any of her supernatural or spell-like class abilities while doing so	and for "
				+ "24 hours thereafter.";
		
		Set<String> barbarianClassFeaturesKeys = druidClassFeatures.keySet();
		for (String key : barbarianClassFeaturesKeys) {
			if (druidClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(druidClassFeatures.get(key));
				this.specialAbilityDescriptions.add(druidClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + druidClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:

		

}
