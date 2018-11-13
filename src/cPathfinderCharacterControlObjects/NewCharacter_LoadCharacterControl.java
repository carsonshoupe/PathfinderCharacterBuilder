package cPathfinderCharacterControlObjects;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cPathfinderCharacterViewObjects.CharacterBuilderMainPageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sun.applet.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewCharacter_LoadCharacterControl implements Initializable {
	
	@FXML
	private Button newCharacterButton;

	public void initialize(URL arg0, ResourceBundle arg1) {
		//Nothing to do
	}
	
	public void newCharacterButtonClick(ActionEvent event) {
		Stage stage = (Stage) newCharacterButton.getScene().getWindow(); 
		stage.close();
		CharacterBuilderMainPageView mpv = new CharacterBuilderMainPageView();
		try {
			Stage newWindow = new Stage(); 
			newWindow.setTitle("Pathfinder Character Builder");
			mpv.start(newWindow);
			newWindow.show();
		}
		catch (Exception e) {
			System.out.println("New character button failed");
			e.printStackTrace();
	    }
	}
}

