package cTestCases;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

import cPathfinderCharacterClassObjects.Barbarian;
import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterRaceObjects.Dwarf;
import cPathfinderCharacterRaceObjects.Elf;
import cPathfinderCharacterRaceObjects.Gnome;
import cPathfinderCharacterRaceObjects.HalfElf;
import cPathfinderCharacterRaceObjects.HalfOrc;
import cPathfinderCharacterRaceObjects.Halfling;
import cPathfinderCharacterRaceObjects.Human;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;

public class TestPathfinderCharacter {
	
	@Test
	public void testBarbarianClass() {
		
	}
	
	@Test
	public void testCharacterRaces() {
		PathfinderCharacter dwarfCharacter = new PathfinderCharacter();
		PathfinderCharacter elfCharacter = new PathfinderCharacter();
		PathfinderCharacter gnomeCharacter = new PathfinderCharacter();
		PathfinderCharacter halfElfCharacter = new PathfinderCharacter();
		PathfinderCharacter halfOrcCharacter = new PathfinderCharacter();
		PathfinderCharacter humanCharacter = new PathfinderCharacter();
		PathfinderCharacter halflingCharacter = new PathfinderCharacter();
		dwarfCharacter.setRace(new Dwarf());
		System.out.println(dwarfCharacter.getRace().toString());
		elfCharacter.setRace(new Elf());
		System.out.println(elfCharacter.getRace().toString());
		gnomeCharacter.setRace(new Gnome());
		System.out.println(gnomeCharacter.getRace().toString());
		halfElfCharacter.setRace(new HalfElf());
		System.out.println(halfElfCharacter.getRace().toString());
		halfOrcCharacter.setRace(new HalfOrc());
		System.out.println(halfOrcCharacter.getRace().toString());
		humanCharacter.setRace(new Human());
		System.out.println(humanCharacter.getRace().toString());
		halflingCharacter.setRace(new Halfling());
		System.out.println(halflingCharacter.getRace().toString());
		
		
	}

	@Test
	public void testCharacterSkills() {
		PathfinderCharacter chad = new PathfinderCharacter();
		CharacterSkills charSkills = chad.getCharacterSkills(); 
		System.out.println(chad.getCharacterSkills().toString()); 
		
		Skill[] charSkillsArr = charSkills.getCharacterSkillsArr();
		for (Skill skill : charSkillsArr) {
			charSkills.incrementSkillRank(skill, 4);
		}
		System.out.println(chad.getCharacterSkills().toString()); 
		for (Skill skill : charSkillsArr) {
			charSkills.decrementSkillRank(skill, 5);
		}
		System.out.println(chad.getCharacterSkills().toString()); 
		
		Skill[] classSkills = {new Skill("ACROBATICS"), new Skill("CLIMB"), new Skill("CRAFT1"), 
				new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_NATURE"), 
				new Skill("PERCEPTION"), new Skill("RIDE"), new Skill("SURVIVAL"), new Skill("SWIM")};
		
		chad.getCharacterSkills().setClassSkills(classSkills);
		for (Skill skill : charSkillsArr) {
			System.out.println(skill.getName() + ": " + skill.isClassSkill());
		}
	}
	
	@Test
	public void testCharacterFeats () {
		PathfinderCharacter pete = new PathfinderCharacter();
		
		String filePath = "C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterFeatObjects/FeatNames.txt"; 
		String line; 
		ArrayList<String> featNames = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath)); 
			while ((line = reader.readLine()) != null) {
				String featName = line.replace(" ", "_").replace("-", "_").toUpperCase();
				featNames.add(featName);
			}
		}
		catch (Exception ex) {
			System.out.println("Something went wrong");
		}
		for (String featName : featNames) {
			pete.getCharacterFeats().addFeat(new Feat(featName));
		}
		System.out.println(pete.getCharacterFeats().toString());
		System.out.println(pete.getCharacterFeats().getCharacterModifierObject());
	}
	
	@Test
	public void testCharacterClassBarbarian() {
		PathfinderCharacter james = new PathfinderCharacter();
		Barbarian testBarbarianClass = new Barbarian(1); 
		System.out.println(testBarbarianClass.getCharacterModifierObject().toString());
	}

}
