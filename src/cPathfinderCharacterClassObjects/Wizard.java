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

public class Wizard extends CharacterClass {
	//Static Variables: 	
	protected static final Set<Skill> wizardClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("APPRAISE"), new Skill("CRAFT1"), 
			new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("FLY"), new Skill("KNOWLEDGE_ARCANA"), new Skill("KNOWLEDGE_DUNGEONEERING"), 
			new Skill("KNOWLEDGE_ENGINEERING"), new Skill("KNOWLEDGE_GEOGRAPHY"), new Skill("KNOWLEDGE_HISTORY"), new Skill("KNOWLEDGE_LOCAL"), 
			new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_PLANES"), new Skill("KNOWLEDGE_RELIGION"), new Skill("LINGUISTICS"),
			new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("SPELLCRAFT")));
	
	protected static final Map<String, ClassFeature> wizardClassFeatures = new HashMap<String, ClassFeature>();
	static {
		setWizardClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/WizardClassFeatures.txt");
	}
	
	//Static Methods:
	private static void setWizardClassFeatures(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				String[] parts = line.split(":", 4);
				//System.out.println(parts[0] + ": " + parts[3]);
				ClassFeature wizardClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
				wizardClassFeatures.put(parts[0], wizardClassFeature);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClassFeatures in Wizard");
		}
	}

	
	//Instance Variables:
	private ArcaneSchool arcaneSchool; 
	private ArcaneSchool[] oppositionSchools = new ArcaneSchool[2];
	
	
	//Constructors:
	public Wizard(int level) {
		this.level = level;
		this.alignmentRestriction = "None";
		this.hitDie = 6;
		this.classSkills = wizardClassSkills;
		this.skillRanksPerLevel = 2;
		this.weaponAndArmorProficiencies = "Wizards are proficient with the club, dagger, heavy crossbow, light crossbow, and "
				+ "quarterstaff, but not with any type of armor or shield. Armor interferes with a wizard’s movements, which can "
				+ "cause his spells with somatic components to fail.";
		
		Set<String> wizardClassFeaturesKeys = wizardClassFeatures.keySet();
		for (String key : wizardClassFeaturesKeys) {
			if (wizardClassFeatures.get(key).getLevelAccessable() <= this.level) {
				this.classFeatures.add(wizardClassFeatures.get(key));
				this.specialAbilityDescriptions.add(wizardClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + wizardClassFeatures.get(key).getFullDescription());
			}
		}
	}
	
	//Methods:
	
	public ArcaneSchool getArcaneSchool() {return this.arcaneSchool;}
	public ArcaneSchool[] getOppositionSchools() {return this.getOppositionSchools();}
	public void setArcaneSchool(ArcaneSchool arcaneSchool) {
		this.arcaneSchool = arcaneSchool;
		//TODO: Add Class Features, Add bonus spell slots
	}
	public void setArcaneSchools(ArcaneSchool as1, ArcaneSchool as2) {
		this.oppositionSchools[0] = as1;
		this.oppositionSchools[1] = as2;
	}
	

	
}
