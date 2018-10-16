package cPathfinderCharacterFeatObjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import cPathfinderCharacterObjects.ClassFeature;
import cPathfinderCharacterSkillObjects.Skill;

public class FeatPrerequisite {
	//Static Variables:
	protected static final String[] featNames;
	static {
		String[] outputStringArr = new String[176];
		String filePath = "FeatsChartAsText.txt"; 
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int lineCounter = 0;
			while ((line = reader.readLine()) != null ) {
				outputStringArr[lineCounter] = line;
				lineCounter++;
			}
			reader.close();
		}
		catch (Exception ex) {
			System.out.println("Failed to load featNames");
		}
		featNames = outputStringArr;
	}
	
	//Instance Variables:
	private String featPrerequisiteAsText;
	private ArrayList<Feat> requiredFeats;
	private int[] requiredAbilityPoints;
	private int requiredAttackBonus;
	private ClassFeature requiredClassFeature;
	private int requiredCasterLevel;
	private Map<Skill, Integer> requiredSkills; //TODO: When there are multiple required skills, sometimes you need all, sometimes you only need one.  Need to figure out a way to handle 'and' and 'or' relations.
	private int requiredFighterLevel;
	private int requiredWizardLevel;
	
	
	//Constructors:
	FeatPrerequisite() {
		setRequiredFeats();
		setRequiredAbilityPoints();
		setRequiredAttackBonus();
		setRequiredClassFeature();
		setRequiredCasterLevel();
		setRequiredClassLevel();
		setRequiredSkills();
	}
	
	//Methods:
	public void setFeatPrerequisiteText(String prerequisiteText) {this.featPrerequisiteAsText = prerequisiteText;}
	
	private void setRequiredFeats() {
		for (String featName : featNames) {
			if (this.featPrerequisiteAsText.contains(featName)) {
				String updatedFeatName = featName.replace(" ", "_").replace("-", "_").toUpperCase(); 
				this.requiredFeats.add(new Feat(updatedFeatName));
			}
			
		}
	}
	private void setRequiredAbilityPoints() {
		this.requiredAbilityPoints = new int[6];
		if (this.featPrerequisiteAsText.contains("Str")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Str");
				String strReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int strReqInt = Integer.parseInt(strReq);
				this.requiredAbilityPoints[0] = strReqInt;
			}
			catch (NumberFormatException e) {}
		}
		if (this.featPrerequisiteAsText.contains("Dex")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Dex");
				String dexReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int dexReqInt = Integer.parseInt(dexReq);
				this.requiredAbilityPoints[1] = dexReqInt;
			}
			catch (NumberFormatException e) {}
		}
		if (this.featPrerequisiteAsText.contains("Con")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Con");
				String conReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int conReqInt = Integer.parseInt(conReq);
				this.requiredAbilityPoints[2] = conReqInt;
			}
			catch (NumberFormatException e) {}
		}
		if (this.featPrerequisiteAsText.contains("Int")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Int");
				String intReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int intReqInt = Integer.parseInt(intReq);
				this.requiredAbilityPoints[3] = intReqInt;
			}
			catch (NumberFormatException e) {}
		}
		if (this.featPrerequisiteAsText.contains("Wis")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Wis");
				String wisReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int wisReqInt = Integer.parseInt(wisReq);
				this.requiredAbilityPoints[4] = wisReqInt;
			}
			catch (NumberFormatException e) {}
		}
		if (this.featPrerequisiteAsText.contains("Cha")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Cha");
				String chaReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 5));
				int chaReqInt = Integer.parseInt(chaReq);
				this.requiredAbilityPoints[5] = chaReqInt;
			}
			catch (NumberFormatException e) {}
		}
	}
	private void setRequiredAttackBonus() { //must be space after base attack bonus number in this.featPrerequisiteAsText
		this.requiredAttackBonus = 0;
		if (this.featPrerequisiteAsText.contains("Base attack bonus")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Base attack bonus");
				String ABReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 19)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 20));
				ABReq.replace(" ", "");
				int ABReqInt = Integer.parseInt(ABReq);
				this.requiredAttackBonus = ABReqInt;
			}
		catch (NumberFormatException e) {}
		}
		
		if (this.featPrerequisiteAsText.contains("base attack bonus")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("base attack bonus");
				String ABReq = Character.toString(this.featPrerequisiteAsText.charAt(index + 19)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 20));
				ABReq.replace(" ", "");
				int ABReqInt = Integer.parseInt(ABReq);
				this.requiredAttackBonus = ABReqInt;
			}
			catch(NumberFormatException e) {}
		}
	}
	private void setRequiredClassFeature() {
		if (this.featPrerequisiteAsText.contains("class feature")) {
			int index = this.featPrerequisiteAsText.indexOf("class feature");
			String classFeature = this.featPrerequisiteAsText.substring(0, index-1);
			classFeature = classFeature.replace(" ", "_").replace("-", "_").toUpperCase();
			this.requiredClassFeature = new ClassFeature(classFeature.replace(" ", "_").toUpperCase());
		}
	}
	private void setRequiredCasterLevel() {
		this.requiredCasterLevel = 0;
		if (this.featPrerequisiteAsText.contains("Caster level")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("Caster level");
				String casterLevel = Character.toString(this.featPrerequisiteAsText.charAt(index + 13)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 14));
				casterLevel.replace(" ", "");
				int casterLevelInt = Integer.parseInt(casterLevel);
				this.requiredCasterLevel = casterLevelInt;
			}
		catch (NumberFormatException e) {}
		}
		
		if (this.featPrerequisiteAsText.contains("caster level")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("caster level");
				String casterLevel = Character.toString(this.featPrerequisiteAsText.charAt(index + 13)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index + 14));
				casterLevel.replace(" ", "");
				int casterLevelInt = Integer.parseInt(casterLevel);
				this.requiredCasterLevel = casterLevelInt;
			}
			catch(NumberFormatException e) {}
		}
	}
	private void setRequiredClassLevel() {
		this.requiredFighterLevel = 0;
		this.requiredWizardLevel = 0;
		if (this.featPrerequisiteAsText.contains("-level fighter")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("-level fighter");
				String classLevel = Character.toString(this.featPrerequisiteAsText.charAt(index - 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index - 3));
				classLevel.replace(" ", "");
				int classLevelInt = Integer.parseInt(classLevel);
				this.requiredFighterLevel = classLevelInt;
			}
		catch (NumberFormatException e) {}
		}
		
		if (this.featPrerequisiteAsText.contains("-level Wizard")) {
			try {
				int index = this.featPrerequisiteAsText.indexOf("-level Wizard");
				String classLevel = Character.toString(this.featPrerequisiteAsText.charAt(index - 4)) + 
						Character.toString(this.featPrerequisiteAsText.charAt(index - 3));
				classLevel.replace(" ", "");
				int classLevelInt = Integer.parseInt(classLevel);
				this.requiredWizardLevel = classLevelInt;
			}
			catch(NumberFormatException e) {}
		}
	}
	private void setRequiredSkills() {
		for (String skillName: Skill.skillNames) {
			if (this.featPrerequisiteAsText.contains(skillName)) {
				try {
					int index = this.featPrerequisiteAsText.indexOf(skillName);
					String skillRequirement = Character.toString(this.featPrerequisiteAsText.charAt(index - 3)) + 
							Character.toString(this.featPrerequisiteAsText.charAt(index - 2));
					skillRequirement.replace(" ", "");
					int skillRequirementInt = Integer.parseInt(skillRequirement);
					String formattedSkillName = skillName.replace(" ", "_").toUpperCase();
					this.requiredSkills.put(new Skill(formattedSkillName), skillRequirementInt);
				}
			catch (NumberFormatException e) {}
			}
		}
	}

	public ArrayList<Feat> getRequiredFeats() {return this.requiredFeats;}
	public int[] getRequiredAbilityPoints() {return this.requiredAbilityPoints;}
	public int getRequiredAttackBonus() {return this.requiredAttackBonus;}
	public ClassFeature getRequiredClassFeature() {return this.requiredClassFeature;}
	public int getRequiredCasterLevel() {return this.requiredCasterLevel;}
	public Map<Skill, Integer> getRequiredSkills() {return this.requiredSkills;}
	public int getRequiredFighterLevel() {return this.requiredFighterLevel;}
	public int getRequiredWizardLevel() {return this.requiredWizardLevel;}
}
