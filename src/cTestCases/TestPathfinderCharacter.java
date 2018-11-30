package cTestCases;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import cPathfinderCharacterAbilityScoreObjects.AbilityScore;
import cPathfinderCharacterClassObjects.AnimalCompanion;
import cPathfinderCharacterClassObjects.ArcaneSchool;
import cPathfinderCharacterClassObjects.Barbarian;
import cPathfinderCharacterClassObjects.Bard;
import cPathfinderCharacterClassObjects.Bloodline;
import cPathfinderCharacterClassObjects.Cleric;
import cPathfinderCharacterClassObjects.ClericDomain;
import cPathfinderCharacterClassObjects.Druid;
import cPathfinderCharacterClassObjects.Fighter;
import cPathfinderCharacterClassObjects.Monk;
import cPathfinderCharacterClassObjects.Paladin;
import cPathfinderCharacterClassObjects.Ranger;
import cPathfinderCharacterClassObjects.Rogue;
import cPathfinderCharacterClassObjects.Sorcerer;
import cPathfinderCharacterClassObjects.Wizard;
import cPathfinderCharacterFeatObjects.CharacterFeats;
import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterItems.Armor;
import cPathfinderCharacterItems.Items;
import cPathfinderCharacterObjects.Alignment;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterRaceObjects.Dwarf;
import cPathfinderCharacterRaceObjects.Elf;
import cPathfinderCharacterRaceObjects.Gnome;
import cPathfinderCharacterRaceObjects.HalfElf;
import cPathfinderCharacterRaceObjects.HalfOrc;
import cPathfinderCharacterRaceObjects.Halfling;
import cPathfinderCharacterRaceObjects.Human;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterSpellObjects.Spell;
import javafx.collections.transformation.SortedList;
import cPathfinderCharacterItems.Weapon;

public class TestPathfinderCharacter {
	
	@Test
	public void testCharacterRaces() {
		PathfinderCharacter dwarfCharacter = new PathfinderCharacter();
		PathfinderCharacter elfCharacter = new PathfinderCharacter();
		PathfinderCharacter gnomeCharacter = new PathfinderCharacter();
		PathfinderCharacter halfElfCharacter = new PathfinderCharacter();
		PathfinderCharacter halfOrcCharacter = new PathfinderCharacter();
		PathfinderCharacter humanCharacter = new PathfinderCharacter();
		PathfinderCharacter halflingCharacter = new PathfinderCharacter();
		
		//TODO: Update this test
		
		dwarfCharacter.setRace(new Dwarf());
		System.out.println(dwarfCharacter.getRace().modificationsToString());
		elfCharacter.setRace(new Elf());
		System.out.println(elfCharacter.getRace().modificationsToString());
		gnomeCharacter.setRace(new Gnome());
		System.out.println(gnomeCharacter.getRace().modificationsToString());
		halfElfCharacter.setRace(new HalfElf());
		System.out.println(halfElfCharacter.getRace().modificationsToString());
		halfOrcCharacter.setRace(new HalfOrc());
		System.out.println(halfOrcCharacter.getRace().modificationsToString());
		humanCharacter.setRace(new Human());
		System.out.println(humanCharacter.getRace().modificationsToString());
		halflingCharacter.setRace(new Halfling());
		System.out.println(halflingCharacter.getRace().modificationsToString());
		
		System.out.println("Race Descriptions: " + Race.getAllRaces().toString());
		
		for(String race : Race.getAllRaces()) {
			System.out.println("Overview: " + Race.getOverview(race));
			System.out.println("Physical Description: " + Race.getPhysicalDescription(race));
			System.out.println("Society: " + Race.getSociety(race));
			System.out.println("Relations: " + Race.getRelations(race));
			System.out.println("Alignment and Religion: " + Race.getAlignmentAndReligion(race));
			System.out.println("Adventurers: " + Race.getAdventurers(race));
		}
		
		
	}

