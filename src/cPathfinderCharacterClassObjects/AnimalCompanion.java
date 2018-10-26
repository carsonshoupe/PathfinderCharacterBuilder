package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterSkillObjects.Skill;

//TODO: Specific animal stats


public class AnimalCompanion { 
	//Static Variables:
	public static Map<Integer, int[]> levelDecidedStatsMap = new HashMap<Integer, int[]>();
	public static Map<String, ClassFeature> animalCompanionFeaturesMap = new HashMap<String, ClassFeature>();
	
	static {
		setLevelDecidedStatsMap("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/AnimalCompanionLevelDecidedStats.txt");
		setAnimalCompanionFeaturesMap("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/AnimalCompanionFeatures.txt");
		
	}
	
	//Static Methods:
	public static int getHitDie(int level) {return levelDecidedStatsMap.get(level)[0];}
	public static int getBaseAttackBonus(int level) {return levelDecidedStatsMap.get(level)[1];}
	public static int getBaseFortSave(int level) {return levelDecidedStatsMap.get(level)[2];}
	public static int getBaseReflexSave(int level) {return levelDecidedStatsMap.get(level)[3];}
	public static int getBaseWillSave(int level) {return levelDecidedStatsMap.get(level)[4];}
	public static int getNumberOfSkills(int level) {return levelDecidedStatsMap.get(level)[5];}
	public static int getNumberOfFeats(int level) {return levelDecidedStatsMap.get(level)[6];}
	public static int getNaturalArmor(int level) {return levelDecidedStatsMap.get(level)[7];}
	public static int getStrDexBonus(int level) {return levelDecidedStatsMap.get(level)[8];}
	public static int getBonusTricks(int level) {return levelDecidedStatsMap.get(level)[9];}
	
	private static void setLevelDecidedStatsMap(String levelDecidedStatsFilePath) {
		String filePath = levelDecidedStatsFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int[] levelDecidedStatsArray;
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 11);
				levelDecidedStatsArray = new int[10];
				for (int counter = 0; counter < 10; counter++) {
					levelDecidedStatsArray[counter] = Integer.parseInt(parts[counter+1]);
				}
				levelDecidedStatsMap.put(Integer.parseInt(parts[0]), levelDecidedStatsArray);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load levelDecidedStatsMap in AnimalCompaion");
		}
	}
	
	private static void setAnimalCompanionFeaturesMap(String animalCompanionFeaturesFilePath) {
		String filePath = animalCompanionFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				animalCompanionFeaturesMap.put(parts[0], new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], ""));
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load animalCompanionFeaturesMap in AnimalCompanion");
		}
	}
	
	//Instance Variables:
	private int classLevel;
	private int hitDie;
	private int baseAttackBonus;
	private int[] baseSavingThrows = new int[3];
	private int naturalArmor;
	private int strDexBonus; 
	private Map<Skill, Integer> skillRanks = new HashMap<Skill, Integer>();
	private ArrayList<Feat> feats = new ArrayList<Feat>();
	private ArrayList<String> tricks = new ArrayList<String>();
	private ArrayList<ClassFeature> animalCompanionFeatures = new ArrayList<ClassFeature>();
	
	//Constructor:
	public AnimalCompanion(int level) {
		this.classLevel = level;
		this.hitDie = getHitDie(level);
		this.baseAttackBonus = getBaseAttackBonus(level);
		this.baseSavingThrows[0] = getBaseFortSave(level);
		this.baseSavingThrows[1] = getBaseReflexSave(level);
		this.baseSavingThrows[2] = getBaseWillSave(level);
		this.naturalArmor = getNaturalArmor(level);
		this.strDexBonus = getStrDexBonus(level);
		
		for (String feature : animalCompanionFeaturesMap.keySet()) {
			if (animalCompanionFeaturesMap.get(feature).getLevelAccessable() <= level) {
				animalCompanionFeatures.add(animalCompanionFeaturesMap.get(feature));
			}
		}	
	}
	
	//Methods:
	public int getClassLevel() {return this.classLevel;}
	public int getHitDie() {return this.hitDie;}
	public int getBaseAttackBonus() {return this.baseAttackBonus;}
	public int[] getBaseSavingThrows() {return this.baseSavingThrows;}
	public int getNaturalArmor() {return this.naturalArmor;}
	public int getStrDexBonus() {return this.strDexBonus;}
	public Map<Skill, Integer> getSkillRanks() {return this.skillRanks;}
	public ArrayList<String> getTricks() {return this.tricks;}
	public ArrayList<ClassFeature> getAnimalCompanionFeatures() {return this.animalCompanionFeatures;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}