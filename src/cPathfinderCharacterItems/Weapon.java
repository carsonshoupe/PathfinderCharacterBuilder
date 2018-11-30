package cPathfinderCharacterItems;

import cPathfinderCharacterObjects.Sizes;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Weapon extends Item {
	//Instance Variables:
	private SimpleStringProperty subcategory;
	private SimpleStringProperty damageSmall;
	private SimpleStringProperty damageMedium;
	private SimpleStringProperty critical;
	private SimpleStringProperty range;
	private SimpleStringProperty damageType;
	private SimpleStringProperty special;
	
	//Constructors:
	
	//Methods:}
	public String getSubcategory() {return this.subcategory.get();}
	public String getDamageSmall() {return this.damageSmall.get();}
	public String getDamageMedium() {return this.damageMedium.get();}
	public String getDamage(Sizes size) {
		if (size == size.SMALL) {return this.damageSmall.get();}
		else if (size == size.MEDIUM) {return this.damageMedium.get();}
		else {return null;}
	}
	public String getCritical() {return this.critical.get();}
	public String getRange() {return this.range.get();}
	public String getDamageType() {return this.damageType.get();}
	public String getSpecial() {return this.special.get();}
	
	public StringProperty subcategoryProperty() { 
        if (this.subcategory == null) this.subcategory = new SimpleStringProperty(this, "subcategory");
        return this.subcategory; 
	}
	public StringProperty damageSmallProperty() { 
        if (this.damageSmall == null) this.damageSmall = new SimpleStringProperty(this, "damageSmall");
        return this.damageSmall; 
	}
	public StringProperty damageMediumProperty() { 
        if (this.damageMedium == null) this.damageMedium = new SimpleStringProperty(this, "damageMedium");
        return this.damageMedium; 
	}
	public StringProperty criticalProperty() { 
        if (this.critical == null) this.critical = new SimpleStringProperty(this, "critical");
        return this.critical; 
	}
	public StringProperty rangeProperty() { 
        if (this.range == null) this.range = new SimpleStringProperty(this, "range");
        return this.range; 
	}
	public StringProperty damageTypeProperty() { 
        if (this.damageType == null) this.damageType = new SimpleStringProperty(this, "damageType");
        return this.damageType; 
	}
	public StringProperty specialProperty() { 
        if (this.special == null) this.special = new SimpleStringProperty(this, "special");
        return this.special; 
	}
	
	@Override
	public String toString() {
		return this.getName() + ": \n" + 
				this.getDescription() + "\n" +
				this.getCost() + "\n" +
				this.getWeight() + "\n" +
				this.getRange() + "\n" +
				this.getDamage(Sizes.SMALL) + "\n" +
				this.getDamage(Sizes.MEDIUM) + "\n" +
				this.getCritical() + "\n" +
				this.getDamageType() + "\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Weapon)) {return false;}
		else {
			Weapon weapon = (Weapon) o;
			if (this.getName().equals(weapon.getName())) {return true;}
			else {return false;}
		}
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	
}