	@Test
	public void testCharacterSkills() {
		PathfinderCharacter chad = new PathfinderCharacter();
		CharacterSkills charSkills = chad.getCharacterSkills(); 
		System.out.println(chad.getCharacterSkills().toString()); 
		
		SortedList<Skill> charSkillsArr = charSkills.getCharacterSkillsList();
		for (Skill skill : charSkillsArr) {
			charSkills.incrementSkillRanks(skill, 4);
		}
		System.out.println(chad.getCharacterSkills().toString()); 
		for (Skill skill : charSkillsArr) {
			charSkills.incrementSkillRanks(skill, -5);
		}
		System.out.println(chad.getCharacterSkills().toString()); 
		
		CharacterSkills cs = new CharacterSkills();
		for (Skill skill : cs.getCharacterSkillsList()) {
			System.out.println(skill.toString() + ": " + skill.isTrainedOnly());
		}
		
		Set<Skill> classSkills = new HashSet<Skill>(Arrays.asList(new Skill("ACROBATICS"), new Skill("CLIMB"), new Skill("CRAFT1"), 
				new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("HANDLE_ANIMAL"), new Skill("INTIMIDATE"), new Skill("KNOWLEDGE_NATURE"), 
				new Skill("PERCEPTION"), new Skill("RIDE"), new Skill("SURVIVAL"), new Skill("SWIM")));
		
		chad.getCharacterSkills().setClassSkills(classSkills);
		for (Skill skill : charSkillsArr) {
			System.out.println(skill.getName() + ": " + skill.getAbilityModifier() + skill.getPageInCoreRuleBook() + skill.getDescription() + skill.isTrainedOnly());
		}
	}
	
