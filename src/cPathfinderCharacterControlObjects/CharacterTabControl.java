package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ResourceBundle;

import cPathfinderCharacterObjects.Alignment;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CharacterTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	@FXML private TextField playerNameField;		
	@FXML private TextField characterNameField;		
	@FXML private ToggleGroup genderToggleGroup;		
	@FXML private ComboBox<String> ageComboBox;		
	@FXML private ComboBox<String> heightComboBox;		
	@FXML private ComboBox<String> weightComboBox;
	@FXML private TextField hairColorField;		
	@FXML private TextField eyeColorField;		
	@FXML private TextField deityField;		
	@FXML private TextField homelandField;
	
	@FXML private TextField yourAlignmentTF;
	@FXML private TextArea alignmentDescriptionTA;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.ageComboBox.getItems().addAll("Young Adult", "Middle Age", "Old");
		this.heightComboBox.getItems().addAll("Short", "Medium", "Tall");
		this.weightComboBox.getItems().addAll("Light", "Medium", "Heavy");
	}
	
	@FXML public void saveButtonpress(ActionEvent event) {
		if (this.playerNameField.getText() != null) {pcViewModel.setPlayerName(playerNameField.getText());}
		if (this.characterNameField.getText() != null) {pcViewModel.setCharacterName(characterNameField.getText());}
		pcViewModel.setGender(((RadioButton) this.genderToggleGroup.getSelectedToggle()).getText());
		if (this.ageComboBox.getValue() != null) {this.pcViewModel.setAge(this.ageComboBox.getValue());}
		if (this.heightComboBox.getValue() != null) {this.pcViewModel.setHeight(this.heightComboBox.getValue());}
		if (this.weightComboBox.getValue() != null) {this.pcViewModel.setWeight(this.weightComboBox.getValue());}
		if (this.hairColorField.getText() != null) {pcViewModel.setHairColor(hairColorField.getText());}
		if (this.eyeColorField.getText() != null) {pcViewModel.setEyeColor(eyeColorField.getText());}
		if (this.deityField.getText() != null) {pcViewModel.setDeity(deityField.getText());}
		if (this.homelandField.getText() != null) {pcViewModel.setHomeland(homelandField.getText());}
		if (!(this.yourAlignmentTF.getText().equals(""))) {pcViewModel.setAlignment(Alignment.valueOf(this.yourAlignmentTF.getText().replace(" ", "").toUpperCase()));}
	}
	
	@FXML public void chaoticGoodButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Chaotic Good");
		this.alignmentDescriptionTA.setText(Alignment.CHAOTICGOOD.getDescription());
	}
	
	@FXML public void neutralGoodButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Neutral Good");
		this.alignmentDescriptionTA.setText(Alignment.NEUTRALGOOD.getDescription());
	}
	
	@FXML public void lawfulGoodButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Lawful Good");
		this.alignmentDescriptionTA.setText(Alignment.LAWFULGOOD.getDescription());
	}
	
	@FXML public void chaoticNeutralButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Chaotic Neutral");
		this.alignmentDescriptionTA.setText(Alignment.CHAOTICNEUTRAL.getDescription());
	}
	
	@FXML public void trueNeutralButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("True Neutral");
		this.alignmentDescriptionTA.setText(Alignment.TRUENEUTRAL.getDescription());
	}
	
	@FXML public void lawfulNeutralButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Lawful Neutral");
		this.alignmentDescriptionTA.setText(Alignment.LAWFULNEUTRAL.getDescription());
	}
	
	@FXML public void chaoticEvilButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Chaotic Evil");
		this.alignmentDescriptionTA.setText(Alignment.CHAOTICEVIL.getDescription());
	}
	
	@FXML public void neutralEvilButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Neutral Evil");
		this.alignmentDescriptionTA.setText(Alignment.NEUTRALEVIL.getDescription());
	}
	
	@FXML public void lawfulEvilButtonPress(ActionEvent event) {
		this.yourAlignmentTF.setText("Lawful Evil");
		this.alignmentDescriptionTA.setText(Alignment.LAWFULEVIL.getDescription());
	}

}
