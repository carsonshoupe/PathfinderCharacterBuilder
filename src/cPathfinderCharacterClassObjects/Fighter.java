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

//TODO: Level dictated stats

//TODO: Maybe add additional property for the weapon and armor specializations

public class Fighter extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> fighterClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("CLIMB"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_DUNGEONEERING"), 
			new Skill("KNOWLEDGE_ENGINEERING"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("RIDE"), new Skill("SURVIVAL"), new Skill("SWIM")));
	
	protected static final Map<String, ClassFeature> fighterClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setFighterClassFeatures("src/cPathfinderCharacterClassObjects/FighterClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setFighterClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature fighterClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				fighterClassFeatures.put(parts[0], fighterClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Fighter");
		}
	}

	
	//Instance Variables:
	
	//Constructors:
	public Fighter(int level) {
		this.name = "Fighter";
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 10;
		this.classSkills = fighterClassSkills;
		this.skillRanksPerLevel = 2;
		this.weaponAndArmorProficiencies = "A fighter is proficient with all simple and martial weapons and with all "
				+ "armor (heavy, light, and medium) and shields (including tower shields).";
		
		Set<String> fighterClassFeaturesKeys = fighterClassFeatures.keySet();
		for (String key : fighterClassFeaturesKeys) {
			if (fighterClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(fighterClassFeatures.get(key));
				this.specialAbilityDescriptions.add(fighterClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + fighterClassFeatures.get(key).getFullDescription());
			}
		}
		
		this.description = "Some take up arms for glory, wealth, or revenge. Others do battle to prove themselves, to "
				+ "protect others, or because they know nothing else. Still others learn the ways of weaponcraft to hone "
				+ "their bodies in battle and prove their mettle in the forge of war. Lords of the battlefield, fighters "
				+ "are a disparate lot, training with many weapons or just one, perfecting the uses of armor, learning the "
				+ "fighting techniques of exotic masters, and studying the art of combat, all to shape themselves into living "
				+ "weapons. Far more than mere thugs, these skilled warriors reveal the true deadliness of their weapons, "
				+ "turning hunks of metal into arms capable of taming kingdoms, slaughtering monsters, and rousing the hearts "
				+ "of armies. Soldiers, knights, hunters, and artists of war, fighters are unparalleled champions, and woe to "
				+ "those who dare stand against them.";
		
		this.role = "Fighters excel at combat—defeating their enemies, controlling the f low of battle, and surviving such sorties "
				+ "themselves. While their specific weapons and methods grant them a wide variety of tactics, few can match fighters "
				+ "for sheer battle prowess.";
	}
	
	//Methods:

	

}