	@Test
	public void testCharacterFeats () {
		PathfinderCharacter pete = new PathfinderCharacter();
		CharacterFeats charFeats = new CharacterFeats();
		
		String filePath = "src/cPathfinderCharacterFeatObjects/FeatNames.txt"; 
		String line; 
		ArrayList<String> featNames = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath)); 
			while ((line = reader.readLine()) != null) {
				String featName = line.replace(" ", "_").replace("-", "_").toUpperCase();
				featNames.add(featName);
			}
			reader.close();
		}
		catch (Exception ex) {
			System.out.println("Something went wrong");
		}
		for (String featName : featNames) {
			String formattedFeatName = Feat.formatFeatName(featName);
			Feat feat = new Feat(formattedFeatName);
			System.out.println(feat.getFeatName() + feat.getTags().toString());
			charFeats.addFeat(feat);
		}
		System.out.println(charFeats.modificationsToString());
		
		System.out.println(Feat.getFeatNames());
	}
	
	@Test
	public void testSpells() {
		ArrayList<Spell> spells = new ArrayList<Spell>();
		System.out.println(Spell.spellNames);
		System.out.println(Spell.spellDescriptionsMap);
		for (String spellName : Spell.spellNames) {
			Spell spell = new Spell(spellName.split("%")[0], spellName.split("%")[1]);
			System.out.println(spell.toString());
			System.out.println(spell.getSpellClass());
		}
	}
	
	@Test
	public void testAlignments() {
		System.out.println(Alignment.CHAOTICEVIL.getDescription());
		System.out.println(Alignment.CHAOTICNEUTRAL.getExamples());
	}
	
	@Test
	public void testCharacterClassBarbarian() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Barbarian testBarbarianClass = new Barbarian(1); 
		System.out.println(testBarbarianClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassBard() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Bard testBardClass = new Bard(1); 
		System.out.println(testBardClass.modificationsToString());
		//System.out.println(Bard.bardSpells);
	}
	
	@Test
	public void testCharacterClassCleric() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Cleric testClericClass = new Cleric(1); 
		
		testClericClass.setDomain1(new ClericDomain("Air")); 
		testClericClass.setDomain2(new ClericDomain("Chaos"));
		
		System.out.println(testClericClass.getDomain1().toString());
		System.out.println(testClericClass.getDomain2().toString());
		
		Set<String> domainNames = ClericDomain.clericDomainsMap.keySet();
		for (String domainName : domainNames) {
			ClericDomain domain = new ClericDomain(domainName);
			System.out.println(domain.toString());
		}
		
		System.out.println(testClericClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassDruid() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Druid testdruidClass = new Druid(1); 
		System.out.println(testdruidClass.modificationsToString());
	}
	
	@Test
	public void testAnimalCompanion() {
		AnimalCompanion ac = new AnimalCompanion(1);
		Set<Integer> keys = AnimalCompanion.levelDecidedStatsMap.keySet();
		for (Integer key : keys) {
			System.out.println(key + ": " + Arrays.toString(AnimalCompanion.levelDecidedStatsMap.get(key)));
		}
		Set<String> keys2 = AnimalCompanion.animalCompanionFeaturesMap.keySet();
		for (String key : keys2) {
			System.out.println(AnimalCompanion.animalCompanionFeaturesMap.get(key).toString());
		}
	}
	
	@Test
	public void testCharacterClassFighter() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Fighter testFighterClass = new Fighter(1); 
		System.out.println(testFighterClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassMonk() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Monk testMonkClass = new Monk(1); 
		System.out.println(testMonkClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassPaladin() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Paladin testPaladinClass = new Paladin(1); 
		System.out.println(testPaladinClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassRanger() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Ranger testRangerClass = new Ranger(1); 
		System.out.println(testRangerClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassRogue() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Rogue testRogueClass = new Rogue(1); 
		System.out.println(testRogueClass.modificationsToString());
	}
	
	@Test
	public void testCharacterClassSorcerer() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Sorcerer testSorcererClass = new Sorcerer(1); 
		System.out.println(testSorcererClass.modificationsToString());
		
		testSorcererClass.setBloodline(new Bloodline("Aberrant"), 20); 
		System.out.println(testSorcererClass.modificationsToString());
	}
	
	@Test
	public void testBloodlines() {
		String[] bloodlineNames = {"Aberrant", "Abyssal", "Arcane", "Celestial", "Destined", "Draconic", "Elemental", "Fey", "Infernal", "Undead"};
		System.out.println(Bloodline.bloodlineMap.keySet());
		
		
		for (String name : bloodlineNames) {
			Bloodline testBloodline = new Bloodline(name);
			System.out.println(testBloodline.toString());
		}
	}
	
	@Test
	public void testCharacterClassWizard() {
		PathfinderCharacter pc = new PathfinderCharacter();
		Wizard testWizardClass = new Wizard(1); 
		System.out.println(testWizardClass.modificationsToString());
	}
	
	@Test
	public void testArcaneSchools() {
		String[] arcaneSchoolNames = {"Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation", "Universalist"};
		
		for (String name : arcaneSchoolNames) {
			ArcaneSchool testArcaneSchool = new ArcaneSchool(name);
			System.out.println(testArcaneSchool.toString());
		}
	}
	
	@Test
	public void testAbilityScoreGenerator() {
		List<Integer> randomNums = new ArrayList<Integer>(); 
		for (int counter = 0; counter < 20; counter++) {
			randomNums.add((int) Math.floor((Math.random()*6)+1));
		}
		Collections.sort(randomNums);
		System.out.println(randomNums.toString());
		System.out.println(Arrays.toString(AbilityScore.abilityScoresGenerator("Standard")));
		System.out.println(Arrays.toString(AbilityScore.abilityScoresGenerator("Classic")));
		System.out.println(Arrays.toString(AbilityScore.abilityScoresGenerator("Heroic")));
		
	}
	
	@Test
	public void testWeapons() {
		for (Weapon weapon : Items.getWeapons()) {
			System.out.println(weapon.toString());
		}
	}
	
	@Test
	public void testArmor() {
		for (Armor armor : Items.getArmor()) {
			System.out.println(armor.toString());
		}
	}
}
