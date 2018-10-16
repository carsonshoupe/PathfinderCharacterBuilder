package cPathfinderCharacterObjects;

public class ClassFeature {
	//Instance Variables:
	private String name;
	private String classFeatureType;
	private int levelAccessible;
	private String fullDescription;
	private String shortenedDescription;
	
	
	//Constructors:
	public ClassFeature(String name) {
		this.name = name;
	}
	
	public ClassFeature(String name, String classFeatureType, int levelAccessable, String fullDescription, String shortenedDescription){
		this.name = name;
		this.classFeatureType = classFeatureType;
		this.levelAccessible = levelAccessable;
		this.fullDescription = fullDescription;
		this.shortenedDescription = shortenedDescription;
	}
	
	
	//Methods:
	public String getName() {return this.getName();}
	
	@Override
	public boolean equals(Object classFeature) {
		ClassFeature typeCastedClassFeature = (ClassFeature) classFeature;
		if (this.getName().equals(typeCastedClassFeature.getName())) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
