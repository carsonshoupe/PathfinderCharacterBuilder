package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterRaceObjects.RacialTrait;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class MainPageControl implements Initializable {
	
	//Character Tab:
	@FXML
	private TextField playerNameField;
	
	@FXML
	private Label playerNameLabel;
	
	@FXML
	private TextField characterNamefield;
	
	@FXML
	private ToggleGroup genderToggleGroup;
	
	@FXML
	private ComboBox<String> ageComboBox;
	
	@FXML
	private ComboBox<String> heightComboBox;
	
	@FXML
	private ComboBox<String> weightComboBox;

	@FXML
	private TextField hairColorField;
	
	@FXML
	private TextField eyeColorField;
	
	@FXML
	private TextField deityField;
	
	@FXML
	private TextField homelandField;
	
	//Race Tab:
	
	@FXML
	private ComboBox<String> raceSelectorComboBox = new ComboBox<String>();
	
	@FXML
	private ComboBox<String> raceInformationComboBox = new ComboBox<String>();
	
	@FXML
	private TextArea raceInformationTextArea = new TextArea();
	
	@FXML
	private Pane racialTraitsPane;
	
	@FXML
	private TextArea abilityModifiersTextArea = new TextArea();
	
	@FXML
	private Pane abilityModifierPane = new Pane();
	
	@FXML
	private ToggleGroup abilityModifierToggleGroup = new ToggleGroup();
	
	@FXML
	private TextField sizeTextField = new TextField();
	
	@FXML
	private TextField visionTextField = new TextField();
	
	@FXML
	private TextField familiarWeaponsTextField = new TextField();
	
	@FXML
	private TextField languagesTextField = new TextField();
	
	@FXML
	private ComboBox<String> racialTraitsComboBox = new ComboBox<String>();
	
	@FXML
	private TextArea racialTraitsTextArea = new TextArea();
	
	@FXML
	private ImageView raceImage = new ImageView();
	
	//Skill Tab:
	@FXML
	private TableView<Skill> skillsTable;
	
	@FXML
	private TableColumn<Skill, Boolean> trainedOnlyCol;
	
	@FXML 
	private TableColumn<Skill, String> skillNameCol;
	
	@FXML
	private TableColumn<Skill, String> abilityModifierCol;
	


	public void initialize(URL arg0, ResourceBundle arg1) {
		//Character Tab:
		this.ageComboBox.getItems().addAll("Young Adult", "Middle Age", "Old");
		this.heightComboBox.getItems().addAll("Short", "Medium", "Tall");
		this.weightComboBox.getItems().addAll("Light", "Medium", "Heavy");
		
		//Race Tab:
		this.racialTraitsPane.setVisible(false);
		this.raceSelectorComboBox.getItems().addAll(Race.getAllRaces());
		this.raceInformationComboBox.getItems().addAll("Overview", "Physical Description", "Society", "Relations", "Alignment and Religion", "Adventurers");
		this.abilityModifierPane.setVisible(false);
		
		//Class Tab:
		
		//Ability Modifier Tab:
		
		//Skills Tab:
		CharacterSkills cs = new CharacterSkills();
		ObservableList<Skill> skills = cs.getCharacterSkillsList(); 
		this.skillsTable.setItems(skills);
		cs.getCharacterSkillsList().comparatorProperty().bind(this.skillsTable.comparatorProperty());

		this.skillNameCol.setCellValueFactory(new PropertyValueFactory<Skill, String>("skillName"));
		this.trainedOnlyCol.setCellValueFactory(new Callback<CellDataFeatures<Skill, Boolean>, ObservableValue<Boolean>>() {
		    @Override
		    public ObservableValue<Boolean> call(CellDataFeatures<Skill, Boolean> param)
		    {   
		        return param.getValue().skillTrainedOnlyProperty();
		    }   
		});
		trainedOnlyCol.setCellFactory(CheckBoxTableCell.forTableColumn(trainedOnlyCol));
		this.abilityModifierCol.setCellValueFactory(new PropertyValueFactory<Skill, String>("skillAbilityModifier"));
		

		
	}
	
	
	
	public void raceSelected(ActionEvent event) {
		//Update RaceInfo Combo Box
		if (raceInformationComboBox.getValue() == null) {
			raceInformationComboBox.setValue("Overview");
		}
		else {
			raceInformationTextArea.setText(Race.getRaceInformation(this.raceSelectorComboBox.getValue(), this.raceInformationComboBox.getValue()));
		}
		
		//Update and Display RacialTraits Pane
		this.racialTraitsPane.setVisible(true);
		Race race = Race.instantiateRace(this.raceSelectorComboBox.getValue());
		this.abilityModifiersTextArea.setText(race.getAbilityModifierText() + "\n" + race.abilityModifiersToString());
		this.sizeTextField.setText(race.getSize().toString());
		this.visionTextField.setText(race.getVision());
		if (Arrays.toString(race.getFamiliarWeapons()).equals("[]")) {
			this.familiarWeaponsTextField.setText("None");
		}
		else {
			this.familiarWeaponsTextField.setText(Arrays.toString(race.getFamiliarWeapons()).substring(1, Arrays.toString(race.getFamiliarWeapons()).length()-1));
		}
		this.languagesTextField.setText(Arrays.toString(race.getKnownLanguages()).substring(1, Arrays.toString(race.getKnownLanguages()).length()-1));
		
		 //Update and Display AbilityModifiers Pane
		if (raceSelectorComboBox.getValue().equals("Half-Elf") || raceSelectorComboBox.getValue().equals("Half-Orc") || raceSelectorComboBox.getValue().equals("Human")) {
			abilityModifierPane.setVisible(true);
		}
		else {
			abilityModifierPane.setVisible(false);
			if (abilityModifierToggleGroup.getSelectedToggle() != null) {
				abilityModifierToggleGroup.getSelectedToggle().setSelected(false);
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
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/DwarfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Elf")) {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/ElfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Gnome")) {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/GnomeImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Half-Elf")) {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/HalfElfImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Half-Orc")) {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/HalfOrcImage.png");
			this.raceImage.setImage(image);
		}
		else if (raceSelectorComboBox.getValue().equals("Halfling")) {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/HalflingImage.png");
			this.raceImage.setImage(image);
		}
		else {
			Image image = new Image("file:C:/Users/carso/Documents/GitHub/PathfinderCharacterBuilder/src/cPathfinderCharacterViewObjects/HumanImage.png");
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
