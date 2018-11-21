package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import cPathfinderCharacterClassObjects.Bard;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterRaceObjects.Dwarf;
import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterRaceObjects.RacialTrait;
import cPathfinderCharacterSkillObjects.CharacterSkills;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import cPathfinderCharacterViewObjects.CharacterBuilderMainPageView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

public class MainPageControl implements Initializable {
	
	//ViewModel
	PathfinderCharacterViewModel pcViewModel;
	
	//FXML Controllers 
	@FXML private TestTabControl testTabController;
	@FXML private AbilityScoreTabControl abilityScoreTabController;
	@FXML private CharacterTabControl characterTabController;
	@FXML private RaceTabControl raceTabController;
	@FXML private SkillsTabControl skillsTabFieldController;
	@FXML private ClassTabControl classTabFieldController;
	
	//FXML Tabs
	@FXML Tab skillsTab;
	
	//FXML Tab Loaders
	@FXML
	void loadSkillsTab(Event e) {
		if (skillsTab.isSelected()) {
			this.skillsTabFieldController.handleSkillsTabSelected();
		}
	}
	
	@FXML
	public void loadTestTab(Event e) {
		testTabController.updateName();
	}
	
	@FXML public void loadAbilityScoreTab(Event e) {
		abilityScoreTabController.intializeRaceTF();
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {
		this.pcViewModel = pcViewModel;
		this.testTabController.setPcViewModel(pcViewModel);
		this.abilityScoreTabController.setPcViewModel(pcViewModel);
		this.characterTabController.setPcViewModel(pcViewModel);
		this.raceTabController.setPcViewModel(pcViewModel);
		this.skillsTabFieldController.setPcViewModel(pcViewModel);
		this.classTabFieldController.setPcViewModel(pcViewModel);
	}
	
	
	//Skill Methods:

	
	

	

}
