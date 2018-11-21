package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClassTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}

	@FXML private ComboBox<String> classSelectorComboBox;
	@FXML private TextField levelTF;
	@FXML private TextField alignmentRestrictionTF;
	@FXML private TextField hitDieTF;
	@FXML private TextField skillRanksPerLevelTF;
	@FXML private TextArea weaponArmorProficienciesTA;
	@FXML private TextArea classSkillsTA;
	@FXML private ComboBox<String> bondSelectorComboBox;
	@FXML private ComboBox<String> classInformationComboBox;
	@FXML private TextArea classInformationTA;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("Class Tab Controller Set Up!");
		
		classSelectorComboBox.getItems().addAll("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard");
		this.bondSelectorComboBox.setVisible(false);
		this.classInformationComboBox.getItems().addAll("Description", "Role");
	}
	
	@FXML public void classSelected(ActionEvent event) {
		this.bondSelectorComboBox.setVisible(false);
		this.bondSelectorComboBox.getItems().clear();
		
		String characterClassStr = this.classSelectorComboBox.getValue();
		pcViewModel.setCharacterClass(characterClassStr, Integer.parseInt(this.levelTF.getText()));
		
		if (characterClassStr.equals("Druid") || characterClassStr.equals("Wizard")) {
			if (characterClassStr.equals("Druid")) {this.bondSelectorComboBox.getItems().addAll("Animal", "Nature");}
			else {this.bondSelectorComboBox.getItems().addAll("Creature", "Object");}
			
			this.bondSelectorComboBox.setVisible(true);
		}
			
		this.alignmentRestrictionTF.setText(pcViewModel.getAllignmentRestriction());
		this.hitDieTF.setText(Integer.toString(pcViewModel.getHitDie()));
		this.weaponArmorProficienciesTA.setText(pcViewModel.getWeaponAndArmorProficiencies());
		this.skillRanksPerLevelTF.setText(Integer.toString(pcViewModel.getSkillRanksPerLevel()));			
		this.classSkillsTA.setText(classSkillsToString(pcViewModel.getClassSkills()));
		
		//Resetting classInfomrationTA
		this.classInformationComboBox.setValue("Description");
		this.classInformationTA.setText(pcViewModel.getCharacterClass().getDescription());
	}
	
	private String classSkillsToString(Set<Skill> classSkills) {
		StringBuilder classSkillsAsStrBuilder = new StringBuilder();
		for (Skill skill : classSkills) {
			if (skill.toString().contains("1")) {
				classSkillsAsStrBuilder.append(skill.toString().replaceAll("1",  "") + ", ");
			}
			else if (skill.toString().contains("2") || skill.toString().contains("3")) {
				continue;
			}
			else {
				classSkillsAsStrBuilder.append(skill.toString() + ", ");
			}
		}
		return classSkillsAsStrBuilder.toString().substring(0, classSkillsAsStrBuilder.length()-2);
	}
	
	@FXML public void bondSelected(ActionEvent event) {
		
	}
	
	@FXML public void classInformationSelected(ActionEvent event) {
		if (classInformationComboBox.getValue().equals("Description")) {
			this.classInformationTA.setText(pcViewModel.getCharacterClass().getDescription());
		}
		else if (classInformationComboBox.getValue().equals("Role")) {
			this.classInformationTA.setText(pcViewModel.getCharacterClass().getRole());
		}
	}

}
