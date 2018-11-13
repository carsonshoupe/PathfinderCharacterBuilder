package cPathfinderCharacterViewObjects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class CharacterBuilderMainPageView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/cPathfinderCharacterViewObjects/CharacterBuilderMainPage.fxml"));
		stage.setScene(new Scene(root));
	}

}
