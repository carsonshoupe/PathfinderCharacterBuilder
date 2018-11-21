package cPathfinderCharacterViewObjects;

import cPathfinderCharacterControlObjects.TestTabControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PathfinderCharacterBuilderView extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("NewCharacter_LoadCharacter.fxml"));
			
			primaryStage.setTitle("Pathfinder Character Builder");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
