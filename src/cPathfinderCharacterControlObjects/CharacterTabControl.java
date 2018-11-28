package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ResourceBundle;

import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
		//Age, Height, and Weight will be configured after they select a race
		if (this.hairColorField.getText() != null) {pcViewModel.setHairColor(hairColorField.getText());}
		if (this.eyeColorField.getText() != null) {pcViewModel.setEyeColor(eyeColorField.getText());}
		if (this.deityField.getText() != null) {pcViewModel.setDeity(deityField.getText());}
		if (this.homelandField.getText() != null) {pcViewModel.setHomeland(homelandField.getText());}
	}

}
