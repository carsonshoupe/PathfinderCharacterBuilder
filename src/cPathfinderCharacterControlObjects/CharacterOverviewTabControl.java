package cPathfinderCharacterControlObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import cPathfinderCharacterViewModelObjects.PathfinderCharacterViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterOverviewTabControl implements Initializable {
	PathfinderCharacterViewModel pcViewModel;
	public void setPcViewModel(PathfinderCharacterViewModel pcViewModel) {this.pcViewModel = pcViewModel;}
	
	private PDDocument characterSheet;
	
	@FXML ImageView characterSheetIV1;
	@FXML ImageView characterSheetIV2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("CharacterOverviewTabControl set up!");
		
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
		
		File file = new File("src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet.pdf");
		try {
			this.characterSheet = PDDocument.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleCharacterOverviewTabClick() {
		try {
			this.updateCharacterSheet();
			
			PDFRenderer renderer = new PDFRenderer(characterSheet);
			BufferedImage image1 = renderer.renderImageWithDPI(0, 300);
	    	BufferedImage image2 = renderer.renderImageWithDPI(1, 300);
	    	  
	    	Boolean imageOut1 = ImageIOUtil.writeImage(image1, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet1.png", 300);
	    	Boolean imageOut2 = ImageIOUtil.writeImage(image2, "src/cPathfinderCharacterControlObjects/Editable-Pathfinder-Character-Sheet2.png", 300);
	    	//System.out.println(imageOut1);
	    	//System.out.println(imageOut2);
	    	
	    	this.characterSheetIV1.setImage(new Image("File:src\\cPathfinderCharacterControlObjects\\Editable-Pathfinder-Character-Sheet1.png"));
	    	this.characterSheetIV1.fitWidthProperty();
	    	this.characterSheetIV1.preserveRatioProperty();
			this.characterSheetIV2.setImage(new Image("File:src\\cPathfinderCharacterControlObjects\\Editable-Pathfinder-Character-Sheet2.png"));
			this.characterSheetIV1.fitWidthProperty();
	    	this.characterSheetIV1.preserveRatioProperty();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCharacterSheet() {
		PDAcroForm form = this.characterSheet.getDocumentCatalog().getAcroForm();
		try {
			form.getField("Character Name").setValue(this.pcViewModel.getCharacterName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
