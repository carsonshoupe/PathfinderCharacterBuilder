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
import cPathfinderCharacterSpellObjects.Spell;

public class Sorcerer extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> sorcererClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("APPRAISE"), new Skill("BLUFF"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("FLY"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_ARCANA"), 
			new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("SPELLCRAFT"), new Skill("USE_MAGICAL_DEVICE")));
	
	protected static final Map<String, ClassFeature> sorcererClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setSorcererClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/SorcererClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setSorcererClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature sorcererClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				sorcererClassFeatures.put(parts[0], sorcererClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Sorcerer");
		}
	}

	
	//Instance Variables:
	private Bloodline bloodline; 
	
	//Constructors:
	public Sorcerer(int level) {
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 6;
		this.classSkills = sorcererClassSkills;
		this.skillRanksPerLevel = 2;
		this.weaponAndArmorProficiencies = "Sorcerers are proficient with all simple weapons. They are not proficient with any type "
				+ "of armor or shield. Armor interferes with a sorcerer’s gestures, which can cause her spells with somatic components to fail.";
		
		Set<String> sorcererClassFeaturesKeys = sorcererClassFeatures.keySet();
		for (String key : sorcererClassFeaturesKeys) {
			if (sorcererClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(sorcererClassFeatures.get(key));
				this.specialAbilityDescriptions.add(sorcererClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + sorcererClassFeatures.get(key).getFullDescription());
			}
		}
		
		this.description = "Scions of innately magical bloodlines, the chosen of deities, the spawn of monsters, pawns of fate and destiny, "
				+ "or simply flukes of fickle magic, sorcerers look within themselves for arcane prowess and draw forth might few mortals can "
				+ "imagine. Emboldened by lives ever threatening to be consumed by their innate powers, these magic-touched souls endlessly "
				+ "indulge in and refine their mysterious abilities, gradually learning how to harness their birthright and coax forth ever "
				+ "greater arcane feats. Just as varied as these innately powerful spellcasters’ abilities and inspirations are the ways in "
				+ "which they choose to utilize their gifts. While some seek to control their abilities through meditation and discipline, "
				+ "becoming masters of their fantastic birthright, others give in to their magic, letting it rule their lives with often "
				+ "explosive results. Regardless, sorcerers live and breathe that which other spellcasters devote their lives to mastering, "
				+ "and for them magic is more than a boon or a field of study; it is life itself.";
		
		this.role = "Sorcerers excel at casting a selection of favored spells frequently, making them powerful battle mages. As they become "
				+ "familiar with a specific and ever-widening set of spells, sorcerers often discover new and versatile ways of making use of "
				+ "magics other spellcasters might overlook. Their bloodlines also grant them additional abilities, assuring that no two sorcerers "
				+ "are ever quite alike.";
	}
	
	//Methods:
	public Bloodline getBloodline() {return this.bloodline;}
	public void setBloodline(Bloodline bloodline, int level) {
		this.bloodline = bloodline;
		this.classSkills.add(bloodline.getBloodlineClassSkill());
		this.classFeatures.addAll(bloodline.getClassFeatures(level));
		this.spells.addAll(bloodline.getBloodlineSpells(level));
	}

	
}
