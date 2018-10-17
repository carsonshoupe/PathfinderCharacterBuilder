package cPathfinderCharacterFeatObjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import cPathfinderCharacterObjects.CharacterModifierObject;
import cPathfinderCharacterSkillObjects.Skill;

public class CharacterFeats {
	//Instance Variables:
	protected ArrayList<Feat> characterFeats = new ArrayList<Feat>();
	protected CharacterModifierObject modifierObject = new CharacterModifierObject();
	
	//Constructors:
	
	//Methods:
	public ArrayList<Feat> getFeats() {return this.characterFeats;}
	public CharacterModifierObject getCharacterModifierObject() {return this.modifierObject;}
	
	public void addFeat(Feat feat) {
		this.characterFeats.add(feat);
		if (feat.shouldUpdateCharacterSheet()) {
			Map<String, String> featUpdateInfo = feat.getInfoToUpdateCharacterSheet();
			Set<String> keys = featUpdateInfo.keySet();
			for(String key : keys) {
				if (key.charAt(0) != '*') {
					this.modifierObject.addSkillRanks(new Skill(key), Integer.parseInt(featUpdateInfo.get(key)));
				}
				if (key.equals("*AC")) {
					this.modifierObject.incrementAcBonus();
				}
				if (key.equals("*SPEED") ) {
					this.modifierObject.incrementSpeedBonus(5);
				}
				if (key.equals("*FORTITUDE_SAVE")) {
					this.modifierObject.incrementFortitudeSaveBonus();
				}
				if (key.equals("*WILL_SAVE")) {
					this.modifierObject.incrementWillSaveBonus();
				}
				if (key.equals("*REFLEX_SAVE")) {
					this.modifierObject.incrementReflexSaveBonus();
				}
				if (key.equals("*INITIATIVE")) {
					this.modifierObject.incrementInitiativeBonus(4);
				}
			}
		}
		else {
			this.modifierObject.addFeatDescription(feat.getFeatName().replace("_", " ") + ": " + feat.getBenefit());
			
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
	
	
	

}
