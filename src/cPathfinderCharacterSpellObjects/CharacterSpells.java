package cPathfinderCharacterSpellObjects;

import java.util.ArrayList;
import java.util.Arrays;

import cPathfinderCharacterObjects.CharacterModifier;
import cPathfinderCharacterObjects.PathfinderCharacter;

public class CharacterSpells implements CharacterModifier {
	//Instance Variables:
	private int[] spellsToChoose;
	private int[] spellsPerDay = {Integer.MAX_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private ArrayList<ArrayList<Spell>> spellsByLevel = new ArrayList<ArrayList<Spell>>();
	
	//Constructors:
	public CharacterSpells() {
		
		//add empty spell arraylists
		for (int counter = 0; counter < 10; counter++) {
			this.spellsByLevel.add(new ArrayList<Spell>());
		}
	}
	
	
	//Methods:
	
	public int[] getSpellToChoose() {return this.spellsToChoose;}
	public int getSpellsToChoose(int spellLevel) {return this.spellsToChoose[spellLevel];}
	public void setSpellsToChoose(int[] classSpellsToChoose) {this.spellsToChoose = classSpellsToChoose;}
	
	public int getSpellsPerDay(int spellLevel) {return this.spellsPerDay[spellLevel];}
	public void incrementSpellsPerDay(int spellLevel, int value) {this.spellsPerDay[spellLevel] += value;}
	
	public ArrayList<Spell> getSpells(int spellLevel) {return this.spellsByLevel.get(spellLevel);}
	public void addSpell(int spellLevel, Spell spell) {this.spellsByLevel.get(spellLevel).add(spell);}
	

	public PathfinderCharacter updateCharacter(PathfinderCharacter pathfinderCharacter) {
		// TODO Auto-generated method stub
		return null;
	}

	public String modificationsToString() {
		// TODO Auto-generated method stub
		return null;
	}

}
