package cPathfinderCharacterControlObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import cPathfinderCharacterFeatObjects.Feat;
import cPathfinderCharacterRaceObjects.RacialTrait;
import cPathfinderCharacterSkillObjects.Skill;
import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CharacterOverviewTabControl implements Initializable {
	PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	private PDDocument characterSheet;
	
	@FXML ImageView characterSheetIV1;
	@FXML ImageView characterSheetIV2;
	@FXML ProgressIndicator progressIndicator;
	@FXML VBox imageVB;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//System.out.println("CharacterOverviewTabControl set up!");
		
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		
		File file = new File("src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet.pdf");
		try {
			this.characterSheet = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(characterSheet);
			BufferedImage image1 = renderer.renderImageWithDPI(0, 300);
	    	BufferedImage image2 = renderer.renderImageWithDPI(1, 300);
	    	  
	    	Boolean imageOut1 = ImageIOUtil.writeImage(image1, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet1.png", 300);
	    	Boolean imageOut2 = ImageIOUtil.writeImage(image2, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet2.png", 300);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleCharacterOverviewTabClick() {
		this.progressIndicator.setVisible(true);
		this.progressIndicator.setProgress(0);
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					imageVB.setVisible(false);
					
					updateCharacterSheet();
					PDFRenderer renderer = new PDFRenderer(characterSheet);
					BufferedImage image1 = renderer.renderImageWithDPI(0, 300);
			    	BufferedImage image2 = renderer.renderImageWithDPI(1, 300);
			    	progressIndicator.setProgress(.25);
			    	  
			    	Boolean imageOut1 = ImageIOUtil.writeImage(image1, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet1.png", 300);
			    	progressIndicator.setProgress(.50);
			    	Boolean imageOut2 = ImageIOUtil.writeImage(image2, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet2.png", 300);
			    	
			    	characterSheetIV1.setImage(new Image("File:src\\cPathfinderCharacterControlObjects\\Editable-Pathfinder-Character-Sheet1.png"));
			    	characterSheetIV1.fitWidthProperty();
			    	characterSheetIV1.preserveRatioProperty();
			    	progressIndicator.setProgress(.75);
					characterSheetIV2.setImage(new Image("File:src\\cPathfinderCharacterControlObjects\\Editable-Pathfinder-Character-Sheet2.png"));
					characterSheetIV1.fitWidthProperty();
			    	characterSheetIV1.preserveRatioProperty();
			    	progressIndicator.setProgress(1);
			    	
			    	try {
			    		Thread.sleep(500);
			    	} catch (InterruptedException e) {}
			    	
			    	progressIndicator.setVisible(false);
			    	imageVB.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
	}
	
	private void updateCharacterSheet() {
		PDAcroForm form = this.characterSheet.getDocumentCatalog().getAcroForm();
		try {
			this.setCharacterTabFields(form);
			this.setRaceTabFields(form);
			this.setClassTabFields(form);
			this.setAbilityScoreTabFields(form);
			this.setSkillsTabFields(form);
			this.setFeatsTabFields(form);
			this.setSpellsTabFields(form);
			this.setItemsTabField(form);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setCharacterTabFields(PDAcroForm form) throws IOException {
		form.getField("Character Name").setValue(this.pcViewModel.getCharacterName());
		form.getField("Player").setValue(this.pcViewModel.getPlayerName());
		if (this.pcViewModel.getAlignment() != null) {form.getField("Alignment").setValue(this.pcViewModel.getAlignment().toString());}
		form.getField("Gender").setValue(this.pcViewModel.getGender());
		if (this.pcViewModel.getRace() != null) {
			form.getField("Age").setValue(this.pcViewModel.getAge(this.pcViewModel.getRace()));
			form.getField("Height").setValue(this.pcViewModel.getHeight(this.pcViewModel.getRace()));
			form.getField("Weight").setValue(this.pcViewModel.getWeight(this.pcViewModel.getRace()));
		}
		form.getField("Hair").setValue(this.pcViewModel.getHairColor());
		form.getField("Eyes").setValue(this.pcViewModel.getEyeColor());
		form.getField("Deity").setValue(this.pcViewModel.getDeity());
		form.getField("Homeland").setValue(this.pcViewModel.getHomeland());
	}
	
	private void setRaceTabFields(PDAcroForm form) throws IOException {
		if (!(this.pcViewModel.getRace() == null)) {
			
			form.getField("Race").setValue(this.pcViewModel.getRace().getName());
			form.getField("Size").setValue(this.pcViewModel.getRace().getSize().toString());
			
			String[] langaugesArr = this.pcViewModel.getRace().getKnownLanguages();
			StringBuilder languages = new StringBuilder();
			for (String language : langaugesArr) {
				languages.append(language + " ");
			}
			form.getField("Languages Line 1").setValue(languages.toString());
			
			//add racial trait names
			RacialTrait[] racialTraitsArr = this.pcViewModel.getRace().getRacialTraits();
			 //clears previous racial traits
			for (int counter = 1; counter < 6; counter++) {form.getField("Special Abilities " + counter).setValue("");}
			 //adds new racial traits
			int counter = 1;
			for (RacialTrait rt : racialTraitsArr) {
				form.getField("Special Abilities " + counter).setValue(rt.getName()); 
				counter++;
			}
		}
	}
	
	private void setClassTabFields(PDAcroForm form) throws IOException {
		
	}
	
	private void setAbilityScoreTabFields(PDAcroForm form) throws IOException {
		form.getField("Ability Score Strength").setValue(Integer.toString(this.pcViewModel.getStrength()));
		form.getField("Ability Modifier Strength").setValue(Integer.toString(this.pcViewModel.getStrenghModifier()));
		
		form.getField("Ability Score Dexterity").setValue(Integer.toString(this.pcViewModel.getDexterity()));
		form.getField("Ability Modifier Dexterity").setValue(Integer.toString(this.pcViewModel.getDexterityModifier()));
		
		form.getField("Ability Score Constitution").setValue(Integer.toString(this.pcViewModel.getConstitution()));
		form.getField("Ability Modifier Constitution").setValue(Integer.toString(this.pcViewModel.getConstitutionModifier()));
		
		form.getField("Ability Score Intelligence").setValue(Integer.toString(this.pcViewModel.getIntelligence()));
		form.getField("Ability Modifier Intelligence").setValue(Integer.toString(this.pcViewModel.getIntelligenceModifier()));
		
		form.getField("Ability Score Wisdom").setValue(Integer.toString(this.pcViewModel.getWisdom()));
		form.getField("Ability Modifier Wisdom").setValue(Integer.toString(this.pcViewModel.getWisdomModifier()));
		
		form.getField("Ability Score Charisma").setValue(Integer.toString(this.pcViewModel.getCharisma()));
		form.getField("Ability Modifier Charisma").setValue(Integer.toString(this.pcViewModel.getCharismaModifier()));
	}
	
	private void setSkillsTabFields(PDAcroForm form) throws IOException {
		SortedList<Skill> characterSkillsList = pcViewModel.getCharacterSkillsObject().getCharacterSkillsList();
		
		//Setting Skill Ranks
		for (int counter = 1; counter < 4; counter++) {
			form.getField("Ranks " + Integer.toString(counter)).setValue(Integer.toString(pcViewModel.getCharacterSkillsObject().getSkillRanks(characterSkillsList.get(counter-1)).getValue()));
		}
		for (int counter = 4; counter < 40; counter++) {
			form.getField("Rank " + Integer.toString(counter)).setValue(Integer.toString(pcViewModel.getCharacterSkillsObject().getSkillRanks(characterSkillsList.get(counter-1)).getValue()));
		}
		
		//Total Bonus
		for (int counter = 1; counter < 40; counter++) {
			form.getField("Total Bonus " + Integer.toString(counter)).setValue(Integer.toString(pcViewModel.getSkillBonus((characterSkillsList.get(counter-1))).getValue()));
		}
	}
	
	private void setFeatsTabFields(PDAcroForm form) throws IOException {
		//Reset Feats
		for (int counter = 1; counter < 14; counter++) {
			form.getField("Feat " + counter).setValue("");
		}
		
		//Set Feats
		Set<Feat> feats = pcViewModel.getFeats();
		int counter = 1;
		for (Feat feat : feats) {
			form.getField("Feat " + counter).setValue(feat.getName());
			counter++;
		}
	}
	
	private void setSpellsTabFields(PDAcroForm form) throws IOException {
		//TODO
	}
	
	private void setItemsTabField(PDAcroForm form) throws IOException {
		//TODO
	}
	
	

}
