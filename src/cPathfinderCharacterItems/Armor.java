package cPathfinderCharacterItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Armor extends Item {
	//Instance Variables:
	private SimpleStringProperty armorCheckPenalty;
	private SimpleStringProperty armorShieldBonus;
	private SimpleStringProperty arcaneSpellFailureChance;
	private SimpleStringProperty maximumDexBonus;
	private SimpleStringProperty speed20;
	private SimpleStringProperty speed30;
	
	//Constructor:
	
	//Methods:
	public String getArmorCheckPenalty() {return this.armorCheckPenalty.get();}
	public String getArmorShieldBonus() {return this.armorShieldBonus.get();}
	public String getArcaneSpellFailureChance() {return this.arcaneSpellFailureChance.get();}
	public String getMaximumDexBonus() {return this.maximumDexBonus.get();}
	public String getSpeed20() {return this.speed20.get();}
	public String getSpeed30() {return this.speed30.get();}
	
	public StringProperty armorCheckPenaltyProperty() { 
        if (this.armorCheckPenalty == null) this.armorCheckPenalty = new SimpleStringProperty(this, "armorCheckPenalty");
        return this.armorCheckPenalty; 
	}
	public StringProperty armorShieldBonusProperty() { 
        if (this.armorShieldBonus == null) this.armorShieldBonus = new SimpleStringProperty(this, "armorShieldBonus");
        return this.armorShieldBonus; 
	}
	public StringProperty arcaneSpellFailureChanceProperty() { 
        if (this.arcaneSpellFailureChance == null) this.arcaneSpellFailureChance = new SimpleStringProperty(this, "arcaneSpellFailureChance");
        return this.arcaneSpellFailureChance; 
	}
	public StringProperty maximumDexBonusProperty() { 
        if (this.maximumDexBonus == null) this.maximumDexBonus = new SimpleStringProperty(this, "maximumDexBonus");
        return this.maximumDexBonus; 
	}
	public StringProperty speed20Property() { 
        if (this.speed20 == null) this.speed20 = new SimpleStringProperty(this, "speed20");
        return this.speed20; 
	}
	public StringProperty speed30Property() { 
        if (this.speed30 == null) this.speed30 = new SimpleStringProperty(this, "speed30");
        return this.speed30; 
	}
	
	@Override 
	public String toString() {
		return this.getName() + ": \n" +
				this.getDescription() + "\n" +
				this.getCategory() + "\n" +
				this.getCost() + "\n" +
				this.getWeight() + "\n" +
				this.getArmorCheckPenalty() + "\n" +
				this.getArmorShieldBonus() + "\n" +
				this.getArcaneSpellFailureChance() + "\n" +
				this.getMaximumDexBonus() + "\n" +
				this.getSpeed20() + "\n" +
				this.getSpeed30() + "\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Armor)) {return false;}
		else {
			Armor armor = (Armor) o;
			if (this.getName().equals(armor.getName())) {return true;}
			else {return false;}
		}
	}
	
	@Override 
	public int hashCode() {
		return this.getName().hashCode();
	}
	
	

}
