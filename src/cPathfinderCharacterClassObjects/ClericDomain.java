package cPathfinderCharacterClassObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cPathfinderCharacterSpellObjects.Spell;

public class ClericDomain { //TODO: change this to just domain so its more intuitive for Druids to use them as well. 
	//Static Variables:
	public static Map<String, String[]> clericDomainsMap = new HashMap<String, String[]>();
	
	static {
		setClericDomainsMap("src/cPathfinderCharacterClassObjects/ClericDomains.txt");
	}
	
	//Static Methods:
	private static void setClericDomainsMap(String classFeaturesFilePath) {
		String filePath = classFeaturesFilePath; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int lineCounter = -1;
			String key = "";
			String[] value = new String[5];
			while ((line = reader.readLine()) != null ) {
				//System.out.println(line);
				if (lineCounter == 5) {
					clericDomainsMap.put(key, value);
					value = new String[5];
				}
				if (line.contains("*Domain")) {
					key = line.split(" ")[1];
					lineCounter = 0;
					continue;
				}
				if (lineCounter < 5) {
					value[lineCounter] = line;
					lineCounter++;
				}
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Failed to load ClericDomainsMap");
		}
	}
	
	//Instance Variables:
	private String name; 
	private String[] deities; 
	private String grantedPowers; 
	private ClassFeature classFeature1; 
	private ClassFeature classFeature2;
	private Spell[] domainSpells = new Spell[9];
	
	
	//Constructors: 
	public ClericDomain(String domainName) {
		this.name = domainName;
		this.deities = clericDomainsMap.get(domainName)[0].substring(9).split(", ");
		this.grantedPowers = clericDomainsMap.get(domainName)[1].substring(16);
		
		String[] classFeature1 = clericDomainsMap.get(domainName)[2].split(":");
		this.classFeature1 = new ClassFeature(classFeature1[0], classFeature1[1], Integer.parseInt(classFeature1[2]), classFeature1[3], "");
		
		String[] classFeature2 = clericDomainsMap.get(domainName)[3].split(":");
		this.classFeature2 = new ClassFeature(classFeature2[0], classFeature2[1], Integer.parseInt(classFeature2[2]), classFeature2[3], "");
		
		String[] spellsText = clericDomainsMap.get(domainName)[4].substring(15).split(", ");
		int spellCounter = 0;
		String spellName;
		String spellClass;
		for (String spellText : spellsText) {
			spellName = spellText.split("—")[1]; 
			spellClass = Spell.findSpellClass(spellName);
			this.domainSpells[spellCounter] = new Spell(spellName, spellClass);
			spellCounter++;
		}
		
	}
	
	//Methods
	public String getDomainName() {return this.name;}
	public String[] getDeities() {return this.deities;}
	public String getGrantedPowers() {return this.grantedPowers;}
	public ClassFeature getClassFeature1() {return this.classFeature1;}
	public ClassFeature getClassFeature2() {return this.classFeature2;}
	public Spell[] getDomainSpells() {return this.domainSpells;}
	public Spell getDomainSpell(int level) {return this.domainSpells[level-1];}
	
	
	@Override
	public String toString() {
		String outputString = this.name + "\n" 
				+ "Deities: " + Arrays.toString(this.deities) + "\n"
				+ "Granted Powers: " + this.grantedPowers + "\n"
				+ this.classFeature1.getName() + "\n"
				+ this.classFeature2.getName() + "\n"
				+ "Spells: " + Arrays.deepToString(this.domainSpells) + "\n";
		return outputString;
	}
	

}
