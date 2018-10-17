package cPathfinderCharacterFeatObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Feat {
	//Static Variables:
	protected static final Map<String, String[]> featMap;
	static {
		HashMap<String, String[]> outputMap = new HashMap<String, String[]>();
		String filePath = "C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterFeatObjects/FeatsChartAsText.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((line = reader.readLine()) != null ) {
				String[] parts = line.split(":", 6);
				String key = parts[0];
				String[] value = new String[5];
				value[0] = parts[1];
				value[1] = parts[2];
				value[2] = parts[3];
				value[3] = parts[4];
				value[4] = parts[5];
				outputMap.put(key, value);
				//System.out.println(key + ": " + value[1]);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load featMap");
		}
		featMap = Collections.unmodifiableMap(outputMap);
	}
	
	
	//Instance Variables:
	private String name; 
	private FeatPrerequisite featPrerequisite; 
	private String featPrerequisiteAsString;
	private String benefit;
	private boolean updateCharacterSheet;
	private Map<String, String> infoToUpdateCharacterSheet;
	private int pageDescriptionInRulebook;
	private boolean isCombatFeat;
	private boolean isItemCreationFeat;
	private boolean isMetamagicFeat;
	
	
	//Constructors:
	public Feat(String name) {
		this.name = name;
		//System.out.println(this.name);
		this.benefit = featMap.get(this.name)[2];
		this.updateCharacterSheet = Boolean.parseBoolean(featMap.get(this.name)[3]);
		
		if (featMap.get(this.name)[1].equals(" — ")) {
			//System.out.println((this.name) + " does not have any prerequisites.");
			this.featPrerequisiteAsString = "No Prerequisites";
			this.featPrerequisite = null;
		}
		else {
			//System.out.println("featPrerequisitAsString: " + featMap.get(this.name)[1]);
			this.featPrerequisiteAsString = featMap.get(this.name)[1];
			this.featPrerequisite = new FeatPrerequisite(this.featPrerequisiteAsString);
		}
		
		if (featMap.get(this.name)[0].equals("*")) {this.isCombatFeat = true;}
		else {this.isCombatFeat = false;}
		
		if (featMap.get(this.name)[0].equals("I")) {this.isItemCreationFeat = true;}
		else {this.isItemCreationFeat = false;}
		
		if (featMap.get(this.name)[0].equals("M")) {this.isMetamagicFeat = true;}
		else {this.isMetamagicFeat = false;}
		
		
		if (this.updateCharacterSheet == true) {
			this.infoToUpdateCharacterSheet = new HashMap<String, String>();
			String[] infoText = featMap.get(this.name)[4].split(";");
			for (String info : infoText) {
				String[] infoParts = info.split(",");
				this.infoToUpdateCharacterSheet.put(infoParts[0], infoParts[1]);
			}
		}
	}
	
	//Methods:
	public String getFeatName() {return this.name;}
	public FeatPrerequisite getFeatPrerequisite() {return this.featPrerequisite;}
	public String getFeatPrerequisiteAsString() {return this.featPrerequisiteAsString;}
	public String getBenefit() {return this.benefit;}
	public boolean shouldUpdateCharacterSheet() {return this.updateCharacterSheet;}
	public Map<String, String> getInfoToUpdateCharacterSheet() {return this.infoToUpdateCharacterSheet;}
	public int getPageDescriptionInRulebook() {return this.pageDescriptionInRulebook;}
	public boolean getIsCombatFeat() {return this.isCombatFeat;}
	public boolean getIsItemCreationFeat() {return this.isItemCreationFeat;}
	public boolean getIsMetaMagicFeat() {return this.isMetamagicFeat;}
	
	

}
