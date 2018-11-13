package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import cPathfinderCharacterSpellObjects.Spell;

public class ArcaneSchool {
	//Static Variables:
	public static Map<String, String[]> arcaneSchoolsMap = new HashMap<String, String[]>();
	
	static {
		setArcaneSchoolsMap("C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterClassObjects/WizardArcaneSchools.txt");
	}
	
	//Static Methods:
	private static void setArcaneSchoolsMap(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int lineCounter = -1;
			String key = "";
			String[] value = new String[4];
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				if (lineCounter == 4) {
					arcaneSchoolsMap.put(key, value);
					value = new String[5];
				}
				if (line.contains("*School")) {
					key = line.split(" ")[1];
					lineCounter = 0;
					continue;
				}
				if (lineCounter < 4) {
					value[lineCounter] = line;
					lineCounter++;
				}
			}
			arcaneSchoolsMap.put(key,value);
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load arcaneSchoolsMap");
		}
	}
	
	//Instance Variables:
	private String name; 
	private String description;
	private Set<ClassFeature> arcaneSchoolFeatures = new HashSet<ClassFeature>();
	
	//Constructors: 
	public ArcaneSchool(String arcaneSchoolName) {
		this.name = arcaneSchoolName;
		this.description = arcaneSchoolsMap.get(arcaneSchoolName)[0];
		for (int counter = 1; counter < 4; counter++) {
			//System.out.println(arcaneSchoolsMap.get(arcaneSchoolName)[counter]);
			if (arcaneSchoolsMap.get(arcaneSchoolName)[counter] == null) {
				continue;
			}
			else {
				String[] schoolStringArr = arcaneSchoolsMap.get(arcaneSchoolName)[counter].split(":");
				arcaneSchoolFeatures.add(new ClassFeature(schoolStringArr[0], schoolStringArr[1], Integer.parseInt(schoolStringArr[2]), schoolStringArr[3], ""));
			}
		}
		
	}
	
	//Methods
	public String getName() {return this.name;}
	public String getDescription() {return this.description;}
	public Set<ClassFeature> getArcaneSchoolFeatures(int level) {
		Set<ClassFeature> outputSet = new HashSet<ClassFeature>();
		for (ClassFeature classFeature : this.arcaneSchoolFeatures) {
			if (level >= classFeature.getLevelAccessable()) {
				outputSet.add(classFeature);
			}
		}
		return outputSet;
	}
	
	
	@Override
	public String toString() {
		String outputString = this.name + "\n" 
				+ "Description: " + this.getDescription() + "\n"
				+ "Arcane School Features: " + this.getArcaneSchoolFeatures(20) + "\n";
		return outputString;
	}
}
