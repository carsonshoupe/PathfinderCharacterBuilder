package cPathfinderCharacterFeatObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cPathfinderCharacterObjects.CharacterModifier;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterSkillObjects.Skill;

public class CharacterFeats implements CharacterModifier {
	//Instance Variables:
	protected ArrayList<Feat> characterFeats = new ArrayList<Feat>();
	protected Map<Skill, Integer> skillRanksToAdd = new HashMap<Skill, Integer>();
	protected int fortitudeSaveBonus = 0;
	protected int reflexSaveBonus = 0;
	protected int willSaveBonus = 0;
	protected int bonusSkillRanks = 0;
	protected int acBonus = 0;
	protected int speedBonus = 0;
	protected int initiativeBonus = 0;
	protected ArrayList<String> featDescriptionsToAdd = new ArrayList<String>();
	
	//Constructors:
	
	//Methods:
	public ArrayList<Feat> getFeats() {return this.characterFeats;}
	public ArrayList<String> getFeatDescriptions() {return this.featDescriptionsToAdd;}
	public Map<Skill, Integer> getSkillRanks() {return this.skillRanksToAdd;}
	
	public void addFeat(Feat feat) {
		this.characterFeats.add(feat);
		if (feat.shouldUpdateCharacterSheet()) {
			Map<String, String> featUpdateInfo = feat.getInfoToUpdateCharacterSheet();
			Set<String> keys = featUpdateInfo.keySet();
			for(String key : keys) {
				if (key.charAt(0) != '*') {
					this.skillRanksToAdd.put(new Skill(key), Integer.parseInt(featUpdateInfo.get(key)));
				}
				if (key.equals("*AC")) {
					this.acBonus++;
				}
				if (key.equals("*SPEED") ) {
					this.speedBonus += 5;
				}
				if (key.equals("*FORTITUDE_SAVE")) {
					this.fortitudeSaveBonus += 2;
				}
				if (key.equals("*WILL_SAVE")) {
					this.willSaveBonus += 2;
				}
				if (key.equals("*REFLEX_SAVE")) {
					this.reflexSaveBonus += 2;
				}
				if (key.equals("*INITIATIVE")) {
					this.initiativeBonus += 4;
				}
			}
		}
		else {
			this.featDescriptionsToAdd.add(feat.getFeatName().replace("_", " ") + ": " + feat.getBenefit());
		}
	}
	
	@Override 
	public String toString() {
		String outputString = "";
		for (Feat feat : this.characterFeats) {
			outputString += feat.getFeatName() + " ";
		}
		return outputString;
	}
	
	public PathfinderCharacter updateCharacter(PathfinderCharacter pathfinderCharacter) {
		PathfinderCharacter outputCharacter = pathfinderCharacter.clone();
		
		Set<Skill> skillRanksToAddKeys = skillRanksToAdd.keySet();
		for (Skill key : skillRanksToAddKeys) {
			outputCharacter.getCharacterSkills().incrementSkillRank(key, skillRanksToAdd.get(key));
		}
		
		outputCharacter.incrementFortitudeSaveBonus(this.fortitudeSaveBonus);
		outputCharacter.incrementReflexSaveBonus(this.reflexSaveBonus);
		outputCharacter.incrementWillSaveBonus(this.willSaveBonus);
		
		outputCharacter.incrementAcBonus(this.acBonus);
		
		outputCharacter.incrementSpeedBonus(this.speedBonus);
		
		for (String featDescription : this.featDescriptionsToAdd) {
			outputCharacter.getFeatDescriptions().add(featDescription);
		}
		return outputCharacter;
	}

	public String modificationsToString() {
		String outputString = "Skill to Add: " + this.getSkillRanks().toString() + "\n"
			+ "Saving Throws Bonus: " + this.fortitudeSaveBonus + ":" + this.reflexSaveBonus + ":" + this.willSaveBonus + "\n"
			+ "AC Bonus: " + this.acBonus + "\n"
			+ "Speed Bonus: " + this.speedBonus + "\n" 
			+ "Initiative Bonus: " + this.initiativeBonus + "\n";
		
		String featDescriptions = "Feat Descriptions: \n";
		for (String featDescription : this.getFeatDescriptions()) {
			featDescriptions += (featDescription + "\n"); 
		}
		outputString += featDescriptions;
		
		// TODO Auto-generated method stub
		return outputString;
	}
	
	
	

}
