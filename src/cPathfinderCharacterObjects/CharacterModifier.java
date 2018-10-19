package cPathfinderCharacterObjects;

public interface CharacterModifier {
	public PathfinderCharacter updateCharacter(PathfinderCharacter pathfinderCharacter);
	public String modificationsToString(); 
}
