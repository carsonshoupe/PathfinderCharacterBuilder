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
		
		this.description = "For some, there is only rage. In the ways of their people, in the fury of their passion, in the howl of "
				+ "battle, conf lict is all these brutal souls know. Savages, hired muscle,	masters of vicious martial techniques, "
				+ "they are not soldiers or professional warriors—they are the battle possessed, creatures of slaughter and spirits "
				+ "of war. Known as barbarians, these warmongers know little of training, preparation, or the rules of warfare; for "
				+ "them, only the moment exists, with the foes that stand before them and the knowledge that the next moment might "
				+ "hold their death. They possess a sixth sense in regard to danger and the endurance to weather all that might	entail."
				+ " These brutal warriors might rise from all walks of life, both civilized and savage, though whole societies embracing"
				+ " such philosophies roam the wild places of the world. Within barbarians storms the primal spirit of battle, and woe to"
				+ " those who face their rage.";
		
		this.role = "Barbarians excel in combat, possessing the martial prowess and fortitude to take on foes seemingly	far superior to "
				+ "themselves. With rage granting them	boldness and daring beyond that of most other warriors,	barbarians charge furiously "
				+ " into battle and ruin all who would stand in their way.";
	}
	
	//Methods:

	
}
