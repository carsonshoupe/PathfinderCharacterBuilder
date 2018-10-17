package cPathfinderCharacterSkillObjects;

import java.util.Arrays;

public class CharacterSkills {
	//Instance Variables: 	
	private Skill acrobatics = new Skill("ACROBATICS");
	private Skill appraise = new Skill("APPRAISE");
	private Skill bluff = new Skill("BLUFF");
	private Skill climb = new Skill("CLIMB");
	private Skill craft1 = new Skill("CRAFT1");
	private Skill craft2 = new Skill("CRAFT2");
	private Skill craft3 = new Skill("CRAFT3");
	private Skill diplomacy = new Skill("DIPLOMACY");
	private Skill disableDevice = new Skill("DISABLE_DEVICE");
	private Skill disguise = new Skill("DISGUISE");
	private Skill escapeArtist = new Skill("ESCAPE_ARTIST");
	private Skill fly = new Skill("FLY");
	private Skill handleAnimal = new Skill("HANDLE_ANIMAL");
	private Skill heal = new Skill("HEAL");
	private Skill intimidate = new Skill("INTIMIDATE");
	private Skill knowledgeArcana = new Skill("KNOWLEDGE_ARCANA"); 
	private Skill knowledgeDungeoneering = new Skill("KNOWLEDGE_DUNGEONEERING");
	private Skill knowledgeEngineering = new Skill("KNOWLEDGE_ENGINEERING");
	private Skill knowledgeGeography = new Skill("KNOWLEDGE_GEOGRAPHY");
	private Skill knowledgeHistory = new Skill("KNOWLEDGE_HISTORY");
	private Skill knowledgeLocal = new Skill("KNOWLEDGE_LOCAL");
	private Skill knowledgeNature = new Skill("KNOWLEDGE_NATURE");
	private Skill knowledgeNobility = new Skill("KNOWLEDGE_NOBILITY");
	private Skill knowledgePlanes = new Skill("KNOWLEDGE_PLANES");
	private Skill knowledgeReligion = new Skill("KNOWLEDGE_RELIGION");
	private Skill linguistics = new Skill("LINGUISTICS");
	private Skill perception = new Skill("PERCEPTION");
	private Skill perform1 = new Skill("PERFORM1");
	private Skill perform2 = new Skill("PERFORM2");
	private Skill profession1 = new Skill("PROFESSION1");
	private Skill profession2 = new Skill("PROFESSION2");
	private Skill ride = new Skill("RIDE");
	private Skill senseMotive = new Skill("SENSE_MOTIVE");
	private Skill slightOfHand = new Skill("SLIGHT_OF_HAND");
	private Skill spellcraft = new Skill("SPELLCRAFT");
	private Skill stealth = new Skill("STEALTH");
	private Skill survival = new Skill("SURVIVAL");
	private Skill swim = new Skill("SWIM");
	private Skill useMagicalDevice = new Skill("USE_MAGICAL_DEVICE");
	
	private Skill[] characterSkillsArr = {this.acrobatics, this.appraise, this.bluff, this.climb, this.craft1,
			this.craft2, this.craft3, this.diplomacy, this.disableDevice, this.disguise, this.escapeArtist, 
			this.fly, this.handleAnimal, this.heal, this.intimidate, this.knowledgeArcana, this.knowledgeDungeoneering, 
			this.knowledgeEngineering, this.knowledgeGeography, this.knowledgeHistory, this.knowledgeLocal, this.knowledgeNature, 
			this.knowledgeNobility, this.knowledgePlanes, this.knowledgeReligion, this.linguistics, this.perception,
			this.perform1, this.perform2, this.profession1, this.profession2, this.ride, this.senseMotive, this.slightOfHand,
			this.spellcraft, this.stealth, this.survival, this.swim, this.useMagicalDevice};
	
	//Constructors: 
	public CharacterSkills() {
	}
	
	
	//Methods: 
	public Skill getAcrobatics() {return this.acrobatics;}
	public Skill getAppraise() {return this.appraise;}
	public Skill getBluff() {return this.bluff;}
	public Skill getClimb() {return this.climb;}
	public Skill getCraft1() {return this.craft1;}
	public Skill getCraft2() {return this.craft2;}
	public Skill getCraft3() {return this.craft3;}
	public Skill getDiplomacy() {return this.diplomacy;}
	public Skill getDisableDevice() {return this.disableDevice;}
	public Skill getDisguise() {return this.disguise;}
	public Skill getEscapeArtists() {return this.escapeArtist;}
	public Skill getFly() {return this.fly;}
	public Skill getHandleAnimal() {return this.handleAnimal;}
	public Skill getHeal() {return this.heal;}
	public Skill getIntimidate() {return this.intimidate;}
	public Skill getKnowledgeArcana() {return this.knowledgeArcana;}
	public Skill getKnolwedgeDungeoneering() {return this.knowledgeDungeoneering;}
	public Skill getKnolwedgeEngineering() {return this.knowledgeEngineering;}
	public Skill getKnolwedgeGeography() {return this.knowledgeGeography;}
	public Skill getKnolwedgeHistory() {return this.knowledgeHistory;}
	public Skill getKnolwedgeLocal() {return this.knowledgeLocal;}
	public Skill getKnolwedgeNature() {return this.knowledgeNature;}
	public Skill getKnolwedgeNobility() {return this.knowledgeNobility;}
	public Skill getKnolwedgePlanes() {return this.knowledgePlanes;}
	public Skill getknolwedgeReligion() {return this.knowledgeReligion;}
	public Skill getLinguistics() {return this.linguistics;}
	public Skill getPerception() {return this.perception;}
	public Skill getPerform1() {return this.perform1;}
	public Skill getPerform2() {return this.perform2;}
	public Skill getProfession1() {return this.profession1;}
	public Skill getProfession2() {return this.profession2;}
	public Skill getRide() {return this.ride;}
	public Skill getSenseMotive() {return this.senseMotive;}
	public Skill getSlightOfHand() {return this.slightOfHand;}
	public Skill getSpellcraft() {return this.spellcraft;}
	public Skill getStealth() {return this.stealth;}
	public Skill getSurvival() {return this.survival;}
	public Skill getSwim() {return this.swim;}
	public Skill getUseMagicalDevice() {return this.useMagicalDevice;}
	
	public Skill[] getCharacterSkillsArr() {return this.characterSkillsArr;}
	
	public void incrementSkillRank(Skill skill) {skill.incrementSkillRank();}
	public void incrementSkillRank(Skill skill, int value) {skill.incrementSkillRank(value);}
	public void decrementSkillRank(Skill skill) {skill.decrementSkillRank();}
	public void decrementSkillRank(Skill skill, int value) {skill.decrementSkillRank(value);}
	
	public void setClassSkills(Skill[] classSkills) {
		for (Skill classSkill : classSkills) {
			for (Skill characterSkill : this.characterSkillsArr) {
				if (classSkill.equals(characterSkill)) {
					characterSkill.setClassSkill(); 
					break;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String outputString = "";
		for (Skill skill : characterSkillsArr) {
			outputString = outputString + skill.toString() + "\n";
		}
		return outputString;
	}
}
