package cPathfinderCharacterControlObjects;

import java.net.URL;
import java.util.ResourceBundle;

import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TestTabControl implements Initializable {
	
	PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	@FXML
	private AnchorPane root;
	
	@FXML
	private Button testButton;
	
	@FXML
	private Label testLabel;
	
	@FXML
	private Label nameTestLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void testButtonClick(ActionEvent event) {
		this.testLabel.setText("YOOOOO");
	}
	public void updateName() {
		nameTestLabel.setText(pcViewModel.getCharacterName());
	}

}
