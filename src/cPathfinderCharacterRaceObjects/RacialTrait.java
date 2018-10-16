package cPathfinderCharacterRaceObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RacialTrait {
	//Static Variables:
	protected static final Map<String, String[]> racialTraitsMap;
	static {
		HashMap<String, String[]> outputMap = new HashMap<String, String[]>();
		String filePath = "RacialSkillTraits.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 3);
				String key = parts[0];
				String[] value = new String[2];
				value[0] = parts[1];
				value[1] = parts[2];
				outputMap.put(key, value);
				reader.close();
			}
		}
		catch (IOException e) {
			System.out.println("Failed to load racialTraitsMap");
		}
		racialTraitsMap = Collections.unmodifiableMap(outputMap);
	}
	
	//Instance Variables: 
	private String name;
	private String racialTraitDescription;
	private boolean updateCharacterSheet;
	
	//Constructors:
	RacialTrait(String name) {
		this.name = name;
		this.racialTraitDescription = racialTraitsMap.get(this.name)[0];
		this.updateCharacterSheet = Boolean.parseBoolean(racialTraitsMap.get(this.name)[1]);
	}
	
	//Methods:
	
	public String getName() {return this.name;}
	public String getracialTraitDescription() {return this.racialTraitDescription;}
	public boolean shouldUpdateCharacterSheet() {return this.updateCharacterSheet;}
}
