package cPathfinderCharacterItems;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	//Instance Variable:
	private SimpleStringProperty name;
	private SimpleStringProperty description;
	private SimpleStringProperty category;
	private SimpleStringProperty cost;
	private SimpleStringProperty weight;
	
	//Constructor
	
	//Methods:
	public String getName() {return this.name.get();}
	public String getDescription() {return this.description.get();}
	public String getCategory() {return this.category.get();}
	public String getCost() {return this.cost.get();}
	public String getWeight() {return this.weight.get();}
	
	public StringProperty nameProperty() { 
        if (this.name == null) this.name = new SimpleStringProperty(this, "name");
        return this.name; 
	}
	public StringProperty descriptionProperty() { 
        if (this.description == null) this.description = new SimpleStringProperty(this, "description");
        return this.description; 
	}
	public StringProperty categoryProperty() { 
        if (this.category == null) this.category = new SimpleStringProperty(this, "category");
        return this.category; 
	}
	public StringProperty costProperty() { 
        if (this.cost == null) this.cost = new SimpleStringProperty(this, "cost");
        return this.cost; 
	}
	public StringProperty weightProperty() { 
        if (this.weight == null) this.weight = new SimpleStringProperty(this, "weight");
        return this.weight; 
	}
}
