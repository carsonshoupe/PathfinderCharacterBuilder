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

import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;

public class Bard extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> bardClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("ACROBATICS"), new Skill("APPRAISE"), 
			new Skill("BLUFF"), new Skill("CLIMB"), new Skill("CRAFT1"), new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("DIPLOMACY"), 
			new Skill("DISGUISE"), new Skill("ESCAPE_ARTIST"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_ARCANA"), new Skill("KNOWLEDGE_DUNGEONEERING"), 
			new Skill("KNOWLEDGE_ENGINEERING"), new Skill("KNOWLEDGE_GEOGRAPHY"), new Skill("KNOWLEDGE_HISTORY"), new Skill("KNOWLEDGE_LOCAL"), 
			new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_PLANES"), new Skill("KNOWLEDGE_RELIGION"), new Skill("LINGUISTICS"), new Skill("PERCEPTION"), 
			new Skill("PERFORM1"), new Skill("PERFORM2"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("SENSE_MOTIVE"),
			new Skill("SLIGHT_OF_HAND"), new Skill("SPELLCRAFT"), new Skill("STEALTH"), new Skill("USE_MAGICAL_DEVICE")));
	
	protected static final Map<String, ClassFeature> bardClassFeatures = new HashMap<String, ClassFeature>();
	protected static Map<Integer, int[]> spellsKnownByLevel = new HashMap<Integer, int[]>();
	public static ArrayList<Spell> bardSpells = new ArrayList<Spell>(); 
	static {
		setBardClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/BardClassFeatures.txt");
		setSpellsKnownByLevel();
		setBardSpells();
	}
	
	//Static Methods:
	private static void setBardClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[2]);
				ClassFeature bardClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				bardClassFeatures.put(parts[0], bardClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load Bard Class Features");
		}

		
	}
	
	private static void setSpellsKnownByLevel() {
		int[] valuesForMapLevel1 = {4, 2, 0, 0, 0, 0, 0};
		spellsKnownByLevel.put(1, valuesForMapLevel1);
		
		int[] valuesForMapLevel2 = {5, 3, 0, 0, 0, 0, 0};
		spellsKnownByLevel.put(2, valuesForMapLevel2);
		
		int[] valuesForMapLevel3 = {6, 4, 0, 0, 0, 0, 0};
		spellsKnownByLevel.put(3, valuesForMapLevel3);
		
		int[] valuesForMapLevel4 = {6, 4, 2, 0, 0, 0, 0};
		spellsKnownByLevel.put(4, valuesForMapLevel4);
		
		int[] valuesForMapLevel5 = {6, 4, 3, 0, 0, 0, 0};
		spellsKnownByLevel.put(5, valuesForMapLevel5);
		
		int[] valuesForMapLevel6 = {6, 4, 4, 0, 0, 0, 0};
		spellsKnownByLevel.put(6, valuesForMapLevel6);
		
		int[] valuesForMapLevel7 = {6, 5, 4, 2, 0, 0, 0};
		spellsKnownByLevel.put(7, valuesForMapLevel7);
		
		int[] valuesForMapLevel8 = {6, 5, 4, 3, 0, 0, 0};
		spellsKnownByLevel.put(8, valuesForMapLevel8);
		
		int[] valuesForMapLevel9 = {6, 5, 4, 4, 0, 0, 0};
		spellsKnownByLevel.put(9, valuesForMapLevel9);
		
		int[] valuesForMapLevel10 = {6, 5, 5, 4, 2, 0, 0};
		spellsKnownByLevel.put(10, valuesForMapLevel10);
		
		int[] valuesForMapLevel11 = {6, 6, 5, 4, 3, 0, 0};
		spellsKnownByLevel.put(11, valuesForMapLevel11);
		
		int[] valuesForMapLevel12 = {6, 6, 5, 4, 4, 0, 0};
		spellsKnownByLevel.put(12, valuesForMapLevel12);
		
		int[] valuesForMapLevel13 = {6, 6, 5, 5, 4, 2, 0};
		spellsKnownByLevel.put(13, valuesForMapLevel13);
		
		int[] valuesForMapLevel14 = {6, 6, 6, 5, 4, 3, 0};
		spellsKnownByLevel.put(14, valuesForMapLevel14);
		
		int[] valuesForMapLevel15 = {6, 6, 6, 5, 4, 4, 0};
		spellsKnownByLevel.put(15, valuesForMapLevel15);
		
		int[] valuesForMapLevel16 = {6, 6, 6, 5, 5, 4, 2};
		spellsKnownByLevel.put(16, valuesForMapLevel16);
		
		int[] valuesForMapLevel17 = {6, 6, 6, 6, 5, 4, 3};
		spellsKnownByLevel.put(17, valuesForMapLevel17);
		
		int[] valuesForMapLevel18 = {6, 6, 6, 6, 5, 4, 4};
		spellsKnownByLevel.put(18, valuesForMapLevel18);
		
		int[] valuesForMapLevel19 = {6, 6, 6, 6, 5, 5, 4};
		spellsKnownByLevel.put(19, valuesForMapLevel19);
		
		int[] valuesForMapLevel20 = {6, 6, 6, 6, 6, 5, 5};
		spellsKnownByLevel.put(20, valuesForMapLevel20);
		
	}
	
	private static void setBardSpells() {
		Set<String> spellNames = Spell.spellDescriptionsMap.keySet();
		for  (String spellName : spellNames) {
			if (spellName.contains("Bard")) {
				bardSpells.add(new Spell(spellName.split("%")[0], "Bard"));
			}
		}
	}
	
	//Instance Variables:
	
	//Constructors:
	public Bard(int level) {
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 8;
		this.classSkills = bardClassSkills;
		this.skillRanksPerLevel = 6;
		this.weaponAndArmorProficiencies = "A bard is proficient " + 
				"with all simple weapons, plus the longsword, rapier, " + 
				"sap, short sword, shortbow, and whip. Bards are also " + 
				"proficient with light armor and shields (except tower " + 
				"shields). A bard can cast bard spells while wearing light " + 
				"armor and use a shield without incurring the normal " + 
				"arcane spell failure chance.";
		
		Set<String> bardClassFeaturesKeys = bardClassFeatures.keySet();
		for (String key : bardClassFeaturesKeys) {
			if (bardClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(bardClassFeatures.get(key));
				this.specialAbilityDescriptions.add(bardClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + bardClassFeatures.get(key).getFullDescription());
			}
		}
		
		this.characterSpellsObject.setSpellsToChoose(spellsKnownByLevel.get(this.level));
		this.characterSpellsObject.incrementSpellsPerDay(1, 2);
		
		this.description = "Untold wonders and secrets exist for those skillful enough to discover them. Through cleverness, talent, "
				+ "and magic, these cunning few unravel the wiles of the world,	becoming adept in the arts of persuasion, manipulation,	"
				+ "and inspiration. Typically masters of one or many forms	of artistry, bards possess an uncanny ability to know more "
				+ "than they should and use what they learn to keep themselves and their allies ever one step ahead of danger. Bards "
				+ "are quick-witted and captivating, and their skills might lead them down many paths, be they gamblers or "
				+ "jacks-of-all-trades, scholars or performers, leaders or	scoundrels, or even all of the above. For bards, every day brings "
				+ "its own opportunities, adventures, and challenges, and only by bucking the odds, knowing the most, and	"
				+ "being the best might they claim the treasures of each.";
		
		this.role = "Bards capably confuse and confound their foes while inspiring their allies to ever-greater daring. While accomplished "
				+ "with both weapons and magic, the true strength of bards lies outside melee, where they can support their companions and undermine "
				+ "their foes without fear of interruptions to their performances.";
	}
	
	//Methods:

		
}
