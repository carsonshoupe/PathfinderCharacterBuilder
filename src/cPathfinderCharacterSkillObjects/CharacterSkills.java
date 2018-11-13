package cPathfinderCharacterSkillObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;


public class CharacterSkills {
	//Instance Variables: 	
	private Skill[] characterSkills = {new Skill("ACROBATICS"), new Skill("APPRAISE"), new Skill("BLUFF"), new Skill("CLIMB"),
			new Skill("CRAFT1"), new Skill("CRAFT2"), new Skill("CRAFT3"), new Skill("DIPLOMACY"), new Skill("DISABLE_DEVICE"), 
			new Skill("ESCAPE_ARTIST"), new Skill("FLY"), new Skill("HANDLE_ANIMAL"), new Skill("HEAL"), new Skill("INTIMIDATE"), 
			new Skill("KNOWLEDGE_ARCANA"), new Skill("KNOWLEDGE_DUNGEONEERING"), new Skill("KNOWLEDGE_ENGINEERING"),
			new Skill("KNOWLEDGE_GEOGRAPHY"), new Skill("KNOWLEDGE_HISTORY"), new Skill("KNOWLEDGE_LOCAL"), new Skill("KNOWLEDGE_NATURE"), 
			new Skill("KNOWLEDGE_NOBILITY"), new Skill("KNOWLEDGE_PLANES"), new Skill("KNOWLEDGE_RELIGION"), new Skill("LINGUISTICS"),
			new Skill("PERCEPTION"), new Skill("PERFORM1"), new Skill("PERFORM2"), new Skill("PROFESSION1"), new Skill("PROFESSION2"),
			new Skill("RIDE"), new Skill("SENSE_MOTIVE"), new Skill("SLIGHT_OF_HAND"), new Skill("SPELLCRAFT"), new Skill("STEALTH"),
			new Skill("SURVIVAL"), new Skill("SWIM"), new Skill("USE_MAGICAL_DEVICE")};
	
	private SortedList<Skill> characterSkillsList = new SortedList<Skill>(FXCollections.observableArrayList(Arrays.asList(this.characterSkills))); //TODO: Add Comparator
	
	private Map<Skill, Integer> skillRanksMap = new HashMap<Skill, Integer>();
	private Map<Skill, Boolean> classSkillsMap = new HashMap<Skill, Boolean>();
	
	//Constructors: 
	public CharacterSkills() {
		for (Skill skill : characterSkills) {
			skillRanksMap.put(skill, 0);
			classSkillsMap.put(skill, false);
		}
	}
	
	
	//Methods: 
	public Skill getAcrobatics() {return this.characterSkills[0];}
	public Skill getAppraise() {return this.characterSkills[1];}
	public Skill getBluff() {return this.characterSkills[2];}
	public Skill getClimb() {return this.characterSkills[3];}
	public Skill getCraft1() {return this.characterSkills[4];}
	public Skill getCraft2() {return this.characterSkills[5];}
	public Skill getCraft3() {return this.characterSkills[6];}
	public Skill getDiplomacy() {return this.characterSkills[7];}
	public Skill getDisableDevice() {return this.characterSkills[8];}
	public Skill getDisguise() {return this.characterSkills[9];}
	public Skill getEscapeArtists() {return this.characterSkills[10];}
	public Skill getFly() {return this.characterSkills[11];}
	public Skill getHandleAnimal() {return this.characterSkills[12];}
	public Skill getHeal() {return this.characterSkills[13];}
	public Skill getIntimidate() {return this.characterSkills[14];}
	public Skill getKnowledgeArcana() {return this.characterSkills[15];}
	public Skill getKnolwedgeDungeoneering() {return this.characterSkills[16];}
	public Skill getKnolwedgeEngineering() {return this.characterSkills[17];}
	public Skill getKnolwedgeGeography() {return this.characterSkills[18];}
	public Skill getKnolwedgeHistory() {return this.characterSkills[19];}
	public Skill getKnolwedgeLocal() {return this.characterSkills[20];}
	public Skill getKnolwedgeNature() {return this.characterSkills[21];}
	public Skill getKnolwedgeNobility() {return this.characterSkills[22];}
	public Skill getKnolwedgePlanes() {return this.characterSkills[23];}
	public Skill getknolwedgeReligion() {return this.characterSkills[24];}
	public Skill getLinguistics() {return this.characterSkills[25];}
	public Skill getPerception() {return this.characterSkills[26];}
	public Skill getPerform1() {return this.characterSkills[27];}
	public Skill getPerform2() {return this.characterSkills[28];}
	public Skill getProfession1() {return this.characterSkills[29];}
	public Skill getProfession2() {return this.characterSkills[30];}
	public Skill getRide() {return this.characterSkills[31];}
	public Skill getSenseMotive() {return this.characterSkills[32];}
	public Skill getSlightOfHand() {return this.characterSkills[33];}
	public Skill getSpellcraft() {return this.characterSkills[34];}
	public Skill getStealth() {return this.characterSkills[35];}
	public Skill getSurvival() {return this.characterSkills[36];}
	public Skill getSwim() {return this.characterSkills[37];}
	public Skill getUseMagicalDevice() {return this.characterSkills[38];}
	
	public Skill[] getCharacterSkills() {return this.characterSkills;}
	public SortedList<Skill> getCharacterSkillsList() {return this.characterSkillsList;}
	
	public Set<Skill> getClassSkills() {
		Set<Skill> classSkills = new HashSet<Skill>();
		Set<Skill> classSkillKeys = getClassSkillsMap().keySet();
		for (Skill key : classSkillKeys) {
			if (this.classSkillsMap.get(key) == true) {
				classSkills.add(key);
			}
		}
		return classSkills;
	}
	public Map<Skill, Integer> getSkillRanks() {return this.skillRanksMap;}
	public Map<Skill, Boolean> getClassSkillsMap() {return this.classSkillsMap;}
	public boolean isClassSkill(Skill skill) {return classSkillsMap.get(skill);}
	
	public void incrementSkillRank(Skill skill, int value) {skillRanksMap.put(skill, skillRanksMap.get(skill) + value);}
	
	public void setClassSkills(Set<Skill> classSkills) {
		for (Skill characterSkill : this.characterSkills) {
			if (classSkills.contains(characterSkill)) {
				this.classSkillsMap.put(characterSkill, true);
			}
		}
	}
	
	public int getCharacterSkillBonus(Skill skill) {
		if (skillRanksMap.get(skill) == 0) {
			return 0;
		}
		else {
			int outputBonus = skillRanksMap.get(skill);
			if (this.isClassSkill(skill)) {
				outputBonus += 3;
			}
			return outputBonus;
		}
	}
	
	@Override
	public String toString() {
		String outputString = "";
		for (Skill skill : characterSkills) {
			outputString = outputString + skill.toString() + ": " + this.getSkillRanks().get(skill) + "\n";
		}
		return outputString;
	}
	
	@Override
	public Object clone() {
		CharacterSkills outputCharacterSkills = new CharacterSkills(); 
		for (Skill skill : outputCharacterSkills.getCharacterSkills()) {
			outputCharacterSkills.getSkillRanks().put(skill, this.getSkillRanks().get(skill));
			outputCharacterSkills.getClassSkillsMap().put(skill, this.getClassSkillsMap().get(skill));
		}
		return outputCharacterSkills;
	}
}
