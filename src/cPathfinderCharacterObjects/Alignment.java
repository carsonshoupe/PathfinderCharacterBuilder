package cPathfinderCharacterObjects;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cPathfinderCharacterSkillObjects.Skill;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;

public enum Alignment {
	CHAOTICGOOD("Chaotic", "Good"), 
	NEUTRALGOOD("Neutral", "Good"), 
	LAWFULGOOD("Lawful", "Good"), 
	CHAOTICNEUTRAL("Chaotic", "Neutral"), 
	TRUENEUTRAL("Neutral", "Neutral"), 
	LAWFULNEUTRAL("Lawful", "Neutral"), 
	CHAOTICEVIL("Chaotic", "Evil"), 
	NEUTRALEVIL("Neutral", "Evil"), 
	LAWFULEVIL("Lawful", "Evil");
	
	//Static 
	private static Map<String, String[]> alignmentDescriptionMap = new HashMap<String, String[]>();
	static {
		setAlignmentDescriptionMap();
	}
	
	//Static Methods:
	private static void setAlignmentDescriptionMap() {
		try {
			String fileName = "src/cPathfinderCharacterObjects/AlignmentDescriptions.json";
			byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
			ObjectMapper mapper = new ObjectMapper();
			
			//Set up alignmentDescriptionMap
			Alignment.alignmentDescriptionMap = mapper.readValue(jsonData, new TypeReference<HashMap<String, String[]>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Instance Variables: 
	private String chaoticToLawful;
	private String evilToGood;
	
	//Constructors:
	Alignment(String chaoticToLawful, String evilToGood) {
		this.chaoticToLawful = chaoticToLawful;
		this.evilToGood = evilToGood;
		
	}
	
	public String getChaoticToLawful() {return this.chaoticToLawful;}
	public String getevilToGood() {return this.evilToGood;}
	
	public String getDescription() {return alignmentDescriptionMap.get(this.name())[0];}
	public String getExamples() {return alignmentDescriptionMap.get(this.name())[1];}

}
