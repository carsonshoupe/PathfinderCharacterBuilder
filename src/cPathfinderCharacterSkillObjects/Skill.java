package cPathfinderCharacterSkillObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Skill {
	//Static Variables:
	protected static final Map<String, String[]> skillDescriptionsMap;
	static {
		Map<String, String[]> outputMap = new HashMap<String, String[]>();
		String filePath = "SkillDescriptions.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 5);
				String key = parts[0];
				String[] value = new String[4];
				value[0] = parts[1];
				value[1] = parts[1];
				value[2] = parts[2];
				value[3] = parts[3];
				
				outputMap.put(key, value);
				reader.close();
			}
		}
		catch (IOException e) {
			System.out.println("Failed to load skillDescriptionsMap");
		}
		skillDescriptionsMap = outputMap;
	}
	
	//Instance Variables: 
	private String name;
	private String skillDescription;
	private int pageInCoreRuleBook;
	private boolean trainedOnly;
	private int abilityModifier;
	
	private boolean classSkill;
	private int skillRanks;
		
	//Constructors:
	Skill(String name) {
		this.name = name;
		this.skillDescription = skillDescriptionsMap.get(this.name)[0];
		this.trainedOnly = Boolean.parseBoolean(skillDescriptionsMap.get(this.name)[1]);
		this.abilityModifier = Integer.parseInt(skillDescriptionsMap.get(this.name)[2]);
		this.pageInCoreRuleBook = Integer.parseInt(skillDescriptionsMap.get(this.name)[3]);
	}
	
	//Methods: 
	public String getName() {return this.name;}
	public String getSkillDescription() {return this.skillDescription;}
	public int getPageInCoreRuleBOok() {return this.pageInCoreRuleBook;}
	public boolean getTrainedOnly() {return this.trainedOnly;}
	public int getAbilityModifier() {return this.abilityModifier;}
	
	public boolean isClassSkill() {return this.classSkill;}
	public int getSkillRanks() {return this.skillRanks;}
}
