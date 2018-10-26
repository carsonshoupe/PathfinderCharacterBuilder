package cPathfinderCharacterClassObjects;

public class DruidNatureBond extends Druid {
	//Instance Variables:
	private String deity;
	private ClericDomain domain; 
	
	//Constructor: 
	DruidNatureBond(int level, ClericDomain domain) {
		super(level);
		this.domain = domain;
	}
	
	//Methods
	public String getDeity() {return this.deity;}
	public void setDeity(String deity) {this.deity = deity;}
	
	public ClericDomain getDomain() {return this.domain;}
	public void setDomain(ClericDomain domain) {	
		this.domain = domain;
		this.classFeatures.add(this.domain.getClassFeature1());
		if (this.level >= this.domain.getClassFeature2().getLevelAccessable()) {
			this.classFeatures.add(this.domain.getClassFeature2());
		}
	}
}
