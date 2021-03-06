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

//TODO: Add level dictated stats

public class Monk extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> monkClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("ACROBATICS"), new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("ESCAPE_ARTIST"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_HISTORY"), 
			new Skill("KNOWLEDGE_RELIGION"), new Skill("PERCEPTION"), new Skill("PERFORM1"), new Skill("PERFORM2"), new Skill("PROFESSION1"), 
			new Skill("PROFESSION2"), new Skill("RIDE"), new Skill("SENSE_MOTIVE"), new Skill("STEALTH"), new Skill("SWIM")));
	
	protected static final Map<String, ClassFeature> monkClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setMonkClassFeatures("src/cPathfinderCharacterClassObjects/MonkClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setMonkClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature fighterClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				monkClassFeatures.put(parts[0], fighterClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Monk");
		}
	}

	
	//Instance Variables:
	private int kaiPool = 0;
	
	//Constructors:
	public Monk(int level) {
		this.name = "Monk";
		this.level = level;
		this.alignmentRestriction = "Any Lawful";
		this.hitDie = 8;
		this.classSkills = monkClassSkills;
		this.skillRanksPerLevel = 4;
		this.weaponAndArmorProficiencies = "Monks are proficient with the club, crossbow (light or heavy), dagger, "
				+ "handaxe,	javelin, kama, nunchaku, quarterstaff, sai, shortspear,	short sword, shuriken, "
				+ "siangham, sling, and spear. Monks are not proficient with any armor or shields. When wearing "
				+ "armor, using a shield, or carrying a medium or heavy load, a monk loses his AC bonus, as well "
				+ "as his fast movement and f lurry of blows abilities.";
		
		Set<String> monkClassFeaturesKeys = monkClassFeatures.keySet();
		for (String key : monkClassFeaturesKeys) {
			if (monkClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(monkClassFeatures.get(key));
				this.specialAbilityDescriptions.add(monkClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + monkClassFeatures.get(key).getFullDescription());
			}
		}
		
		this.description = "For the truly exemplary, martial skill transcends the battlefield— it is a lifestyle, "
				+ "a doctrine, a state of mind. These warrior-artists search out methods of battle beyond swords "
				+ "and shields, finding weapons within themselves just as capable of crippling or killing as any "
				+ "blade. These monks (so called since they adhere to ancient philosophies and strict martial "
				+ "disciplines) elevate their bodies to become weapons of war, from battle-minded ascetics to "
				+ "self-taught brawlers. Monks tread the path of discipline, and those with the will to endure "
				+ "that path discover within themselves not what they are, but what they are meant to be.";
		
		this.role = "Monks excel at overcoming even the most daunting perils, striking where it’s least expected, "
				+ "and taking advantage of enemy vulnerabilities. Fleet of foot and skilled in combat, monks can "
				+ "navigate any battlefield with ease, aiding allies wherever they are needed most.";
	}
	
	//Methods:
	public int getKaiPool() {return this.kaiPool;}
	public void setKaiPool(int value) {this.kaiPool = value;}

}
