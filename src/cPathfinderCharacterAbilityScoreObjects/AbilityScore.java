package cPathfinderCharacterAbilityScoreObjects;

import java.util.Arrays;

public class AbilityScore {
	public static String getDescription(String ability) {
		String outputString = "";
		if (ability.equals("Strength")) {
			outputString = "Strength measures muscle and physical power. This ability is important for those who engage in hand-to-hand (or "
					+ "“melee”) combat, such as fighters, monks, paladins, and some rangers. Strength also sets the maximum amount "
					+ "of weight your character can carry. A character with a Strength score of 0 is too weak to move in any way and "
					+ "is unconscious. Some creatures do not possess a Strength	score and have no modifier at all to Strength-based skills or checks.";
		}
		else if (ability.equals("Dexterity")) {
			outputString = "Dexterity measures agility, ref lexes, and balance. This ability is the most important one for rogues, but it’s also "
					+ "useful for characters who wear light or medium armor or no armor at all. This ability is vital for characters seeking "
					+ "to excel with ranged weapons, such as the bow or sling. A character with a Dexterity score of 0 is incapable of moving "
					+ "and is effectively immobile (but not unconscious).";
		}
		else if (ability.equals("Constitution")) {
			outputString = "Constitution represents your character’s health and	stamina. A Constitution bonus increases a character’s "
					+ "hit points, so the ability is important for all classes. Some creatures, such as undead and constructs, do "
					+ "not have a Constitution score. Their modif ier is +0 for any Constitution-based checks. A character with a "
					+ "Constitution score of 0 is dead.\n"
					+ "If a character’s Constitution score changes enough to alter his or her Constitution modifier, the character’s hit"
					+ "points also increase or decrease accordingly.";
		}
		else if (ability.equals("Intelligence")) {
			outputString = "Intelligence determines how well your character learns and reasons. This ability is important for wizards because "
					+ "it affects their spellcasting ability in many ways. Creatures of animal-level instinct have Intelligence scores of 1 or 2. "
					+ "Any creature capable of understanding speech has a score of at least 3. A character with an Intelligence score of 0 is "
					+ "comatose. Some creatures do not possess an Intelligence score. Their modifier is +0 for any Intelligence-based skills or checks.";
		}
		else if (ability.equals("Wisdom")) {
			outputString = "Wisdom describes a character’s willpower, common sense, awareness, and intuition. Wisdom is the most important "
					+ "ability for clerics and druids, and it is also important for paladins and rangers. If you want your character to have "
					+ "acute senses, put a high score in Wisdom. Every creature has a Wisdom score. A character with a Wisdom score of 0 "
					+ "is incapable of rational thought and is unconscious.\n"
					+ "A wizard gains bonus spells based on his Intelligence score. The minimum Intelligence score needed to cast a"
					+ "wizard spell is 10 + the spell’s level.";
		}
		else if (ability.equals("Charisma")) {
			outputString = "Charisma measures a character’s personality, personal magnetism, ability to lead, and appearance. It is the most "
					+ "important ability for paladins, sorcerers, and bards. It is also important for clerics, since it affects their ability "
					+ "to channel energy. For undead creatures, Charisma is a measure of their unnatural “lifeforce.” Every creature has "
					+ "a Charisma score. A character with a Charisma score of 0 is not able to exert himself in any way and is unconscious.\n"
					+ "Bards, paladins, and sorcerers gain a number of bonus spells based on their Charisma scores. The minimum	Charisma score "
					+ "needed to cast a bard, paladin, or sorcerer spell is 10 + the spell’s level.";
		}
		else {}
		return outputString;
	}
	
