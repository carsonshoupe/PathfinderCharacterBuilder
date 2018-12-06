package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ResourceBundle;

import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class SkillsTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	@FXML private TableView<Skill> skillsTable;	
	@FXML TableColumn<Skill, Boolean> classSkillCol;	
	@FXML private TableColumn<Skill, Boolean> trainedOnlyCol;	
	@FXML private TableColumn<Skill, String> skillNameCol;	
	@FXML private TableColumn<Skill, Integer> abilityModifierTypeCol;	
	@FXML private TableColumn<Skill, String> abilityModifierValueCol;	
	@FXML private TableColumn<Skill, Integer> skillRanksCol;	
	@FXML private TableColumn<Skill, Integer> miscSkillModCol;	
	@FXML private TableColumn<Skill, Integer> totalSkillBonusCol;	
	@FXML private Button selectSkillsButton;		
	@FXML private TextArea skillDescriptionTextArea;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("SkillsTabController set up!");

	}
	
	@FXML 
	public void getSkillDescription(Event e) {
		Skill skill = skillsTable.getSelectionModel().selectedItemProperty().get();
		if (skill != null) {
			skillDescriptionTextArea.setText(skill.getDescription());
		}
	};
	
	public void handleSkillsTabSelected() {
		//add skills to table
		this.skillsTable.setItems(pcViewModel.getCharacterSkills());
		
		//set comparator
		pcViewModel.getCharacterSkills().comparatorProperty().bind(this.skillsTable.comparatorProperty());
		
		//Name Col
		this.skillNameCol.setCellValueFactory(new PropertyValueFactory<Skill, String>("name"));
		
		//Trained Only Col
		this.trainedOnlyCol.setCellValueFactory(ov -> {
			return ov.getValue().trainedOnlyProperty();  
		});
		trainedOnlyCol.setCellFactory(CheckBoxTableCell.forTableColumn(trainedOnlyCol));
		
		//Ability Modifier Cols
		this.abilityModifierTypeCol.setCellValueFactory(new PropertyValueFactory<Skill, Integer>("abilityModifier"));
		
		this.abilityModifierValueCol.setCellValueFactory(ov -> {
			return new SimpleStringProperty(Integer.toString(pcViewModel.getAbilityScoreModifier(pcViewModel.abilityModifierToInt(ov.getValue().abilityModifierProperty().getValue()))));
		});
		classSkillCol.setCellFactory(CheckBoxTableCell.forTableColumn(classSkillCol));
		
		//Class Skills Col
		this.classSkillCol.setCellValueFactory(ov -> {
			return pcViewModel.getCharacterSkillsObject().isClassSkill(ov.getValue());
		});
		classSkillCol.setCellFactory(CheckBoxTableCell.forTableColumn(classSkillCol));
		
		//Skill Ranks Col
		this.skillRanksCol.setCellValueFactory(ov -> {
			return pcViewModel.getSkillRanks(ov.getValue()).asObject();
		});
		
		//TODO: Figure out exactly how this works
		//Skill Ranks Col
		this.skillRanksCol.setCellFactory(tc -> {      
            TableCell<Skill, Integer> cell = new TableCell<Skill, Integer>() {
            	
            	private final SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory;
            	private final Spinner<Integer> skillRanksSpinner;
            	private final ChangeListener<Number> valueChangeListener; 
            	
            	{
            		valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
                    skillRanksSpinner = new Spinner<>(valueFactory);
                    skillRanksSpinner.setVisible(false);
                    setGraphic(skillRanksSpinner);
                    valueChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                        valueFactory.setValue(newValue.intValue());
                    };
                    skillRanksSpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
                        if (getItem() != null) {pcViewModel.setSkillRanks((Skill) this.getTableRow().getItem(), newValue);}
                    });
                }
            	
                @Override
                public void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    
                	if(item == null || empty) {
                		setText(null);
                		setStyle("");
                	}
                	else {
                		if ((Skill) this.getTableRow().getItem() != null) {
                			 valueFactory.setValue(pcViewModel.getSkillRanks((Skill) this.getTableRow().getItem()).intValue());	
                		}
                		SimpleIntegerProperty test = new SimpleIntegerProperty(item);
                		
                        test.addListener(valueChangeListener);
                        skillRanksSpinner.setVisible(true);
                        
                        totalSkillBonusCol.setCellValueFactory(ov -> {
                        	return pcViewModel.getSkillBonus(ov.getValue()).asObject();  
            			});
                        
                        totalSkillBonusCol.setVisible(false);
                        totalSkillBonusCol.setVisible(true);
                        setGraphic(skillRanksSpinner);
                    } 
                }
            };
            return cell;

	    });
		
		//Misc Mod Col
		this.miscSkillModCol.setCellValueFactory(ov -> {
	        return pcViewModel.getMiscSkillMod(ov.getValue()).asObject();
		});
		
		//Total Col
		this.totalSkillBonusCol.setCellValueFactory(ov -> {
	        return pcViewModel.getSkillBonus(ov.getValue()).asObject();
		});
	}

	public void selectSkillsButtonOnClick(ActionEvent event) {
		for (Skill skill : pcViewModel.getCharacterSkills()) {
			pcViewModel.setSkillRanks(skill, this.skillRanksCol.getCellData(skill));
			System.out.println(skill + ": " + this.skillRanksCol.getCellData(skill));
		}
	}
}
