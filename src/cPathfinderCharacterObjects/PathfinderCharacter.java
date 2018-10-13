package cPathfinderCharacterObjects;

import java.util.ArrayList;

import cPathfinderCharacterRaceObjects.Race;
import cPathfinderCharacterSkillObjects.Skill;

public abstract class PathfinderCharacter {
	//Instance Variables: 
	protected String playerName;
	protected int characterId;
	
	protected String characterName;
	protected String gender; 
	protected int age;
	protected int height; //in inches
	protected int weight; 
	protected String hairColor; 
	protected String eyeColor; 
	protected String deity; 
	protected String homeland;
	protected Alignments alignment;

	
	protected Race race;
	protected Sizes size;
	protected int speed; //in feet
	protected String[] knownLanguages;
	
	protected ArrayList<Skill> classSkills;
	
	
	
	
	
	//Methods: 
	
	public void setRace(Race raceChoice) {
		this.race = raceChoice; 
		this.size = raceChoice.getSize();
		this.speed = raceChoice.getSpeed();
		this.knownLanguages = raceChoice.getKnownLanguages();
		/*
		** TODO: 
		** 1. race will update ability score with modifier 
		** 2. race will affect stats based on shouldUpdateCharacterSheet property of RacialTrait
		** 3. Even after selecting race, user still has to decide ability modifiers for some races 
		**    and extra languages if intelligence is high enough. -- need to find some way to queue to do list 
		**    in builder, but not in any particular order
		*/
	}
	
	public ArrayList<Skill> getClassSkills() {return this.classSkills;}
	
	enum Alignments {
		CHAOTICGOOD, NEUTRALGOOD, LAWFULGOOD, CHAOTICNEUTRAL, TRUENEUTRAL, LAWFULNEUTRAL, CHAOTICEVIL, NEUTRALEVIL, LAWFULEVIL
	}

}
