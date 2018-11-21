package cPathfinderCharacterViewObjects;

import cPathfinderCharacterClassObjects.Bard;
import cPathfinderCharacterControlObjects.MainPageControl;
import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
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
		PathfinderCharacter pc = new PathfinderCharacter();
		PathfinderCharacterViewModel pcViewModel = new PathfinderCharacterViewModel(pc);
		Bard b = new Bard(1);
		pcViewModel.setClassSkills(b.getClassSkills());
		pcViewModel.setAbilityScores(13, 8, 15, 17, 9, 12);
		pcViewModel.setCharacterName("Bob");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/cPathfinderCharacterViewObjects/CharacterBuilderMainPage.fxml"));
		stage.setScene(new Scene(loader.load()));
		
		MainPageControl mpc = (MainPageControl) loader.getController(); 
		mpc.setPcViewModel(pcViewModel); 
		
		/*
		Parent root = FXMLLoader.load(getClass().getResource("/cPathfinderCharacterViewObjects/CharacterBuilderMainPage.fxml"));
		stage.setScene(new Scene(root));
		*/
	}

}
