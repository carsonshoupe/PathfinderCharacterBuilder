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

/*
 * TODO: Still need to restrict domain choices based on deity and alignment.  
 * 
 * TODO: Spell choices need to be limited by domain selections
 * 
 * TODO: Add number of spells to choose by level property
 */

public class Cleric extends CharacterClass {
	//Static Variables: 	
		protected static final Set<Skill> clericClassSkills = new HashSet<Skill>(Arrays.asList(new Skill("APPRAISE"), new Skill("CRAFT1"), 
				new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("DIPLOMACY"), new Skill("HEAL"), new Skill("KNOWLEDGE_ARCANA"), 
				new Skill("KNOWLEDGE_HISTORY"), new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_PLANES"), new Skill("KNOWLEDGE_RELIGION"),
				new Skill("LINGUISTICS"), new Skill("PROFESSION1"), new Skill("PROFESSION2"), new Skill("SENSE_MOTIVE"), new Skill("SPELLCRAFT")));
		
		protected static final Map<String, ClassFeature> clericClassFeatures = new HashMap<String, ClassFeature>();
		static {
			setClericClassFeatures("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/ClericClassFeatures.txt");
		}
		
		//Static Methods:
		private static void setClericClassFeatures(String classFeaturesFilePath) {
			String filePath = classFeaturesFilePath; 
			String line;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				while ((line = reader.readLine()) != null ) {
					//System.out.println(line);
					String[] parts = line.split(":", 4);
					ClassFeature clericClassFeature = new ClassFeature(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], "");
					clericClassFeatures.put(parts[0], clericClassFeature);
				}
				reader.close();
			}
			catch (IOException e) {
				System.out.println("Failed to load ClassFeatures in Cleric");
			}
		}
		
		//Instance Variables:
		private String deity; 
		private ClericDomain domain1;
		private ClericDomain domain2;
		
		//Constructors:
		public Cleric(int level) {
			this.level = level;
			this.alignmentRestriction = "A cleric’s alignment must be within one step of her deity’s, along either the law/chaos axis or the good/evil axis.";
			this.hitDie = 8;
			this.classSkills = clericClassSkills;
			this.skillRanksPerLevel = 2;
			this.weaponAndArmorProficiencies = "Clerics are proficient with all simple weapons, light armor, medium armor, and " + 
					"shields (except tower shields). Clerics are also proficient with the favored weapon of their deity.";
			
			Set<String> clericClassFeaturesKeys = clericClassFeatures.keySet();
			for (String key : clericClassFeaturesKeys) {
				if (clericClassFeatures.get(key).getLevelAccessable() <= this.level) {
					this.classFeatures.add(clericClassFeatures.get(key));
					this.specialAbilityDescriptions.add(clericClassFeatures.get(key).getName().replaceAll("_", " ") + ": " + clericClassFeatures.get(key).getFullDescription());
				}
			}
			
			this.description = "In faith and the miracles of the divine, many find a greater purpose. Called to serve powers beyond most "
					+ "mortal understanding, all priests preach wonders and provide for the spiritual needs of their people. Clerics are "
					+ "more than mere priests, though; these emissaries of the divine work the will of their deities through strength of "
					+ "arms and the magic of their gods. Devoted to the tenets of the religions and philosophies that inspire them, these "
					+ "ecclesiastics quest to spread the knowledge and inf luence of their faith. Yet while they might share similar "
					+ "abilities, clerics prove as different from one another as the divinities they serve, with some offering healing and "
					+ "redemption, others judging law and truth, and still others spreading conf lict and corruption. The ways of the cleric "
					+ "are varied, yet all who tread these paths walk with the mightiest of allies and bear the arms of the gods themselves.";
			
			this.role = "More than capable of upholding the honor of their deities in battle, clerics often prove stalwart and capable "
					+ "combatants. Their true strength lies in their capability to draw upon the power of their deities, whether to increase "
					+ "their own and their allies’ prowess in battle, to vex their foes with divine magic, or to lend healing to companions in need. "
					+ "As their powers are inf luenced by their faith, all clerics must focus their worship upon a divine source. While the vast majority of "
					+ "clerics revere a specif ic deity, a small number dedicate themselves to a divine concept worthy of devotion—such as battle, "
					+ "death, justice, or knowledge— free of a deif ic abstraction. (Work with your GM if you prefer this path to selecting a specific deity.)";
		}
		
		//Methods:
		public String getDeity() {return this.deity;}
		public void setDeity(String deity) {this.deity = deity;}
		
		public ClericDomain getDomain1() {return this.domain1;}
		public ClericDomain getDomain2() {return this.domain2;}
		
		public void setDomain1(ClericDomain domain) {	
			this.domain1 = domain;
			this.classFeatures.add(this.domain1.getClassFeature1());
			if (this.level >= this.domain1.getClassFeature2().getLevelAccessable()) {
				this.classFeatures.add(this.domain1.getClassFeature2());
			}
		}
		
		public void setDomain2(ClericDomain domain) {
			this.domain2 = domain;
			this.classFeatures.add(this.domain2.getClassFeature1());
			if (this.level >= this.domain2.getClassFeature2().getLevelAccessable()) {
				this.classFeatures.add(this.domain2.getClassFeature2());
			}
		}

		

}
