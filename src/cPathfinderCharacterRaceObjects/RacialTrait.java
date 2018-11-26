package cPathfinderCharacterRaceObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RacialTrait {
	//Static Variables:
	protected static Map<String, String[]> racialTraitsMap;
	static {
		try {
			String fileName = "src/cPathfinderCharacterRaceObjects/RacialTraits.json";
			byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
			ObjectMapper mapper = new ObjectMapper();
			
			RacialTrait.racialTraitsMap = mapper.readValue(jsonData, new TypeReference<HashMap<String, String[]>>(){});
		} catch (Exception e) {
			System.out.println("Failed to load racialTraitsMap");
			e.printStackTrace();
		}
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
