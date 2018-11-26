package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;

public class Bloodline {
	//Static Variables:
	public static Map<String, String[]> bloodlineMap = new HashMap<String, String[]>();
	
	static {
		setBloodlinesMap("src/cPathfinderCharacterClassObjects/SorcererBloodlines.txt");
	}
	
	//Static Methods:
	private static void setBloodlinesMap(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int lineCounter = -1;
			String key = "";
			String[] value = new String[11];
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				if (lineCounter == 11) {
					bloodlineMap.put(key, value);
					value = new String[11];
				}
				if (line.contains("*Bloodline")) {
					key = line.split(" ")[1];
					lineCounter = 0;
					continue;
				}
				if (lineCounter < 11) {
					value[lineCounter] = line;
					lineCounter++;
				}
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load bloodlineMap");
		}
	}
	
	//Instance Variables:
	private String name; 
	private String description; 
	private Skill bloodlineClassSkill = new Skill(); 
	private Map<Integer, Spell> bloodlineSpells = new HashMap<Integer, Spell>(); //Levels Mapped to the Spell
	private Set<Feat> bonusFeats = new HashSet<Feat>();
	private String bloodlineArcana;
	private String bloodlinePowersDescription;
	private Set<ClassFeature> bloodlineClassFeatures = new HashSet<ClassFeature>();
	
	//Constructors: 
	public Bloodline(String bloodlineName) {
		this.name = bloodlineName;
		//System.out.println(this.name);
		this.description = bloodlineMap.get(bloodlineName)[0];
		//System.out.println(this.description);
		
		if (bloodlineMap.get(bloodlineName)[1].split(":")[1].equals("choose")) {}
		else {
			this.bloodlineClassSkill = new Skill(bloodlineMap.get(bloodlineName)[1].split(":")[1]);
			//System.out.println(this.bloodlineClassSkill.toString());
		}
		String[] spellsAsStringArray = bloodlineMap.get(bloodlineName)[2].split(":")[1].split(",");
		for (String spellAsString : spellsAsStringArray) {
			String[] spellAndLevel = spellAsString.split("%");
			//System.out.println(Arrays.toString(spellAndLevel));
			//System.out.println(Spell.findSpellClass(spellAndLevel[1]));
			bloodlineSpells.put(Integer.parseInt(spellAndLevel[0]), new Spell(spellAndLevel[1], Spell.findSpellClass(spellAndLevel[1])));
		}
		//System.out.println(this.bloodlineSpells.toString());
		
		String[] bonusFeatsAsStringArray = bloodlineMap.get(bloodlineName)[3].split(":")[1].split(",");
		for (String bonusFeatsAsString : bonusFeatsAsStringArray) {
			this.bonusFeats.add(new Feat(bonusFeatsAsString.replace(" ", "_").replace("-", "_").toUpperCase()));
		}
		
		this.bloodlineArcana = bloodlineMap.get(bloodlineName)[4];
		this.bloodlinePowersDescription = bloodlineMap.get(bloodlineName)[5];
		
		for (int counter = 6; counter < 11; counter++) {
			String[] classFeatureArr = bloodlineMap.get(bloodlineName)[counter].split(":");
			this.bloodlineClassFeatures.add(new ClassFeature(classFeatureArr[0], classFeatureArr[1], Integer.parseInt(classFeatureArr[2]), classFeatureArr[3], ""));
		}
	}
	
	//Methods
	public String getName() {return this.name;}
	public String getDescription() {return this.description;}
	public Skill getBloodlineClassSkill() {return this.bloodlineClassSkill;}
	public Set<Spell> getBloodlineSpells(int level) {
		Set<Spell> outputSet = new HashSet<Spell>();
		if (level >= 3) {outputSet.add(this.bloodlineSpells.get(3));}
		if (level >= 5) {outputSet.add(this.bloodlineSpells.get(5));}
		if (level >= 7) {outputSet.add(this.bloodlineSpells.get(7));}
		if (level >= 9) {outputSet.add(this.bloodlineSpells.get(9));}
		if (level >= 11) {outputSet.add(this.bloodlineSpells.get(11));}
		if (level >= 13) {outputSet.add(this.bloodlineSpells.get(13));}
		if (level >= 15) {outputSet.add(this.bloodlineSpells.get(15));}
		if (level >= 17) {outputSet.add(this.bloodlineSpells.get(17));}
		if (level >= 19) {outputSet.add(this.bloodlineSpells.get(19));}
		return outputSet;
	}
	public Set<Feat> getBonusFeats() {return this.bonusFeats;} //Player doesn't get all of these feats, but gets to choose a certain number them based on level
	public String getBloodlineArcana() {return this.bloodlineArcana;}
	public String getBloodlinePowerDescription() {return this.bloodlinePowersDescription;}
	public Set<ClassFeature> getClassFeatures(int level) {
		Set<ClassFeature> outputSet = new HashSet<ClassFeature>();
		for (ClassFeature classFeature : this.bloodlineClassFeatures) {
			if (level >= classFeature.getLevelAccessable()) {
				outputSet.add(classFeature);
			}
		}
		return outputSet;
	}
	
	@Override
	public String toString() {
		String outputString = this.name + "\n" 
				+ "Description: " + this.description + "\n"
				+ "Bloodline Class Skills: " + this.bloodlineClassSkill.toString() + "\n"
				+ "Bloodline Spells: " + this.getBloodlineSpells(20).toString() + "\n"
				+ "Bloodline Bonus Feats: " + this.bonusFeats.toString() + "\n"
				+ "Bloodline Arcana: " + this.bloodlineArcana + "\n"
				+ "Bloodline Power Description: " + this.bloodlinePowersDescription + "\n"
				+ "Bloodline Class Features: " + this.bloodlineClassFeatures.toString() + "\n";
		return outputString;
	}
		


}