	public static String getApplications(String ability) {
		String outputString = "";
		if (ability.equals("Strength")) {
			outputString = "• Melee attack rolls.\n"
					+ "• Damage rolls when using a melee weapon or a thrown	weapon, including a sling. (Exceptions: Off-hand attacks receive "
					+ "only half the character’s Strength bonus, while two-handed attacks receive 1–1/2 times the Strength bonus. A "
					+ "Strength penalty, but not a bonus, applies to attacks made with a bow that is not a composite bow.)\n"
					+ "• Climb and Swim checks.\n"
					+ "• Strength checks (for breaking down doors and the like).";
		}
		else if (ability.equals("Dexterity")) {
			outputString = "• Ranged attack rolls, including those for attacks made with bows, crossbows, throwing axes, and many ranged "
					+ "spell attacks like scorching ray or searing light.\n"
					+ "• Armor Class (AC), provided that the character can react to the attack.\n"
					+ "• Reflex saving throws, for avoiding fireballs and other	attacks that you can escape by moving quickly.\n"
					+ "• Acrobatics, Disable Device, Escape Artist, Fly, Ride, Sleight of Hand, and Stealth checks.";
		}
		else if (ability.equals("Constitution")) {
			outputString = "• Each roll of a Hit Die (though a penalty can never drop a result below 1—that is, a character always gains at least 1"
					+ "hit point each time he advances in level).\n"
					+ "• Fortitude saving throws, for resisting poison, disease, and similar threats.";
		}
		else if (ability.equals("Intelligence")) {
			outputString = "• The number of bonus languages your character knows at the start of the game. These are in addition to any starting "
					+ "racial languages and Common. If you have a penalty, you can still read and speak your racial languages unless your "
					+ "Intelligence is lower than 3.\n"
					+ "• The number of skill points gained each level, though your character always gets at least 1 skill point per level.\n"
					+ "• Appraise, Craft, Knowledge, Linguistics, and Spellcraft checks.";
		}
		else if (ability.equals("Wisdom")) {
			outputString = "• Will saving throws (for negating the effects of charm person and other spells).\n"
					+ "• Heal, Perception, Profession, Sense Motive, and Survival checks.";
		}
		else if (ability.equals("Charisma")) {
			outputString = "• Bluff, Diplomacy, Disguise, Handle Animal, Intimidate, Perform, and Use Magic Device checks.\n"
					+ "• Checks that represent attempts to inf luence others.\n"
					+ "• Channel energy DCs for clerics and paladins attempting to harm undead foes.";
		}
		else {}
		return outputString;
	}
	
	public static int abilityScoreToModifier(int abilityScore) {return (int) Math.floor((abilityScore-10)/2.0);}
	
	public static Integer abilityScoreCost(int abilityScore) {
		if (abilityScore < 7) {return -10;}
		else if (abilityScore == 7) {return -4;}
		else if (abilityScore == 8) {return -2;}
		else if (abilityScore == 9) {return -1;}		
		else if (abilityScore == 10) {return 0;}
		else if (abilityScore == 11) {return 1;}
		else if (abilityScore == 12) {return 2;}
		else if (abilityScore == 13) {return 3;}
		else if (abilityScore == 14) {return 5;}
		else if (abilityScore == 15) {return 7;}	
		else if (abilityScore == 16) {return 10;}
		else if (abilityScore == 17) {return 13;}
		else if (abilityScore == 18) {return 17;}
		else {return null;}
	}
	
	public static Integer abilityScoreGenerator(String type) {
		if (type.equals("Standard")) {
			int[] rolls = {(int) Math.floor((Math.random()*6)+1), (int) Math.floor((Math.random()*6)+1), (int) Math.floor((Math.random()*6)+1), (int) Math.floor((Math.random()*6)+1)};
			Arrays.sort(rolls);
			//System.out.println("Rolls: " + Arrays.toString(rolls));
			return rolls[1] + rolls[2] + rolls[3];
		}
		else if (type.equals("Classic")) {
			return (int) Math.floor((Math.random()*6)+1) + (int) Math.floor((Math.random()*6)+1) + (int) Math.floor((Math.random()*6)+1);
		}
		else if (type.equals("Heroic")) {
			return (int) Math.floor((Math.random()*6)+1) + (int) Math.floor((Math.random()*6)+1) + 6;
		}
		else {
			return null;
		}
	}
	
	public static Integer[] abilityScoresGenerator(String type) {
		Integer[] outputArr = new Integer[6];
		for (int counter = 0; counter < 6; counter++) {
			outputArr[counter] = AbilityScore.abilityScoreGenerator(type);
		}
		return outputArr;
	}

}
