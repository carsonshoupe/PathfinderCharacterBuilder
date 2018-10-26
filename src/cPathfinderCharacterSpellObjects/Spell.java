package cPathfinderCharacterSpellObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Spell {
	//Static Variables:
	public static Map<String, String[]> spellDescriptionsMap = new HashMap<String, String[]>();
	public static final ArrayList<String> spellNames = new ArrayList<String>();
	static {
		setSpellMaps("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterSpellObjects/AbbreviatedSpellDescriptions.txt");
	}
	
	//Static Methods:
	public static void setSpellMaps(String spellsFilePath) {
		Map<String, String[]> outputMap = new HashMap<String, String[]>();
		String filePath = spellsFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String characterClass = "";
			int characterLevel = 0; 
			String spellType = null; 
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				if (Character.isDigit(line.charAt(0))) {
					characterLevel = Character.getNumericValue(line.charAt(0));
					String[] parts = line.split(" ");
					characterClass = parts[1];
					continue;
				}
				
				if (line.split(" ").length == 1) {
					spellType = line;
					continue;
				}
				String[] parts = line.split(": ", 2);
				String key = parts[0] + "%" + characterClass;
				String[] value = new String[4];
				value[0] = parts[1];
				value[1] = characterClass;
				value[2] = Integer.toString(characterLevel);
				value[3] = spellType;
				outputMap.put(key, value);
				spellNames.add(parts[0] + "%" + characterClass);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load skillDescriptionsMap in Skill");
		} 
		spellDescriptionsMap = outputMap;
	}
	
	public static String findSpellClass(String spellName) {
		String[] characterClasses = {"Bard", "Cleric", "Druid", "Paladin", "Ranger", "Sorcerer/Wizard"};
		for (String characterClass : characterClasses) {
			if (!(spellDescriptionsMap.get(spellName + "%" + characterClass) == null)) {
				return characterClass;
			}
		}
		return null;
	}
	
	//Instance Variables:
	private String spellName; 
	private String spellDescription;
	private String spellClass; 
	private int spellLevel;
	private String spellType;
	
	//Constructors:
	public Spell(String spellName, String characterClass) {
		this.spellName = spellName;
		this.spellDescription = spellDescriptionsMap.get(spellName + "%" + characterClass)[0];
		this.spellClass = spellDescriptionsMap.get(spellName + "%" + characterClass)[1];
		this.spellLevel = Integer.parseInt(spellDescriptionsMap.get(spellName + "%" + characterClass)[2]);
		this.spellType = spellDescriptionsMap.get(spellName + "%" + characterClass)[3];
	}
	
	//Methods: 
	public String getSpellName() {return this.spellName;}
	public String getSpellDescription() {return this.spellDescription;}
	public String getSpellClass() {return this.spellClass;}
	public int getSpellLevel() {return this.spellLevel;}
	public String getSpellType() {return this.spellType;}
	
	@Override
	public String toString() {
		/*
		String outputString = this.spellName + " (Level " + this.spellLevel + " " + this.spellClass + ")\n "
				+ this.spellDescription + "\n" + " Type: " + this.spellType + "\n";
		*/
		String outputString = this.spellName;
		
		return outputString;
	}
	
	
	

}
