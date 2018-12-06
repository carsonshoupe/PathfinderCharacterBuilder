package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import javafx.scene.control.cell.TextFieldListCell;

public class FeatsTabControl implements Initializable {
	private PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	private ObservableList<String> featNames;
	private ObservableList<String> featNamesFiltered;
	
	@FXML ListView<String> featListView;
	@FXML Label featNameLabel;
	@FXML TextArea featDescriptionTA;
	@FXML TextArea featPrerequisiteTA;
	@FXML ComboBox<String> filtersCB;
	
	@FXML Button selectFeatButton;
	@FXML Button removeFeatButton;
	@FXML ListView<String> yourFeatsListView;
	@FXML Label errorLabel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		featNames = FXCollections.observableArrayList(Feat.getFeatNames());

		this.featListView.getItems().addAll(this.featNames);
		
		//Click on feat in featsListView displays text
		this.featListView.getSelectionModel().selectedItemProperty().addListener(cl -> {
			String featName = featListView.getSelectionModel().getSelectedItem();
			if (featName != null) {
	        	Feat feat = new Feat(Feat.formatFeatName(featName));
	        	featNameLabel.setText(featName);
	            featDescriptionTA.setText(feat.getBenefit());
	            if (feat.getFeatPrerequisite() == null) {
	            	featPrerequisiteTA.setText("None");
	            }
	            else {
	            	featPrerequisiteTA.setText(feat.getFeatPrerequisite().getFeatPrerequisiteAsText());
	            }
			}
    	});
		
		//Click on feat in yourFeatsListView displays text
		this.yourFeatsListView.getSelectionModel().selectedItemProperty().addListener(cl -> {
			String featName = yourFeatsListView.getSelectionModel().getSelectedItem();
			if (featName != null) {
	        	Feat feat = new Feat(Feat.formatFeatName(featName));
	        	featNameLabel.setText(featName);
	            featDescriptionTA.setText(feat.getBenefit());
	            if (feat.getFeatPrerequisite() == null) {
	            	featPrerequisiteTA.setText("None");
	            }
	            else {
	            	featPrerequisiteTA.setText(feat.getFeatPrerequisite().getFeatPrerequisiteAsText());
	            }
			}
    	});
		
		String[] tags = {"-All-", "Skill Bonus", "CMB", "Channel Energy", "Armor", "Magic", "Summoning", "Stealth",
				"Improvised Weapon", "Combat", "Defense", "Critical", "Ranged", "AC", "Agility", "Ki", "Heal", "Saves",
				"Initiative", "Unarmed", "Social", "Melee", "Craft", "Mount"};
		Arrays.sort(tags);
		
		this.filtersCB.getItems().addAll(tags);

	}
	
	@FXML public void filterFeats(ActionEvent event) {
		featNamesFiltered = FXCollections.observableArrayList(new ArrayList<String>());
		this.featListView.getItems().clear();
		if (this.filtersCB.getValue().equals("-All-")) {
			this.featListView.getItems().addAll(featNames);
		}
		else {
			for (String featName : this.featNames) {
				Feat feat = new Feat(Feat.formatFeatName(featName));
				if (feat.getTags().contains(this.filtersCB.getValue())) {
					featNamesFiltered.add(featName);
				}
			}
			this.featListView.getItems().addAll(featNamesFiltered);
		}
	}
	
	@FXML public void selectFeatButtonPress(ActionEvent event) {
		if (this.featListView.getSelectionModel().getSelectedItem() != null) {
			String featName = this.featListView.getSelectionModel().getSelectedItem();
			ObservableList<String> yourFeats = this.yourFeatsListView.getItems();
			if (yourFeats.contains(featName)) {
				errorLabel.setText("You already have this feat!");
			}
			else {
				yourFeatsListView.getItems().add(featName);
				this.pcViewModel.addFeat(new Feat(Feat.formatFeatName(featName)));
			}
		}
	}
	
	@FXML public void removeFeatButtonPress(ActionEvent event) {
		int itemToRemove = this.yourFeatsListView.getSelectionModel().getSelectedIndex();
		if (itemToRemove != -1) {
			pcViewModel.removeFeat(new Feat(Feat.formatFeatName(this.yourFeatsListView.getItems().get(itemToRemove))));
			this.yourFeatsListView.getItems().remove(itemToRemove);
		}
	}
	
	

}
