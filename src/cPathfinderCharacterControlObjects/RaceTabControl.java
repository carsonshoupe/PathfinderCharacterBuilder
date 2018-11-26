package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import cPathfinderCharacterAbilityScoreObjects.AbilityScore;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterRaceObjects.RacialTrait;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RaceTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel; 
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}

	@FXML private ComboBox<String> raceSelectorComboBox = new ComboBox<String>();
	@FXML private ComboBox<String> raceInformationComboBox = new ComboBox<String>();		
	@FXML private TextArea raceInformationTextArea = new TextArea();		
	@FXML private Pane racialTraitsPane;		
	@FXML private TextArea abilityModifiersTextArea = new TextArea();		
	@FXML private Pane abilityModifierPane = new Pane();		
	@FXML private ToggleGroup abilityModifierToggleGroup = new ToggleGroup();	
	@FXML private Toggle strengthRadioButton;
	@FXML private TextField sizeTextField = new TextField();		
	@FXML private TextField visionTextField = new TextField();		
	@FXML private TextField familiarWeaponsTextField = new TextField();		
	@FXML private TextField languagesTextField = new TextField();		
	@FXML private ComboBox<String> racialTraitsComboBox = new ComboBox<String>();		
	@FXML private TextArea racialTraitsTextArea = new TextArea();
	@FXML private ImageView raceImage = new ImageView();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("RaceTabController set up!");
		
		this.racialTraitsPane.setVisible(false);
		this.raceSelectorComboBox.getItems().addAll(Race.getAllRaces());
		this.raceInformationComboBox.getItems().addAll("Overview", "Physical Description", "Society", "Relations", "Alignment and Religion", "Adventurers");
		this.abilityModifierPane.setVisible(false);

	}
	
	@FXML public void saveButtonPress (ActionEvent event) {
		String raceName = this.raceSelectorComboBox.getValue();
		if (raceName != null) {
			this.pcViewModel.setRace(raceName);
			if (raceName.equals("Half-Elf") || raceName.equals("Half-Orc") || raceName.equals("Human")) {
				String abilityModifier = ((RadioButton) this.abilityModifierToggleGroup.getSelectedToggle()).getText();
				this.pcViewModel.getRace().incrementAbilityModifier(AbilityScore.abilityToAbilityInteger(abilityModifier));
			}
			System.out.println(this.pcViewModel.getRace().toString());
			System.out.println(Arrays.toString(this.pcViewModel.getRace().getAbilityModifiers()));
		}
	}
	
	public void raceSelected(ActionEvent event) {
		//Update RaceInfo Combo Box
		if (raceInformationComboBox.getValue() == null) {raceInformationComboBox.setValue("Overview");}
		else {raceInformationTextArea.setText(Race.getRaceInformation(this.raceSelectorComboBox.getValue(), this.raceInformationComboBox.getValue()));}
		
		//Update and Display RacialTraits Pane
		this.racialTraitsPane.setVisible(true);
		Race race = Race.stringToRace(this.raceSelectorComboBox.getValue());
		this.abilityModifiersTextArea.setText(race.getAbilityModifierText() + "\n" + race.abilityModifiersToString());
		this.sizeTextField.setText(race.getSize().toString());
		this.visionTextField.setText(race.getVision());
		
		if (Arrays.toString(race.getFamiliarWeapons()).equals("[]")) {this.familiarWeaponsTextField.setText("None");}
		else {this.familiarWeaponsTextField.setText(Arrays.toString(race.getFamiliarWeapons()).substring(1, Arrays.toString(race.getFamiliarWeapons()).length()-1));}
		
		this.languagesTextField.setText(Arrays.toString(race.getKnownLanguages()).substring(1, Arrays.toString(race.getKnownLanguages()).length()-1));
		
		 //Update and Display AbilityModifiers Pane
		if (raceSelectorComboBox.getValue().equals("Half-Elf") || raceSelectorComboBox.getValue().equals("Half-Orc") || raceSelectorComboBox.getValue().equals("Human")) {abilityModifierPane.setVisible(true);}
		else {
			abilityModifierPane.setVisible(false);
			if (abilityModifierToggleGroup.getSelectedToggle() != null) {
				abilityModifierToggleGroup.selectToggle(this.strengthRadioButton);
			}
		}
		
		 //Update and Display RacialTraits (Features)
		this.racialTraitsComboBox.getItems().clear();
		Set<String> racialTraitNames = new HashSet<String>();
		for (RacialTrait racialTrait : race.getRacialTraits()) {
			racialTraitNames.add(racialTrait.getName());
		}
		this.racialTraitsComboBox.getItems().addAll(racialTraitNames);
		
			
		//Update Image
		this.raceImage.preserveRatioProperty();
		if (raceSelectorComboBox.getValue().equals("Dwarf")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/DwarfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Elf")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/ElfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Gnome")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/GnomeImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Half-Elf")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/HalfElfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Half-Orc")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/HalfOrcImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Halfling")) {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/HalflingImage.png");
			this.raceImage.setImage(image);
		}
		else {
			Image image = new Image("file:src/cPathfinderCharacterViewObjects/HumanImage.png");
			this.raceImage.setImage(image);
		}
		this.raceImage.fitHeightProperty();
	}
	
	public void raceInformationSelected(ActionEvent event) {
		if (raceSelectorComboBox.getValue() == null) {
			raceInformationTextArea.setText("Select a race to see information about that race.");
		}
		else {
			raceInformationTextArea.setText(Race.getRaceInformation(this.raceSelectorComboBox.getValue(), this.raceInformationComboBox.getValue()));
		}
	}
	
	public void updateRacialTraitsTextArea(ActionEvent event) {
		String racialTraitName = this.racialTraitsComboBox.getValue().toUpperCase().replaceAll(" ", "_"); 
		RacialTrait rt = new RacialTrait(racialTraitName); 
		this.racialTraitsTextArea.setText(rt.getDescription());
	}
	

}
