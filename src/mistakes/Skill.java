package mistakes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Skill {
	ACROBATICS(false, 1, 87), 
	APPRAISE(false, 3, 90), 
	BLUFF(false, 5, 90), 
	CLIMB(false, 0, 90), 
	CRAFT1(false, 3, 91), 
	CRAFT2(false, 3, 91), 
	CRAFT3(false, 3, 91), 
	DIPLOMACY(false, 5, 93), 
	DISABLE_DEVICE(true, 1, 94), 
	DISGUISE(false, 5, 95), 
	ESCAPE_ARTIST(false, 1, 95), 
	FLY(false, 1, 96), 
	HANDLE_ANIMAL(true, 5, 97), 
	HEAL(false, 4, 	98), 
	INTIMIDATE(false, 5, 99), 
	KNOWLEDGE_ARCANA(true, 3, 99), 
	KNOLWEDGE_DUNGEONEERING(true, 3, 99),
	KNOLWEDGE_ENGINEERING(true, 3, 99),
	KNOLWEDGE_GEOGRAPHY(true, 3, 99),
	KNOLWEDGE_HISTORY(true, 3, 99),
	KNOLWEDGE_LOCAL(true, 3, 99),
	KNOLWEDGE_NATURE(true, 3, 99),
	KNOLWEDGE_NOBILITY(true, 3, 99),
	KNOLWEDGE_PLANES(true, 3, 99),
	KNOLWEDGE_RELIGION(true, 3, 99),
	LINGUISTICS(true, 3, 100), 
	PERCEPTION(false, 4, 102), 
	PERFORM1(false, 5, 102), 
	PERFORM2(false, 5, 102), 
	PROFESSION1(true, 4, 103),
	PROFESSION2(true, 4, 103), 
	RIDE(false, 1, 103), 
	SENSE_MOTIVE(false, 4, 104), 
	SLIGHT_OF_HAND(true, 1, 104), 
	SPELLCRAFT(true, 3, 106), 
	STEALTH(false, 1, 106), 
	SURVIVAL(false, 4, 107), 
	SWIM(false, 0, 108), 
	USE_MAGICAL_DEVICE(true, 5, 108);
	
	//Constructor:
	Skill(boolean trainedOnly, int abilityModifier, int pageInCoreRuleBook) {
		this.trainedOnly = trainedOnly;
		this.abilityModifier = abilityModifier;
		this.pageInCoreRuleBook = pageInCoreRuleBook;
	}
	
	//Instance Variables: 
	private String textDescription;
	private int pageInCoreRuleBook;
	private boolean trainedOnly;
	private int abilityModifier;
	
	//Methods: 
	public String getTextDescription() {return this.textDescription;}
	public int getPageInCoreRuleBOok() {return this.pageInCoreRuleBook;}
	public boolean getTrainedOnly() {return this.trainedOnly;}
	public int getAbilityModifier() {return this.abilityModifier;}
	
	
	//Static Variables: 
	protected static final Map<String, String> skillDescriptionsMap;
	static {
		HashMap<String, String> outputMap = new HashMap<String, String>();
		String filePath = "SkillDescriptions.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 2);
				String key = parts[0];
				String value = parts[1]; 
				outputMap.put(key, value);
				reader.close();
			}
		}
		catch (IOException e) {
			System.out.println("Failed to load skillDescriptionsMap");
		}
		skillDescriptionsMap = Collections.unmodifiableMap(outputMap);
		
		for(Skill skill : EnumSet.allOf(Skill.class)) {
			skill.textDescription = skillDescriptionsMap.get(skill.name());
		}
	}
}
