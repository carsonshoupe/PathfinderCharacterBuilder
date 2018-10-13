package cPathfinderCharacterRaceObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.EnumSet;

public enum RacialTraits {
	//RacialTraits: 
	ADAPTABILIY("Adaptability", true),
	BONUS_FEAT("Bonus Feat", true),
	DEFENSIVE_TRAINING("Defensive Training", false),
	ELF_BLOOD("Elf Blood", false),
	ELVEN_IMMUNITIES("Elven Immunities", false),
	ELVEN_MAGIC("Elven Magic", false),
	FEARLESS("Fearless", false),
	GNOME_MAGIC("Gnome Magic", false),
	GREED("Greed", false),
	HALFLING_LUCK("Halfling Luck", true),
	HARDY("Hardy", false),
	HATRED_ORC_GOBLINOID("Hatred - Orc Goblinoid", false),
	HATRED_REPTILIAN_GOBLINOID("Hatred - Reptilian Goblinoid", false),
	ILLUSION_RESISTANCE("Illusion Resistance", false),
	INTIMIDATING("Intimidating", true),
	KEEN_SENSES("Keen Senses", true),
	MULTITALENTED("Multitalented", true),
	OBSESSIVE("Obsessive", true),
	ORC_BLOOD("Orc Blood", false),
	ORC_FEROCITY("Ord Ferocity", true),
	SKILLED("Skilled", true),
	SLOW_AND_STEADY("Slow and Steady", false),
	STABILITY("Stability", false),
	STONECUNNING("Stonecunning", false),
	SURE_FOOTED("Sure Footed", true);
	
	//Constructor: 
	
	RacialTraits(String name, boolean updateCharacterSheet){
		this.name = name;
		this.updateCharacterSheet = updateCharacterSheet;
	}
	
	//Instance Variables: 
	private String name;
	private String text;
	private boolean updateCharacterSheet;
	
	//Methods: 
	public String getName() {return this.name;}
	public String getText() {return this.text;}
	public boolean shouldUpdateCharacterSheet() {return this.updateCharacterSheet;}
	
	//Static Variables:
	protected static final Map<String, String> racialTraitsMap;
	static {
		HashMap<String, String> outputMap = new HashMap<String, String>();
		String filePath = "RacialSkillTraits.txt"; 
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
			System.out.println("Failed to load racialTraitsMap");
		}
		racialTraitsMap = Collections.unmodifiableMap(outputMap);
		
		for(RacialTraits racialTraits : EnumSet.allOf(RacialTraits.class)) {
			racialTraits.text = racialTraitsMap.get(racialTraits.name);
		}
	}

}
