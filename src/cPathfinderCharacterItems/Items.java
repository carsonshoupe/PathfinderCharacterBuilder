package cPathfinderCharacterItems;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
;

public class Items {
	public static Weapon[] weapons; 
	public static Armor[] armor;
	
	static {
		setWeapons();
		setArmor();
	}
	
	private static void setWeapons() {
		try {
			String fileName = "src/cPathfinderCharacterItems/Weapons.json";
			byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
			ObjectMapper mapper = new ObjectMapper();
			
			//Set up alignmentDescriptionMap
			weapons = mapper.readValue(jsonData, Weapon[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void setArmor() {
		try {
			String fileName = "src/cPathfinderCharacterItems/Armor.json";
			byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
			ObjectMapper mapper = new ObjectMapper();
			
			//Set up alignmentDescriptionMap
			armor = mapper.readValue(jsonData, Armor[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Weapon[] getWeapons() {return Items.weapons;}
	public static Armor[] getArmor() {return Items.armor;}
}
