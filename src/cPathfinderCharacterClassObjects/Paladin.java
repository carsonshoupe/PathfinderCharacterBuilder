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
		
		Set<String> paladinClassFeaturesKeys = paladinClassFeatures.keySet();
		for (String key : paladinClassFeaturesKeys) {
			if (paladinClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(paladinClassFeatures.get(key));
				this.specialAbilityDescriptions.add(paladinClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + paladinClassFeatures.get(key).getFullDescription());
			}
		}
		
		this.description = "Through a select, worthy few shines the power of the divine. Called paladins, these noble souls "
				+ "dedicate their swords and lives to the battle against evil. Knights, crusaders, and lawbringers, paladins s"
				+ "eek not just to spread divine justice but to embody the teachings of the virtuous deities they serve. In "
				+ "pursuit of their lofty goals, they adhere to ironclad laws of morality and discipline. As reward for their "
				+ "righteousness, these holy champions are blessed with boons to aid them in their quests: powers to banish evil, "
				+ "heal the innocent, and inspire the faithful. Although their convictions might lead them into conf lict with the "
				+ "very souls they would save, paladins weather endless challenges of faith and dark temptations, risking their lives "
				+ "to do right and fighting to bring about a brighter future.";
		
		this.role = "Paladins serve as beacons for their allies within the chaos of battle. While deadly opponents of evil, they can "
				+ "also empower goodly souls to aid in their crusades. Their magic and martial skills also make them well suited to "
				+ "defending others and blessing the fallen with the strength to continue fighting.";
		
	}
	
	//Methods:

	

}
