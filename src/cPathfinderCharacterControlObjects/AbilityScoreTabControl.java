package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import cPathfinderCharacterAbilityScoreObjects.AbilityScore;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class AbilityScoreTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	private int pointsToSpend = 10;
	private Integer[] rolledScores = new Integer[6];
	private Integer[] purchaseableAbilityScores = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
	
	@FXML private Button rollButton;
	@FXML private Button purchaseButton;
	@FXML private Pane rollPane;
	@FXML private Pane purchasePane;
	
	@FXML private TextField strengthModifierTF;
	@FXML private TextField dexterityModifierTF;
	@FXML private TextField constitutionModifierTF;
	@FXML private TextField intelligenceModifierTF;
	@FXML private TextField wisdomModifierTF;
	@FXML private TextField charismaModifierTF;
	
	@FXML private TextField strengthTotalTF;
	@FXML private TextField dexterityTotalTF;
	@FXML private TextField constitutionTotalTF;
	@FXML private TextField intelligenceTotalTF;
	@FXML private TextField wisdomTotalTF;
	@FXML private TextField charismaTotalTF;
	
	@FXML private ComboBox<Integer> strengthScoreCB;
	@FXML private ComboBox<Integer> dexterityScoreCB;
	@FXML private ComboBox<Integer> constitutionScoreCB;
	@FXML private ComboBox<Integer> intelligenceScoreCB;
	@FXML private ComboBox<Integer> wisdomScoreCB;
	@FXML private ComboBox<Integer> charismaScoreCB;
	
	@FXML private TextField strengthRaceTF;
	@FXML private TextField dexterityRaceTF;
	@FXML private TextField constitutionRaceTF;
	@FXML private TextField intelligenceRaceTF;
	@FXML private TextField wisdomRaceTF;
	@FXML private TextField charismaRaceTF;
	
	@FXML private TextField strengthCostTF;
	@FXML private TextField dexterityCostTF;
	@FXML private TextField constitutionCostTF;
	@FXML private TextField intelligenceCostTF;
	@FXML private TextField wisdomCostTF;
	@FXML private TextField charismaCostTF;
	
	@FXML private TextField totalCostTF;
	@FXML private Label	 spentTooManyPointsTF;
	
	@FXML private ComboBox<String> abilitiesCB;
	@FXML private TextArea descriptionTA;
	@FXML private TextArea usesTA;
	
	@FXML private ToggleGroup rollDifficultyToggleGroup;
	@FXML private ToggleGroup campaignTypeToggleGroup;
	
	@FXML private Button rollForScoresButton;
	@FXML private TextField rolledScore0;
	@FXML private TextField rolledScore1;
	@FXML private TextField rolledScore2;
	@FXML private TextField rolledScore3;
	@FXML private TextField rolledScore4;
	@FXML private TextField rolledScore5;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] abilities = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
		
		this.abilitiesCB.getItems().addAll(abilities);
		this.abilitiesCB.setValue("Strength");
		this.descriptionTA.setText(AbilityScore.getDescription(this.abilitiesCB.getValue()));
		this.usesTA.setText(AbilityScore.getApplications(this.abilitiesCB.getValue()));
		
		this.strengthScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.dexterityScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.constitutionScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.intelligenceScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.wisdomScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.charismaScoreCB.getItems().addAll(purchaseableAbilityScores);
		
		this.strengthScoreCB.setValue(10);
		this.dexterityScoreCB.setValue(10);
		this.constitutionScoreCB.setValue(10);
		this.intelligenceScoreCB.setValue(10);
		this.wisdomScoreCB.setValue(10);
		this.charismaScoreCB.setValue(10);
		
		this.strengthCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(strengthScoreCB.getValue())));
		this.dexterityCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(dexterityScoreCB.getValue())));
		this.constitutionCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(constitutionScoreCB.getValue())));
		this.intelligenceCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(intelligenceScoreCB.getValue())));
		this.wisdomCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(wisdomScoreCB.getValue())));
		this.charismaCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(charismaScoreCB.getValue())));
		
		this.totalCostTF.setText(Integer.toString(Integer.parseInt(strengthCostTF.getText()) + Integer.parseInt(dexterityCostTF.getText()) + Integer.parseInt(constitutionCostTF.getText())
				+ Integer.parseInt(intelligenceCostTF.getText()) + Integer.parseInt(wisdomCostTF.getText()) + Integer.parseInt(charismaCostTF.getText())));
		
		this.campaignTypeToggleGroup.selectedToggleProperty().addListener(cl -> { 
	        if (campaignTypeToggleGroup.getSelectedToggle() != null) {
	        	RadioButton rb = (RadioButton) campaignTypeToggleGroup.getSelectedToggle();
	        	this.pointsToSpend = getPointsToSpend(rb.getText());
	        	//System.out.println(this.pointsToSpend);
	        }
		});
		
	}
	
	@FXML public void rollButtonPress(ActionEvent event) {
		this.purchasePane.setVisible(false);
		this.rollPane.setVisible(true);
		
		this.strengthScoreCB.getItems().clear();
		this.dexterityScoreCB.getItems().clear();
		this.constitutionScoreCB.getItems().clear();
		this.intelligenceScoreCB.getItems().clear();
		this.wisdomScoreCB.getItems().clear();
		this.charismaScoreCB.getItems().clear();
		
		this.strengthScoreCB.getItems().add(0);
		this.dexterityScoreCB.getItems().add(0);
		this.constitutionScoreCB.getItems().add(0);
		this.intelligenceScoreCB.getItems().add(0);
		this.wisdomScoreCB.getItems().add(0);
		this.charismaScoreCB.getItems().add(0);
		
		this.strengthScoreCB.getItems().addAll(rolledScores);
		this.dexterityScoreCB.getItems().addAll(rolledScores);
		this.constitutionScoreCB.getItems().addAll(rolledScores);
		this.intelligenceScoreCB.getItems().addAll(rolledScores);
		this.wisdomScoreCB.getItems().addAll(rolledScores);
		this.charismaScoreCB.getItems().addAll(rolledScores);
	}
	@FXML public void purchaseButtonPress(ActionEvent event) {
		this.rollPane.setVisible(false);
		this.purchasePane.setVisible(true);
		
		this.strengthScoreCB.getItems().clear();
		this.dexterityScoreCB.getItems().clear();
		this.constitutionScoreCB.getItems().clear();
		this.intelligenceScoreCB.getItems().clear();
		this.wisdomScoreCB.getItems().clear();
		this.charismaScoreCB.getItems().clear();
		
		this.strengthScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.dexterityScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.constitutionScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.intelligenceScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.wisdomScoreCB.getItems().addAll(purchaseableAbilityScores);
		this.charismaScoreCB.getItems().addAll(purchaseableAbilityScores);
		
		this.strengthScoreCB.setValue(10);
		this.dexterityScoreCB.setValue(10);
		this.constitutionScoreCB.setValue(10);
		this.intelligenceScoreCB.setValue(10);
		this.wisdomScoreCB.setValue(10);
		this.charismaScoreCB.setValue(10);
		
	}
	
	@FXML public void abilitiesCBSelection(ActionEvent event) {
		this.descriptionTA.setText(AbilityScore.getDescription(this.abilitiesCB.getValue()));
		this.usesTA.setText(AbilityScore.getApplications(this.abilitiesCB.getValue()));
	}
	
	private String calculateTotalCost() {
		return Integer.toString(Integer.parseInt(strengthCostTF.getText()) + Integer.parseInt(dexterityCostTF.getText()) + Integer.parseInt(constitutionCostTF.getText())
		+ Integer.parseInt(intelligenceCostTF.getText()) + Integer.parseInt(wisdomCostTF.getText()) + Integer.parseInt(charismaCostTF.getText()));
	}
	
	@FXML public void strengthScoreSelect(ActionEvent event) {
		if (this.strengthScoreCB.getValue() != null) {
			this.strengthTotalTF.setText(Integer.toString(this.strengthScoreCB.getValue() + Integer.parseInt(this.strengthRaceTF.getText())));
			this.strengthCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(strengthScoreCB.getValue())));
			this.strengthModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.strengthTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
		
	}
	@FXML public void dexterityScoreSelect(ActionEvent event) {
		if (this.dexterityScoreCB.getValue() != null) {
			this.dexterityTotalTF.setText(Integer.toString(this.dexterityScoreCB.getValue() + Integer.parseInt(this.dexterityRaceTF.getText())));
			this.dexterityCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(dexterityScoreCB.getValue())));
			this.dexterityModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.dexterityTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
	}
	@FXML public void constitutionScoreSelect(ActionEvent event) {
		if (this.constitutionScoreCB.getValue() != null) {
			this.constitutionTotalTF.setText(Integer.toString(this.constitutionScoreCB.getValue() + Integer.parseInt(this.constitutionRaceTF.getText())));
			this.constitutionCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(constitutionScoreCB.getValue())));
			this.constitutionModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.constitutionTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
	}
	@FXML public void intelligenceScoreSelect(ActionEvent event) {
		if (this.intelligenceScoreCB.getValue() != null) {
			this.intelligenceTotalTF.setText(Integer.toString(this.intelligenceScoreCB.getValue() + Integer.parseInt(this.intelligenceRaceTF.getText())));
			this.intelligenceCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(intelligenceScoreCB.getValue())));
			this.intelligenceModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.intelligenceTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
	}
	@FXML public void wisdomScoreSelect(ActionEvent event) {
		if (this.wisdomScoreCB.getValue() != null) {
			this.wisdomTotalTF.setText(Integer.toString(this.wisdomScoreCB.getValue() + Integer.parseInt(this.wisdomRaceTF.getText())));
			this.wisdomCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(wisdomScoreCB.getValue())));
			this.wisdomModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.wisdomTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
	}
	@FXML public void charismaScoreSelect(ActionEvent event) {
		if (this.strengthScoreCB.getValue() != null) {
			this.charismaTotalTF.setText(Integer.toString(this.charismaScoreCB.getValue() + Integer.parseInt(this.charismaRaceTF.getText())));
			this.charismaCostTF.setText(Integer.toString(AbilityScore.abilityScoreCost(charismaScoreCB.getValue())));
			this.charismaModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.charismaTotalTF.getText()))));
			this.totalCostTF.setText(calculateTotalCost());	
			if (Integer.parseInt(this.totalCostTF.getText()) > this.pointsToSpend) {
				this.spentTooManyPointsTF.setText("You've spent too many points.  Reassign your points to cost less than the selected budget.");
			}
			else {
				this.spentTooManyPointsTF.setText("");
			}
		}
	}
	
	@FXML public void rollForScoresButtonPress(ActionEvent event) {
		RadioButton rb = (RadioButton) this.rollDifficultyToggleGroup.getSelectedToggle();
		Integer[] scores = AbilityScore.abilityScoresGenerator(rb.getText());
		Arrays.sort(scores);
		this.rolledScores = scores;
		
		rolledScore0.setText(Integer.toString(scores[0]));
		rolledScore1.setText(Integer.toString(scores[1]));
		rolledScore2.setText(Integer.toString(scores[2]));
		rolledScore3.setText(Integer.toString(scores[3]));
		rolledScore4.setText(Integer.toString(scores[4]));
		rolledScore5.setText(Integer.toString(scores[5]));
		
		this.strengthScoreCB.getItems().clear();
		this.dexterityScoreCB.getItems().clear();
		this.constitutionScoreCB.getItems().clear();
		this.intelligenceScoreCB.getItems().clear();
		this.wisdomScoreCB.getItems().clear();
		this.charismaScoreCB.getItems().clear();

		this.strengthScoreCB.getItems().add(0);
		this.dexterityScoreCB.getItems().add(0);
		this.constitutionScoreCB.getItems().add(0);
		this.intelligenceScoreCB.getItems().add(0);
		this.wisdomScoreCB.getItems().add(0);
		this.charismaScoreCB.getItems().add(0);
		
		this.strengthScoreCB.getItems().addAll(scores);
		this.dexterityScoreCB.getItems().addAll(scores);
		this.constitutionScoreCB.getItems().addAll(scores);
		this.intelligenceScoreCB.getItems().addAll(scores);
		this.wisdomScoreCB.getItems().addAll(scores);
		this.charismaScoreCB.getItems().addAll(scores);
		
		this.strengthTotalTF.setText("");
		this.dexterityTotalTF.setText("");
		this.constitutionTotalTF.setText("");
		this.intelligenceTotalTF.setText("");
		this.wisdomTotalTF.setText("");
		this.charismaTotalTF.setText("");
		
		this.strengthModifierTF.setText("");
		this.dexterityModifierTF.setText("");
		this.constitutionModifierTF.setText("");
		this.intelligenceModifierTF.setText("");
		this.wisdomModifierTF.setText("");
		this.charismaModifierTF.setText("");
	
	}

	
	public int getPointsToSpend(String radioButtonText) {
		if (radioButtonText.equals("Low Fantasy (10 pts)")) {
			return 10;
		}
		else if (radioButtonText.equals("Standard Fantasy (15 pts)")) {
			return 15;
		}
		else if (radioButtonText.equals("High Fantasy (20 pts)")) {
			return 20;
		}
		else {
			return 25;
		}
	}
	
	
	public void intializeRaceTF() {
		this.strengthRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[0]));
		this.dexterityRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[1]));
		this.constitutionRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[2]));
		this.intelligenceRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[3]));
		this.wisdomRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[4]));
		this.charismaRaceTF.setText(Integer.toString(pcViewModel.getRace().getAbilityModifiers()[5]));
		
		this.strengthTotalTF.setText(Integer.toString(this.strengthScoreCB.getValue() + Integer.parseInt(this.strengthRaceTF.getText())));
		this.dexterityTotalTF.setText(Integer.toString(this.dexterityScoreCB.getValue() + Integer.parseInt(this.dexterityRaceTF.getText())));
		this.constitutionTotalTF.setText(Integer.toString(this.constitutionScoreCB.getValue() + Integer.parseInt(this.constitutionRaceTF.getText())));
		this.intelligenceTotalTF.setText(Integer.toString(this.intelligenceScoreCB.getValue() + Integer.parseInt(this.intelligenceRaceTF.getText())));
		this.wisdomTotalTF.setText(Integer.toString(this.wisdomScoreCB.getValue() + Integer.parseInt(this.wisdomRaceTF.getText())));
		this.charismaTotalTF.setText(Integer.toString(this.charismaScoreCB.getValue() + Integer.parseInt(this.charismaRaceTF.getText())));
		
		this.strengthModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.strengthTotalTF.getText()))));
		this.dexterityModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.dexterityTotalTF.getText()))));
		this.constitutionModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.constitutionTotalTF.getText()))));
		this.intelligenceModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.intelligenceTotalTF.getText()))));
		this.wisdomModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.wisdomTotalTF.getText()))));
		this.charismaModifierTF.setText(Integer.toString(AbilityScore.abilityScoreToModifier(Integer.parseInt(this.charismaTotalTF.getText()))));
	}

}
