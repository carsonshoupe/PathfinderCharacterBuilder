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
		String filePath = "C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterRaceObjects/RacialSkillTraits.txt"; 
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
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load racialTraitsMap");
		}
		racialTraitsMap = Collections.unmodifiableMap(outputMap);
	}
	
	//Instance Variables: 
	private String name;
	private String description;
	private boolean updateCharacterSheet;
	
	//Constructors:
	public RacialTrait(String name) {
		this.name = name;
		this.description = racialTraitsMap.get(this.name)[0];
		this.updateCharacterSheet = Boolean.parseBoolean(racialTraitsMap.get(this.name)[1]);
	}
	
	//Methods:
	
	public String getName() {
		StringBuilder outputString = new StringBuilder();
		String[] outputStringArr = this.name.toLowerCase().split("_");
		for (String word : outputStringArr) {
			outputString.append(Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ");
		}
		return outputString.toString().trim();
	}
	public String getDescription() {return this.description;}
	public boolean shouldUpdateCharacterSheet() {return this.updateCharacterSheet;}
	
	@Override
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		String[] outputStringArr = this.name.toLowerCase().split("_");
		for (String word : outputStringArr) {
			outputString.append(Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ");
		}
		outputString.trimToSize();
		return outputString.toString();
	}
	
	@Override 
	public RacialTrait clone() throws CloneNotSupportedException {
		RacialTrait outputRacialTrait = (RacialTrait) super.clone(); 
		return outputRacialTrait;
	}
}
